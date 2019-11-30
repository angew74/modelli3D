package com.roma.elettorale.modelli3D.service;

import com.roma.elettorale.modelli3D.faxpec.contract.IMailCLOBFile;
import com.roma.elettorale.modelli3D.faxpec.contract.IMailInBoxService;
import com.roma.elettorale.modelli3D.faxpec.contract.IMailInBoxServiceFlusso;
import com.roma.elettorale.modelli3D.faxpec.entity.mailinbox;
import com.roma.elettorale.modelli3D.faxpec.entity.mailinboxflusso;
import com.roma.elettorale.modelli3D.helpers.TransformationFile;
import com.roma.elettorale.modelli3D.helpers.ZipManager;
import com.roma.elettorale.modelli3D.helpers.enumerators.statusoperazione;
import com.roma.elettorale.modelli3D.unidoc.entity.mailmodelli;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.util.MimeMessageParser;
import org.bouncycastle.cms.CMSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.print.Doc;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Clob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

@Component
public class MailClient {


    private static final Logger log = LoggerFactory.getLogger(MailClient.class);
    private static final boolean SAVE_ATTACHMENTS_LOCALLY = true;

    @Autowired
    Environment env;

    @Autowired
    TransformationFile transformationFile;

    @Autowired
    ZipManager zipManager;

    @Autowired
    IMailInBoxService mailInBoxService;

    @Autowired
    IMailCLOBFile mailCLOBFile;

    @Autowired
    IMailInBoxServiceFlusso mailInBoxServiceFlusso;


    public ArrayList<mailmodelli> getMessages(LocalDate datainizio, LocalDate datafine, String mailAccount, StringBuilder s) {
        ArrayList<mailmodelli> list = new ArrayList<>();
        String mailFolder = env.getProperty("mailfolder");
        try {
            Integer folderid = Integer.parseInt(env.getProperty("folderid"));
            List<mailinbox> mailinboxes = mailInBoxService.findByDataricezioneBetweenAndMailfolderAndMailtoAndFlgattachements(datainizio, datafine, mailFolder, mailAccount, "1", folderid);
            for (mailinbox m : mailinboxes) {
                if (!m.getMailfrom().toLowerCase().contains("servizi.elettorali@pec.comune.roma.it")) {
                    List<mailinboxflusso> mailinboxflussis = mailInBoxServiceFlusso.findByRefidmailAndUtenteAndStatusmailnew(m.getIdmail(), env.getProperty("utentepec"), env.getProperty("statusletta"));
                   // if (mailinboxflussis.size() == 0) {
                        Clob c = mailCLOBFile.getMailRaw(m.getMailserverid(), mailAccount);
                        byte[] mbyte = IOUtils.toByteArray(c.getAsciiStream());
                        HashMap<String, Document> messageListl = GetAttachementsBis(mbyte);
                        messageListl.forEach((k, v) -> {
                            mailmodelli mm = new mailmodelli();
                            mm.setIdmail(m.getMailserverid());
                            mm.setMittente(m.getMailfrom());
                            mm.setDocumentXML(v);
                            mm.setNomeFile(k);
                            list.add(mm);
                        });
                  //  }
                }

            }
        } catch (Exception ex) {
            log.error(ex.getMessage() + " " + ex.getStackTrace());
            ex.printStackTrace();
        }
        return list;
    }



