//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.10.21 alle 10:29:35 AM CEST 
//


package com.roma.elettorale.modelli3D.entity.protocollo.ricerca;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codice_applicazione_chiamante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password_applicazione_chiamante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codice_procedura" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codice_documento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="anno_protocollo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="data_inizio" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ora_inizio" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="data_fine" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ora_fine" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="numero_progressivo_da" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numero_progressivo_a" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cod_doc_fisico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cod_doc_logico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cod_doc_sottologico" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nominativo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_ricerca_nominativo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="unita_organizzativa_in_carico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_ricerca_uo_in_carico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="unita_organizzativa_in_mittente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_ricerca_uo_in_mittente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="testo_oggetto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_ricerca_testo_oggetto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="testo_note" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_ricerca_testo_note" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="parametro1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="parametro2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="parametro3" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="parametro4" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codiceApplicazioneChiamante",
    "passwordApplicazioneChiamante",
    "codiceProcedura",
    "codiceDocumento",
    "annoProtocollo",
    "dataInizio",
    "oraInizio",
    "dataFine",
    "oraFine",
    "numeroProgressivoDa",
    "numeroProgressivoA",
    "codDocFisico",
    "codDocLogico",
    "codDocSottologico",
    "nominativo",
    "tipoRicercaNominativo",
    "unitaOrganizzativaInCarico",
    "tipoRicercaUoInCarico",
    "unitaOrganizzativaInMittente",
    "tipoRicercaUoInMittente",
    "testoOggetto",
    "tipoRicercaTestoOggetto",
    "testoNote",
    "tipoRicercaTestoNote",
    "parametro1",
    "parametro2",
    "parametro3",
    "parametro4"
})
@XmlRootElement(name = "ricercaProtocolli", namespace = "http://ws.protocollo.eng")
public class RicercaProtocolli {

