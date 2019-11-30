package com.roma.elettorale.modelli3D.helpers;

import org.apache.commons.io.FilenameUtils;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.*;
import org.bouncycastle.util.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Component
public class ZipManager {


    @Autowired
    TransformationFile transformationFile;

    @Autowired
    Environment env;

    public HashMap<String, Document> unZipFolder(File fileToCheck) {
        HashMap<String, Document> files = new HashMap<>();
        try {
            ZipFile zip = new ZipFile(fileToCheck);
            for (Enumeration e = zip.entries(); e.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) e.nextElement();
                if (!entry.isDirectory()) {
                    if (FilenameUtils.getExtension(entry.getName()).equals("xml")) {
                        Document out = getTxtFiles(zip.getInputStream(entry));
                        files.put(entry.getName(), out);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return files;
    }

    public Document getTxtFiles(InputStream in) throws UnsupportedEncodingException {
        Document doc = null;
        try {
            Reader reader = new InputStreamReader(in, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
        } catch (IOException e) {
            // do something, probably not a text file
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public HashMap<String, Document> extractP7M(File f) throws IOException, CMSException {
        HashMap<String, Document> maps = new HashMap<String, Document>();
        String NomeFile =FilenameUtils.removeExtension(f.getName());
        byte[] buffer = new byte[(int) f.length()];
        DataInputStream in = new DataInputStream(new FileInputStream(f));
        in.readFully(buffer);
        in.close();
        /* Corresponding class of signed_data is CMSSignedData */
        CMSSignedData signature = new CMSSignedData(buffer);
        Store cs = signature.getCertificates();
        SignerInformationStore signers = signature.getSignerInfos();
        Collection c = signers.getSigners();
        Iterator it = c.iterator();
        //the following array will contain the content of xml document
        byte[] data = null;
        while (it.hasNext()) {
            SignerInformation signer = (SignerInformation) it.next();
            Collection certCollection = cs.getMatches(signer.getSID());
            Iterator certIt = certCollection.iterator();
            X509CertificateHolder cert = (X509CertificateHolder) certIt.next();
            CMSProcessable sc = signature.getSignedContent();
            data = (byte[]) sc.getContent();
        }
      String pathFile = env.getProperty("pathFileTemp");
      File outPutFile =  transformationFile.convertByteArrayToFile(data,pathFile+NomeFile);
      Optional<String> extensione = transformationFile.getExtensionByStringHandling(NomeFile);
      switch (extensione.get().toLowerCase())
      {
          case "zip":
          case "rar":
          case "gzip":
          case "tar":
          case "7z":
              maps = unZipFolder(outPutFile);
              break;
          case "xml":
              Document doc = transformationFile.ConvertFileToXmlDocument(outPutFile);
              maps.putIfAbsent(NomeFile,doc);
              break;
      }
      return  maps;
    }
}
