package com.roma.elettorale.modelli3D.service;

import com.roma.elettorale.modelli3D.entity.protocollo.allegati.DettagliAllegato;
import com.roma.elettorale.modelli3D.entity.protocollo.ricerca.Allegato;
import com.roma.elettorale.modelli3D.entity.protocollo.ricerca.ArrayOf1319523186342555263NillableAllegato;
import com.roma.elettorale.modelli3D.entity.protocollo.ricerca.ProtocolloConAllegati;
import com.roma.elettorale.modelli3D.helpers.TransformationFile;
import com.roma.elettorale.modelli3D.helpers.ZipManager;
import com.roma.elettorale.modelli3D.helpers.enumerators.statusoperazione;
import com.roma.elettorale.modelli3D.helpers.enumerators.tipologiastream;
import com.roma.elettorale.modelli3D.unidoc.contract.IModelliService;
import com.roma.elettorale.modelli3D.unidoc.contract.IStreamService;
import com.roma.elettorale.modelli3D.unidoc.entity.mailmodelli;
import com.roma.elettorale.modelli3D.unidoc.entity.modelli;
import com.roma.elettorale.modelli3D.unidoc.entity.streamModelli;
import com.roma.elettorale.modelli3D.unidoc.service.StreamService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import javax.print.Doc;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Component
public class ElaborazioneModelli {


    private static final Logger log = LoggerFactory.getLogger(ElaborazioneModelli.class);

    @Autowired
    Environment env;

    @Autowired
    ProtocolloClient protocolloClient;

    @Autowired
    MailClient mailClient;

    @Autowired
    IStreamService streamService;

    @Autowired
    IModelliService modelliService;

    @Autowired
    ZipManager zipManager;

    @Autowired
    AnagrafeClient anagrafeClient;

    @Autowired
    TransformationFile transformationFile;