    @XmlElement(name = "codice_applicazione_chiamante", required = true, nillable = true)
    protected String codiceApplicazioneChiamante;
    @XmlElement(name = "password_applicazione_chiamante", required = true, nillable = true)
    protected String passwordApplicazioneChiamante;
    @XmlElement(name = "codice_procedura", required = true, nillable = true)
    protected String codiceProcedura;
    @XmlElement(name = "codice_documento", required = true, nillable = true)
    protected String codiceDocumento;
    @XmlElement(name = "anno_protocollo", required = true, type = Integer.class, nillable = true)
    protected Integer annoProtocollo;
    @XmlElement(name = "data_inizio", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInizio;
    @XmlElement(name = "ora_inizio", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar oraInizio;
    @XmlElement(name = "data_fine", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFine;
    @XmlElement(name = "ora_fine", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar oraFine;
    @XmlElement(name = "numero_progressivo_da", required = true, type = Integer.class, nillable = true)
    protected Integer numeroProgressivoDa;
    @XmlElement(name = "numero_progressivo_a", required = true, type = Integer.class, nillable = true)
    protected Integer numeroProgressivoA;
    @XmlElement(name = "cod_doc_fisico", required = true, type = Integer.class, nillable = true)
    protected Integer codDocFisico;
    @XmlElement(name = "cod_doc_logico", required = true, type = Integer.class, nillable = true)
    protected Integer codDocLogico;
    @XmlElement(name = "cod_doc_sottologico", required = true, type = Integer.class, nillable = true)
    protected Integer codDocSottologico;
    @XmlElement(required = true, nillable = true)
    protected String nominativo;
    @XmlElement(name = "tipo_ricerca_nominativo", required = true, nillable = true)
    protected String tipoRicercaNominativo;
    @XmlElement(name = "unita_organizzativa_in_carico", required = true, nillable = true)
    protected String unitaOrganizzativaInCarico;
    @XmlElement(name = "tipo_ricerca_uo_in_carico", required = true, nillable = true)
    protected String tipoRicercaUoInCarico;
    @XmlElement(name = "unita_organizzativa_in_mittente", required = true, nillable = true)
    protected String unitaOrganizzativaInMittente;
    @XmlElement(name = "tipo_ricerca_uo_in_mittente", required = true, nillable = true)
    protected String tipoRicercaUoInMittente;
    @XmlElement(name = "testo_oggetto", required = true, nillable = true)
    protected String testoOggetto;
    @XmlElement(name = "tipo_ricerca_testo_oggetto", required = true, nillable = true)
    protected String tipoRicercaTestoOggetto;
    @XmlElement(name = "testo_note", required = true, nillable = true)
    protected String testoNote;
    @XmlElement(name = "tipo_ricerca_testo_note", required = true, nillable = true)
    protected String tipoRicercaTestoNote;
    @XmlElement(required = true, nillable = true)
    protected String parametro1;
    @XmlElement(required = true, nillable = true)
    protected String parametro2;
    @XmlElement(required = true, nillable = true)
    protected String parametro3;
    @XmlElement(required = true, nillable = true)
    protected String parametro4;

    /**
     * Recupera il valore della proprietà codiceApplicazioneChiamante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceApplicazioneChiamante() {
        return codiceApplicazioneChiamante;
    }

    /**
     * Imposta il valore della proprietà codiceApplicazioneChiamante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceApplicazioneChiamante(String value) {
        this.codiceApplicazioneChiamante = value;
    }

    /**
     * Recupera il valore della proprietà passwordApplicazioneChiamante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasswordApplicazioneChiamante() {
        return passwordApplicazioneChiamante;
    }

    /**
     * Imposta il valore della proprietà passwordApplicazioneChiamante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasswordApplicazioneChiamante(String value) {
        this.passwordApplicazioneChiamante = value;
    }

    /**
     * Recupera il valore della proprietà codiceProcedura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceProcedura() {
        return codiceProcedura;
    }

    /**
     * Imposta il valore della proprietà codiceProcedura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceProcedura(String value) {
        this.codiceProcedura = value;
    }

    /**
     * Recupera il valore della proprietà codiceDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceDocumento() {
        return codiceDocumento;
    }

    /**
     * Imposta il valore della proprietà codiceDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceDocumento(String value) {
        this.codiceDocumento = value;
    }

    /**
     * Recupera il valore della proprietà annoProtocollo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAnnoProtocollo() {
        return annoProtocollo;
    }

    /**
     * Imposta il valore della proprietà annoProtocollo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAnnoProtocollo(Integer value) {
        this.annoProtocollo = value;
    }

    /**
     * Recupera il valore della proprietà dataInizio.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInizio() {
        return dataInizio;
    }

    /**
     * Imposta il valore della proprietà dataInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInizio(XMLGregorianCalendar value) {
        this.dataInizio = value;
    }

    /**
     * Recupera il valore della proprietà oraInizio.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOraInizio() {
        return oraInizio;
    }

    /**
     * Imposta il valore della proprietà oraInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOraInizio(XMLGregorianCalendar value) {
        this.oraInizio = value;
    }

    /**
     * Recupera il valore della proprietà dataFine.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFine() {
        return dataFine;
    }

    /**
     * Imposta il valore della proprietà dataFine.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFine(XMLGregorianCalendar value) {
        this.dataFine = value;
    }

    /**
     * Recupera il valore della proprietà oraFine.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOraFine() {
        return oraFine;
    }

    /**
     * Imposta il valore della proprietà oraFine.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOraFine(XMLGregorianCalendar value) {
        this.oraFine = value;
    }

    /**
     * Recupera il valore della proprietà numeroProgressivoDa.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroProgressivoDa() {
        return numeroProgressivoDa;
    }

    /**
     * Imposta il valore della proprietà numeroProgressivoDa.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroProgressivoDa(Integer value) {
        this.numeroProgressivoDa = value;
    }

    /**
     * Recupera il valore della proprietà numeroProgressivoA.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroProgressivoA() {
        return numeroProgressivoA;
    }

    /**
     * Imposta il valore della proprietà numeroProgressivoA.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroProgressivoA(Integer value) {
        this.numeroProgressivoA = value;
    }

    /**
     * Recupera il valore della proprietà codDocFisico.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodDocFisico() {
        return codDocFisico;
    }

    /**
     * Imposta il valore della proprietà codDocFisico.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodDocFisico(Integer value) {
        this.codDocFisico = value;
    }

    /**
     * Recupera il valore della proprietà codDocLogico.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodDocLogico() {
        return codDocLogico;
    }

    /**
     * Imposta il valore della proprietà codDocLogico.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodDocLogico(Integer value) {
        this.codDocLogico = value;
    }

    /**
     * Recupera il valore della proprietà codDocSottologico.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodDocSottologico() {
        return codDocSottologico;
    }

    /**
     * Imposta il valore della proprietà codDocSottologico.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodDocSottologico(Integer value) {
        this.codDocSottologico = value;
    }

    /**
     * Recupera il valore della proprietà nominativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNominativo() {
        return nominativo;
    }

    /**
     * Imposta il valore della proprietà nominativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNominativo(String value) {
        this.nominativo = value;
    }

    /**
     * Recupera il valore della proprietà tipoRicercaNominativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRicercaNominativo() {
        return tipoRicercaNominativo;
    }

    /**
     * Imposta il valore della proprietà tipoRicercaNominativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRicercaNominativo(String value) {
        this.tipoRicercaNominativo = value;
    }

    /**
     * Recupera il valore della proprietà unitaOrganizzativaInCarico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitaOrganizzativaInCarico() {
        return unitaOrganizzativaInCarico;
    }

    /**
     * Imposta il valore della proprietà unitaOrganizzativaInCarico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitaOrganizzativaInCarico(String value) {
        this.unitaOrganizzativaInCarico = value;
    }

    /**
     * Recupera il valore della proprietà tipoRicercaUoInCarico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRicercaUoInCarico() {
        return tipoRicercaUoInCarico;
    }

    /**
     * Imposta il valore della proprietà tipoRicercaUoInCarico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRicercaUoInCarico(String value) {
        this.tipoRicercaUoInCarico = value;
    }

    /**
     * Recupera il valore della proprietà unitaOrganizzativaInMittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitaOrganizzativaInMittente() {
        return unitaOrganizzativaInMittente;
    }

    /**
     * Imposta il valore della proprietà unitaOrganizzativaInMittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitaOrganizzativaInMittente(String value) {
        this.unitaOrganizzativaInMittente = value;
    }

    /**
     * Recupera il valore della proprietà tipoRicercaUoInMittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRicercaUoInMittente() {
        return tipoRicercaUoInMittente;
    }

    /**
     * Imposta il valore della proprietà tipoRicercaUoInMittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRicercaUoInMittente(String value) {
        this.tipoRicercaUoInMittente = value;
    }

    /**
     * Recupera il valore della proprietà testoOggetto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestoOggetto() {
        return testoOggetto;
    }

    /**
     * Imposta il valore della proprietà testoOggetto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestoOggetto(String value) {
        this.testoOggetto = value;
    }

    /**
     * Recupera il valore della proprietà tipoRicercaTestoOggetto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRicercaTestoOggetto() {
        return tipoRicercaTestoOggetto;
    }

    /**
     * Imposta il valore della proprietà tipoRicercaTestoOggetto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRicercaTestoOggetto(String value) {
        this.tipoRicercaTestoOggetto = value;
    }

    /**
     * Recupera il valore della proprietà testoNote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestoNote() {
        return testoNote;
    }

    /**
     * Imposta il valore della proprietà testoNote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestoNote(String value) {
        this.testoNote = value;
    }

    /**
     * Recupera il valore della proprietà tipoRicercaTestoNote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRicercaTestoNote() {
        return tipoRicercaTestoNote;
    }

    /**
     * Imposta il valore della proprietà tipoRicercaTestoNote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRicercaTestoNote(String value) {
        this.tipoRicercaTestoNote = value;
    }

    /**
     * Recupera il valore della proprietà parametro1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParametro1() {
        return parametro1;
    }

    /**
     * Imposta il valore della proprietà parametro1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParametro1(String value) {
        this.parametro1 = value;
    }

    /**
     * Recupera il valore della proprietà parametro2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParametro2() {
        return parametro2;
    }

    /**
     * Imposta il valore della proprietà parametro2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParametro2(String value) {
        this.parametro2 = value;
    }

    /**
     * Recupera il valore della proprietà parametro3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParametro3() {
        return parametro3;
    }

    /**
     * Imposta il valore della proprietà parametro3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParametro3(String value) {
        this.parametro3 = value;
    }

    /**
     * Recupera il valore della proprietà parametro4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParametro4() {
        return parametro4;
    }

    /**
     * Imposta il valore della proprietà parametro4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParametro4(String value) {
        this.parametro4 = value;
    }

}
