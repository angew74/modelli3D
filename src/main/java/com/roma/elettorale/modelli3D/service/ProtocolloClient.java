package com.roma.elettorale.modelli3D.service;


import com.roma.elettorale.modelli3D.configuration.SoapClientProtocolloAllegatiConfig;
import com.roma.elettorale.modelli3D.configuration.SoapClientProtocolloRicercaConfig;
import com.roma.elettorale.modelli3D.entity.protocollo.allegati.DettagliAllegato;
import com.roma.elettorale.modelli3D.entity.protocollo.allegati.ObjectFactory;
import com.roma.elettorale.modelli3D.entity.protocollo.allegati.VisualizzaAllegato;
import com.roma.elettorale.modelli3D.entity.protocollo.allegati.VisualizzaAllegatoResponse;
import com.roma.elettorale.modelli3D.entity.protocollo.ricerca.ProtocolloConAllegati;
import com.roma.elettorale.modelli3D.entity.protocollo.ricerca.RicercaProtocolli;
import com.roma.elettorale.modelli3D.entity.protocollo.ricerca.RicercaProtocolliResponse;
import com.roma.elettorale.modelli3D.helpers.TransformationFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import sun.net.www.http.HttpClient;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProtocolloClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ProtocolloClient.class);

    @Autowired
    Environment env;

    @Autowired
    TransformationFile transformationFile;


    public ArrayList<ProtocolloConAllegati> RicercaProtocolloConAllegati(String dataInizio, String dataFine, Integer Year, StringBuilder s) throws DatatypeConfigurationException {
        String urlRicercaProtocollo = env.getProperty("ricercaProtocolliService");
        ArrayList<ProtocolloConAllegati> listProtocolliConAllegati = new ArrayList<>();
        RicercaProtocolli ricercaProtocolli = configureRicerca();
        ricercaProtocolli.setAnnoProtocollo(Year);
        try {
            XMLGregorianCalendar dataInitius = transformationFile.convertToXMLGregorianCalendar(dataInizio);
            XMLGregorianCalendar dataFinis = transformationFile.convertToXMLGregorianCalendar(dataFine);
            ricercaProtocolli.setDataFine(dataFinis);
            ricercaProtocolli.setDataInizio(dataInitius);
            SoapClientProtocolloRicercaConfig soapClientCertiConfig = new SoapClientProtocolloRicercaConfig();
            WebServiceTemplate webServiceTemplate = soapClientCertiConfig.webServiceTemplate();
            webServiceTemplate.setDefaultUri(urlRicercaProtocollo);
            HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
            messageSender.setReadTimeout(3000000);
            webServiceTemplate.setMessageSender(messageSender);
            RicercaProtocolliResponse ricercaProtocolliResponse = (RicercaProtocolliResponse) webServiceTemplate.marshalSendAndReceive(ricercaProtocolli, new WebServiceMessageCallback() {
                public void doWithMessage(WebServiceMessage message) {
                    SaajSoapMessage soapMessage = (SaajSoapMessage) message;
                    // soapMessage.setSoapAction(env.getProperty("ricercaProtocolliService"));
                    //   soapMessage.setSoapAction("ricercaProtocolli");
                }
            });
            if (ricercaProtocolliResponse != null && ricercaProtocolliResponse.getRicercaProtocolliReturn() != null) {
                if (ricercaProtocolliResponse.getRicercaProtocolliReturn().getProtocolloConAllegati().size() > 0) {
                    if (ricercaProtocolliResponse.getRicercaProtocolliReturn().getProtocolloConAllegati().get(0).getErrore() != null) {
                        s.append(ricercaProtocolliResponse.getRicercaProtocolliReturn().getProtocolloConAllegati().get(0).getErrore().getDescrizioneErrore());
                    } else if (ricercaProtocolliResponse.getRicercaProtocolliReturn() != null && ricercaProtocolliResponse.getRicercaProtocolliReturn().getProtocolloConAllegati() != null) {
                        listProtocolliConAllegati = (ArrayList<ProtocolloConAllegati>) ricercaProtocolliResponse.getRicercaProtocolliReturn().getProtocolloConAllegati();
                    }
                }
            }

        } catch (Exception ex) {
            log.error("ERR_01: " + ex.getMessage());
            ex.printStackTrace();
        }
        return listProtocolliConAllegati;
    }

    public DettagliAllegato getAllegato(ProtocolloConAllegati protocolloConAllegati, Integer idallegato, StringBuilder s) {
        String urlAllegati = env.getProperty("allegatiService");
        SoapClientProtocolloAllegatiConfig soapClientCertiConfig = new SoapClientProtocolloAllegatiConfig();
        DettagliAllegato dettagliAllegato = null;
        try {
            WebServiceTemplate webServiceTemplate = soapClientCertiConfig.webServiceTemplate();
            webServiceTemplate.setDefaultUri(urlAllegati);
            VisualizzaAllegato visualizzaAllegato = configureVisualizzaAllegato(protocolloConAllegati, idallegato);
            VisualizzaAllegatoResponse visualizzaAllegatoResponse = (VisualizzaAllegatoResponse) webServiceTemplate.marshalSendAndReceive(visualizzaAllegato);
            if (visualizzaAllegatoResponse != null && visualizzaAllegatoResponse.getVisualizzaAllegatoReturn() != null) {
                if (visualizzaAllegatoResponse.getVisualizzaAllegatoReturn().getErrore() != null) {
                    s.append(visualizzaAllegatoResponse.getVisualizzaAllegatoReturn().getErrore().getDescrizioneErrore());
                }
                else {
                    dettagliAllegato = visualizzaAllegatoResponse.getVisualizzaAllegatoReturn();
                }
            }
        } catch (Exception ex) {
            log.error("ERR_02: " + ex.getMessage());
            ex.printStackTrace();
        }
        return dettagliAllegato;

    }

    VisualizzaAllegato configureVisualizzaAllegato(ProtocolloConAllegati protocolloConAllegati, int idallegato) {
        com.roma.elettorale.modelli3D.entity.protocollo.allegati.ObjectFactory objectFactoryProtocolloAllegati = new ObjectFactory();
        VisualizzaAllegato visualizzaAllegato = objectFactoryProtocolloAllegati.createVisualizzaAllegato();
        visualizzaAllegato.setAnnoProtocollo(protocolloConAllegati.getAnnoProtocollo());
        visualizzaAllegato.setCodiceApplicazioneChiamante(env.getProperty("codiceapplicazionechiamante"));
        visualizzaAllegato.setCodiceDocumento(env.getProperty("codicedocumento"));
        visualizzaAllegato.setCodiceProcedura(env.getProperty("codiceprocedura"));
        visualizzaAllegato.setPasswordApplicazioneChiamante(env.getProperty("passwordapplicazionechiamante"));
        visualizzaAllegato.setTipoProtocollo(env.getProperty("tipo_protocollo"));
        visualizzaAllegato.setProgressivoProtocollo(protocolloConAllegati.getProgressivoProtocollo());
        visualizzaAllegato.setProgressivoAllegato(idallegato);
        return visualizzaAllegato;
    }

    RicercaProtocolli configureRicerca() {
        com.roma.elettorale.modelli3D.entity.protocollo.ricerca.ObjectFactory objectFactory = new com.roma.elettorale.modelli3D.entity.protocollo.ricerca.ObjectFactory();
        RicercaProtocolli ricercaProtocolli = objectFactory.createRicercaProtocolli();
        ricercaProtocolli.setCodiceApplicazioneChiamante(env.getProperty("codiceapplicazionechiamante"));
        ricercaProtocolli.setCodiceDocumento(env.getProperty("codicedocumento"));
        ricercaProtocolli.setCodiceProcedura(env.getProperty("codiceprocedura"));
        ricercaProtocolli.setPasswordApplicazioneChiamante(env.getProperty("passwordapplicazionechiamante"));
        ricercaProtocolli.setUnitaOrganizzativaInCarico(env.getProperty("unita_organizzativa_in_carico"));
        return ricercaProtocolli;
    }

    // credenzialiTypeResponse = (RichiestaCredenzialiResponse) webServiceTemplate.marshalSendAndReceive(richiestaCredenziali, new WebServiceMessageCallback() {
}

