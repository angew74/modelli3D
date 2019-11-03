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
            // Integer refidstream = 0;
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
                                                        ok = saveModello(dettagliAllegato.getNomeFile(), document, p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.CARICATO, file);
                                                        elaborati++;
                                                    } else {
                                                        ok = saveModello(dettagliAllegato.getNomeFile(), document, p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, file);
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
                                                            docModello3D = entry.getValue();
                                                            codiceIndividuale = null;
                                                            codicefiscale = transformationFile.ParsingTag("cod_fisc", docModello3D);
                                                            byte[] scarti = null;
                                                            if (!codicefiscale.equals("")) {
                                                                codiceIndividuale = anagrafeClient.GetCodindByCodFis(codicefiscale);
                                                                ok = saveModello(entry.getKey(), transformationFile.convertDocumentToString(docModello3D), p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.CARICATO, scarti);
                                                                elaborati++;
                                                            } else {
                                                                ok = saveModello(entry.getKey(), transformationFile.convertDocumentToString(docModello3D), p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, scarti);
                                                                scartati++;
                                                            }
                                                        }
                                                    } else {
                                                        codicefiscale = null;
                                                        codiceIndividuale = null;
                                                        byte[] scarti = transformationFile.convertFileToByteArray(fileToCheck);
                                                        ok = saveModello(fileToCheck.getName(), "", p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, scarti);
                                                        scartati++;
                                                    }
                                                    break;
                                                default:
                                                    codicefiscale = null;
                                                    codiceIndividuale = null;
                                                    String doc = "";
                                                    byte[] scarti = transformationFile.convertFileToByteArray(fileToCheck);
                                                    ok = saveModello(dettagliAllegato.getNomeFile(), doc, p, refidstream, codicefiscale, codiceIndividuale, statusoperazione.ERRORE, scarti);
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
        String d = "";
        String df = "";
        try {
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

    public boolean saveModello(String nomeFile, String doc, ProtocolloConAllegati p, Integer refidstream, String codiceFiscale, String codiceIndividuale, statusoperazione status, byte[] fileScarto) {
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