    private HashMap<String, Document> extractAttachments(Multipart multiPart, Map<String, String> attachmentAndName) {
        String path = env.getProperty("pathFileTemp");
        HashMap<String, Document> messageList = new HashMap<>();
        try {
            for (int i = 0; i < multiPart.getCount(); i++) {
                BodyPart part = multiPart.getBodyPart(i);
                if (part.getContent() instanceof Multipart) {
                    messageList = extractAttachments((Multipart) part.getContent(), attachmentAndName);
                } else if (part instanceof MimeBodyPart) {
                    MimeBodyPart mimeBodyPart = (MimeBodyPart) part;
                    String fileName = mimeBodyPart.getFileName();
                    if (Part.ATTACHMENT.equalsIgnoreCase(mimeBodyPart.getDisposition())) {
                        if (SAVE_ATTACHMENTS_LOCALLY) {
                            Optional<String> ext = transformationFile.getExtensionByStringHandling(fileName);
                            if (ext.get().toLowerCase().equals("eml")) {
                                MimeMessage m = (MimeMessage) mimeBodyPart.getContent();
                                MimeMessageParser parser = new MimeMessageParser(m);
                                Multipart mp = (Multipart) m.getContent();
                                for (int k = 0; k < mp.getCount(); k++) {
                                    BodyPart b = mp.getBodyPart(k);
                                    String cb = b.getContentType();
                                    if (cb.toLowerCase().contains("text/xml")) {
                                        byte[] outXml = transformationFile.convertInputStreamToByteArray(b.getInputStream());
                                        String fileNameXml = b.getFileName();
                                        if (!(fileNameXml.toUpperCase().contains("SEGNATURA"))) {
                                            transformationFile.wrtiteToDisk(path + fileNameXml, outXml);
                                            String xmlString = transformationFile.convertByteArrayToStringXml(outXml);
                                            Document docXml = transformationFile.convertStringToXMLDocument(xmlString);
                                            messageList.put(fileNameXml, docXml);
                                        }
                                    }
                                    if (cb.toLowerCase().contains("p7m")) {
                                        byte[] outXml = transformationFile.convertInputStreamToByteArray(b.getInputStream());
                                        String fileNameP7M = b.getFileName();
                                        File fileToCheck = transformationFile.convertByteArrayToFile(outXml, fileNameP7M);
                                        HashMap<String, Document> maps = zipManager.extractP7M(fileToCheck);
                                        maps.forEach(messageList::putIfAbsent);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException | MessagingException e) {
            log.error("Failed to process attachment. Continuing to process other message parts in search of attachments...");
            e.printStackTrace();
        } catch (CMSException e) {
            e.printStackTrace();
        }
        return messageList;
    }

    private HashMap<String, Document> GetAttachementsBis(byte[] mailArray) {
        HashMap<String, Document> modelliAttachements = new HashMap<>();
        Map<String, String> s = new HashMap<>();
        try {
            Session newSession = Session.getDefaultInstance(new Properties());
            InputStream inputStreamObj = new ByteArrayInputStream(mailArray);
            MimeMessage mimeMessageObj = new MimeMessage(newSession, inputStreamObj);
            MimeMessageParser parser = new MimeMessageParser(mimeMessageObj);
            String contentType = mimeMessageObj.getContentType();
            if (contentType.contains("multipart")) //Content may contain attachments
            {
                Multipart multiPart = (Multipart) mimeMessageObj.getContent();
                modelliAttachements = extractAttachments(multiPart, s);
            }

        } catch (
                Exception ex) {
            log.error(ex.getMessage() + " " + ex.getStackTrace());
        }
        return modelliAttachements;
    }
/*
    private HashMap<String, Document> GetAttachements(byte[] mailArray) {
        HashMap<String, Document> modelliAttachements = new HashMap<>();
        try {
            //  final byte[] mailMessageString = mailArray;
            Session newSession = Session.getDefaultInstance(new Properties());
            InputStream inputStreamObj = new ByteArrayInputStream(mailArray);
            MimeMessage mimeMessageObj = new MimeMessage(newSession, inputStreamObj);
            String contentType = mimeMessageObj.getContentType();
            if (contentType.contains("multipart")) //Content may contain attachments
            {
                Multipart multiPart = (Multipart) mimeMessageObj.getContent();
                int numberOfParts = multiPart.getCount();
                for (int partCount = 0; partCount < numberOfParts; partCount++) {
                    MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                    if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) //This part is an attachment
                    {
                        modelliAttachements = getInnerAttachements(part.getInputStream(), part.getFileName());
                    } else {

                        modelliAttachements = checkInnerPart(part);
                    }
                }
            } else {
                modelliAttachements = GetAttachements(contentType.getBytes());
            }
        } catch (Exception ex) {
            log.error(ex.getMessage() + " " + ex.getStackTrace());
        }
        return modelliAttachements;
    }


    private HashMap<String, Document> checkInnerPart(MimeBodyPart part) throws MessagingException, IOException {

        HashMap<String, Document> modelliAttachements = new HashMap<>();
        Session newSession = Session.getDefaultInstance(new Properties());
        MimeMessage mimeMessage = new MimeMessage(newSession, part.getInputStream());
        String contentType = mimeMessage.getContentType();
        if (mimeMessage.isMimeType("multipart/*")) {
            Multipart multiPartMessage = (Multipart) mimeMessage.getContent();
            int numberOfPartsMessage = multiPartMessage.getCount();
            for (int partCountMessage = 0; partCountMessage < numberOfPartsMessage; partCountMessage++) {
                MimeBodyPart partMessage = (MimeBodyPart) multiPartMessage.getBodyPart(partCountMessage);
                String disp = part.getDisposition();
                if (disp != null && disp.equalsIgnoreCase(Part.ATTACHMENT)) {
                    modelliAttachements = getInnerAttachements(partMessage.getInputStream(), partMessage.getFileName());
                } else {
                    modelliAttachements = checkInnerPart(partMessage);
                }
            }
        } else if (mimeMessage.isMimeType("text/*")) {
            getInnerAttachements(mimeMessage.getInputStream(), mimeMessage.getFileName());
        } else if (!(mimeMessage.isMimeType("text/*")) && !(mimeMessage.isMimeType("multipart/*"))) {
            modelliAttachements = getInnerAttachements(mimeMessage.getInputStream(), mimeMessage.getFileName());
        }
        return modelliAttachements;
    }

    private HashMap<String, Document> getInnerAttachements(InputStream inputStream, String fileName) throws IOException {
        String path = env.getProperty("pathFileTemp");
        File fileSave = new File(path + fileName);
        byte[] bytes = transformationFile.convertInputStreamToByteArray(inputStream);
        transformationFile.wrtiteToDisk(path + fileName, bytes);
        // part.saveFile(fileSave);
        HashMap<String, Document> modelliAttachements = new HashMap<>();
        InputStream is = inputStream;
        Optional<String> extension = transformationFile.getExtensionByStringHandling(fileSave.getName());
        if (extension.isPresent()) {
            switch (extension.get()) {
                case "xml":
                    byte[] buf = transformationFile.convertInputStreamToByteArray(is);
                    String doc = transformationFile.convertByteArrayToStringXml(buf);
                    Document document = transformationFile.convertStringToXMLDocument(doc);
                    modelliAttachements.put(fileName, document);
                    fileSave.delete();
                    break;
                case "zip":
                case "rar":
                case "gzip":
                case "tar":
                case "7z":
                    byte[] bufzip = transformationFile.convertInputStreamToByteArray(is);
                    modelliAttachements = zipManager.unZipFolder(fileSave);
                    fileSave.delete();
                    break;
            }
        }
        return modelliAttachements;
    }*/
}