    public List<modelli> getModelliProtocolloForDate() {
        List<modelli> modellis = new ArrayList<>();
        String d = "";
        String df = "";
        try {
            Integer refidstream = streamService.getMaxId();
            streamModelli streamAllegati = new streamModelli();
            refidstream++;
            d = env.getProperty("dataInizioRicerca");
            df = env.getProperty("dataFineRicerca");
            String pathTemporanea = env.getProperty("pathFileTemp");
            Integer elaborati = 0;
            Integer scartati = 0;
            boolean ok = false;
            Integer y = LocalDate.now().getYear();
            StringBuilder s = new StringBuilder();
            ArrayList<ProtocolloConAllegati> protocolloConAllegatis = protocolloClient.RicercaProtocolloConAllegati(d, df, y, s);
            if (s.toString().equals("")) {
                if (protocolloConAllegatis.size() > 0) {
                    for (ProtocolloConAllegati p : protocolloConAllegatis) {
                        ArrayOf1319523186342555263NillableAllegato allegati = p.getAllegati();
                        if (allegati.getAllegato().size() > 0) {
                            for (Allegato a : allegati.getAllegato()) {
                                if (!(a.getNomeFile().toUpperCase().contains("SEGNATURA"))) {
                                    modelli m = new modelli();
                                    s = new StringBuilder();
                                    DettagliAllegato dettagliAllegato = protocolloClient.getAllegato(p, a.getIdentificativoAllegato(), s);
                                    if (s.toString().equals("")) {
                                        File fileToCheck = transformationFile.convertByteArrayToFile(dettagliAllegato.getFile(), pathTemporanea + dettagliAllegato.getNomeFile());
                                        Optional<String> extension = transformationFile.getExtensionByStringHandling(fileToCheck.getName());
                                        if (extension.isPresent()) {
                                            switch (extension.get().toLowerCase()) {
                                                case "xml":
                                                    byte[] file = null;
                                                    String codiceIndividuale = null;
                                                    String document = transformationFile.convertByteArrayToStringXml(dettagliAllegato.getFile());
                                                    Document docModello3D = transformationFile.convertStringToXMLDocument(document);
                                                    String codicefiscale = transformationFile.ParsingTag("cod_fisc", docModello3D);
                                                    if (!codicefiscale.equals("")) {
                                                        codiceIndividuale = anagrafeClient.GetCodindByCodFis(codicefiscale);
                                                        ok = saveModelloDaProtocollo(dettagliAllegato.getNomeFile(), document, p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.CARICATO, file);
                                                        elaborati++;
                                                    } else {
                                                        ok = saveModelloDaProtocollo(dettagliAllegato.getNomeFile(), document, p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, file);
                                                        scartati++;
                                                    }
                                                    break;
                                                case "zip":
                                                case "rar":
                                                case "gzip":
                                                case "tar":
                                                case "7z":
                                                    HashMap<String, Document> ffMap = zipManager.unZipFolder(fileToCheck);
                                                    Document documentModello3D = null;
                                                    if (ffMap.size() > 0) {
                                                        for (Map.Entry<String, Document> entry : ffMap.entrySet()) {
                                                            documentModello3D = entry.getValue();
                                                            codiceIndividuale = null;
                                                            codicefiscale = transformationFile.ParsingTag("cod_fisc", documentModello3D);
                                                            byte[] scarti = null;
                                                            if (!codicefiscale.equals("")) {
                                                                codiceIndividuale = anagrafeClient.GetCodindByCodFis(codicefiscale);
                                                                ok = saveModelloDaProtocollo(entry.getKey(), transformationFile.convertDocumentToString(documentModello3D), p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.CARICATO, scarti);
                                                                elaborati++;
                                                            } else {
                                                                ok = saveModelloDaProtocollo(entry.getKey(), transformationFile.convertDocumentToString(documentModello3D), p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, scarti);
                                                                scartati++;
                                                            }
                                                        }
                                                    } else {
                                                        codicefiscale = null;
                                                        codiceIndividuale = null;
                                                        byte[] scarti = transformationFile.convertFileToByteArray(fileToCheck);
                                                        ok = saveModelloDaProtocollo(fileToCheck.getName(), "", p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, scarti);
                                                        scartati++;
                                                    }
                                                    break;
                                                case "p7m":
                                                    HashMap<String, Document> ffMapp7m = zipManager.extractP7M(fileToCheck);
                                                    Document documentModello3DP7M = null;
                                                    if (ffMapp7m.size() > 0) {
                                                        for (Map.Entry<String, Document> entry : ffMapp7m.entrySet()) {
                                                            documentModello3DP7M = entry.getValue();
                                                            codiceIndividuale = null;
                                                            codicefiscale = transformationFile.ParsingTag("cod_fisc", documentModello3DP7M);
                                                            byte[] scarti = null;
                                                            if (!codicefiscale.equals("")) {
                                                                codiceIndividuale = anagrafeClient.GetCodindByCodFis(codicefiscale);
                                                                ok = saveModelloDaProtocollo(entry.getKey(), transformationFile.convertDocumentToString(documentModello3DP7M), p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.CARICATO, scarti);
                                                                elaborati++;
                                                            } else {
                                                                ok = saveModelloDaProtocollo(entry.getKey(), transformationFile.convertDocumentToString(documentModello3DP7M), p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, scarti);
                                                                scartati++;
                                                            }
                                                        }
                                                    } else {
                                                        codicefiscale = null;
                                                        codiceIndividuale = null;
                                                        byte[] scarti = transformationFile.convertFileToByteArray(fileToCheck);
                                                        ok = saveModelloDaProtocollo(fileToCheck.getName(), "", p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, scarti);
                                                        scartati++;
                                                    }
                                                    break;
                                                default:
                                                    codicefiscale = null;
                                                    codiceIndividuale = null;
                                                    String doc = "";
                                                    byte[] scarti = transformationFile.convertFileToByteArray(fileToCheck);
                                                    ok = saveModelloDaProtocollo(dettagliAllegato.getNomeFile(), doc, p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, scarti);
                                                    scartati++;
                                                    break;
                                            }
                                        }
                                    } else {
                                        saveModelloErrore(refidstream, s.toString(), statusoperazione.ERRORE, a.getNomeFile());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            streamAllegati.setTipologia(tipologiastream.PROTOCOLLO.ordinal());
            Integer totale = elaborati + scartati;
            streamAllegati.setNumerofile(totale);
            streamAllegati.setNumero(refidstream);
            streamAllegati.setNumeroelaborati(elaborati);
            streamAllegati.setDatacarimento(LocalDateTime.now());
            streamAllegati.setProgrammaCaricamento("CARICAMENTO");
            streamAllegati.setNumeroscarti(scartati);
            streamAllegati.setDataInizioSelezione(d);
            streamAllegati.setDataFineSelezione(df);
            //   streamAllegati.setId(refidstream);
            streamService.Save(streamAllegati);

        } catch (Exception ex) {
            log.error("ERR_99: " + ex.getMessage());
            ex.printStackTrace();

        }
        return modellis;
    }

    public List<modelli> getModelliMailForDate() {
        List<modelli> modellis = new ArrayList<>();
        ArrayList<mailmodelli> messageList = new ArrayList<mailmodelli>();
        List<String> mails = new ArrayList<>();
        mails.add("servizi.elettorali@pec.comune.roma.it");
        mails.add("servizi.elettorali2@pec.comune.roma.it");
        mails.add("servizi.elettorali3@pec.comune.roma.it");
        mails.add("servizi.elettorali4@pec.comune.roma.it");
        mails.add("servizi.elettorali5@pec.comune.roma.it");
        String d = "";
        String df = "";
        boolean ok = false;
        int elaborati = 0;
        int scartati = 0;
        Integer refidstream = streamService.getMaxId();
        streamModelli streamAllegati = new streamModelli();
        try {
            for (String mail : mails) {
                StringBuilder s = new StringBuilder();
                d = env.getProperty("dataInizioMail");
                df = env.getProperty("dataFineMail");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(d, formatter);
                LocalDate dateFinal = LocalDate.parse(df, formatter);
                LocalDate dateQuery = date;
                LocalDate dateQueryFinale = date.plusDays(1);
                while (dateQuery.isBefore(dateFinal)) {
                    ArrayList<mailmodelli> messageList1 = mailClient.getMessages(dateQuery, dateQueryFinale, mail, s);
                    messageList.addAll(messageList1);
                    dateQuery = dateQuery.plusDays(1);
                    dateQueryFinale = dateQueryFinale.plusDays(1);
                }
            }
            refidstream++;
            for (mailmodelli m : messageList) {
                String codiceIndividuale = "";
                Document docModello3D = m.getDocumentXML();
                if (docModello3D != null) {
                    String codicefiscale = transformationFile.ParsingTag("cod_fisc", docModello3D);
                    String nomeFile = m.getNomeFile();
                    String xmlString = transformationFile.convertDocumentToString(docModello3D);
                    if (!codicefiscale.equals("")) {
                        codiceIndividuale = anagrafeClient.GetCodindByCodFis(codicefiscale);
                        ok = saveModelloDaMail(nomeFile, xmlString, refidstream, codicefiscale, codiceIndividuale, statusoperazione.CARICATO, null,m.getMittente());
                        elaborati++;
                    } else {
                        byte[] scarto = transformationFile.convertDocumentToByteArray(docModello3D);
                        ok = saveModelloDaMail(nomeFile, "", refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, scarto,m.getMittente());
                        scartati++;
                    }
                } else {
                    String nomeFile = (String) m.getNomeFile();
                }
            }
        } catch (Exception ex) {
            log.error("ERR_98: " + ex.getMessage());
            ex.printStackTrace();
        }
        try {
            streamAllegati.setTipologia(tipologiastream.MAIL.ordinal());
            Integer totale = elaborati + scartati;
            streamAllegati.setNumerofile(totale);
            streamAllegati.setNumero(refidstream);
            streamAllegati.setNumeroelaborati(elaborati);
            streamAllegati.setDatacarimento(LocalDateTime.now());
            streamAllegati.setProgrammaCaricamento("CARICAMENTO");
            streamAllegati.setNumeroscarti(scartati);
            streamAllegati.setDataInizioSelezione(d);
            streamAllegati.setDataFineSelezione(df);
            //   streamAllegati.setId(refidstream);
            streamService.Save(streamAllegati);
        } catch (Exception ex) {
            log.error("ERR_98: " + ex.getMessage());
            ex.printStackTrace();
        }
        return modellis;
    }

    public boolean saveModelloErrore(Integer refidstream, String descrizioneErrore, statusoperazione status, String allegatoScarto) {
        boolean ok = false;
        modelli m = new modelli();
        try {
            m.setRefidstream(refidstream);
            m.setDescrizionefile(allegatoScarto);
            m.setDescrizioneerrore(descrizioneErrore);
            m.setFlgoperazione(status.ordinal());
            m.setDataoperazione(LocalDateTime.now());
            modelliService.Save(m);
            ok = true;
        } catch (Exception ex) {
            log.error("ERR_98: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ok;
    }

    public boolean saveModelloDaMail(String nomeFile, String doc, Integer refidstream, String codiceFiscale, String codiceIndividuale, statusoperazione status, byte[] fileScarto,String mittente) {
        boolean ok = false;
        try {
            String fileToWrite = "DAMAIL(" +
                    codiceFiscale + "_" + codiceIndividuale + ")#" +
                    nomeFile.replace(" ", "_");
            modelli m = new modelli();
            m.setDescrizionefile(fileToWrite);
            m.setFlgoperazione(status.ordinal());
            m.setDataoperazione(LocalDateTime.now());
            m.setCodicefiscale(codiceFiscale);
            m.setCodiceindividuale(codiceIndividuale);
            m.setMittente(mittente);
            // byte[] file = dettagliAllegato.getFile();
            if (!(doc.equals(""))) {
                m.setFileModello3D(doc);
            } else {
                m.setFileScartato(fileScarto);
            }
            m.setRefidstream(refidstream);
            modelliService.Save(m);
        } catch (Exception ex) {
            log.error("ERR_97: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ok;
    }

    public boolean saveModelloDaProtocollo(String nomeFile, String doc, ProtocolloConAllegati p, Integer refidstream, String codiceFiscale, String codiceIndividuale, statusoperazione status, byte[] fileScarto) {
        boolean ok = false;
        try {
            //   String nomeFile = dettagliAllegato.getNomeFile();
            nomeFile = nomeFile.replace("'", "");
            while (nomeFile.contains(" ")) {
                nomeFile = nomeFile.replace(" ", "_");
                log.debug("Tolto spazio " + nomeFile);
            }
            String rowProtocoll = p.getAnnoProtocollo() + ";" + p.getProgressivoProtocollo();
            String fileToWrite = "nprot(" + p.getTipoProtocollo() +
                    "-" + p.getAnnoProtocollo() +
                    "-" + p.getProgressivoProtocollo() + ")#" +
                    nomeFile.replace(" ", "_");
            String rowProtocollMapper = rowProtocoll +
                    "nprot(" + p.getTipoProtocollo() + "-" +
                    p.getAnnoProtocollo() +
                    "-" + p.getProgressivoProtocollo() + ")#" +
                    nomeFile.replace(" ", "_") + ";";
            modelli m = new modelli();
            m.setDescrizionefile(fileToWrite);
            m.setFlgoperazione(status.ordinal());
            m.setDataoperazione(LocalDateTime.now());
            m.setCodicefiscale(codiceFiscale);
            m.setCodiceindividuale(codiceIndividuale);
            String progressivo = Integer.toString(p.getProgressivoProtocollo());
            String anno = Integer.toString(p.getAnnoProtocollo());
            m.setNumeroprotocollo(progressivo);
            m.setAnnoprotocollo(anno);
            // byte[] file = dettagliAllegato.getFile();
            if (!(doc.equals(""))) {
                m.setFileModello3D(doc);
            } else {
                m.setFileScartato(fileScarto);
            }
            m.setRefidstream(refidstream);
            modelliService.Save(m);
        } catch (Exception ex) {
            log.error("ERR_98: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ok;
    }
}
