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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per Protocollo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Protocollo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="anno_protocollo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="data_arrivo_documento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="data_protocollo" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="data_protocollo_mittente" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="fascicolo" type="{http://protocollo.datatype.eng}Fascicolo"/&gt;
 *         &lt;element name="mittenti" type="{http://protocollo.datatype.eng}ArrayOfMittente"/&gt;
 *         &lt;element name="note_documento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ora_arrivo_documento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ora_protocollo" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="progressivo_protocollo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="protocollo_mittente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="testo_oggetto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_protocollo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="destinatari" type="{http://protocollo.datatype.eng}ArrayOfDestinatario"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Protocollo", propOrder = {
    "annoProtocollo",
    "dataArrivoDocumento",
    "dataProtocollo",
    "dataProtocolloMittente",
    "fascicolo",
    "mittenti",
    "noteDocumento",
    "oraArrivoDocumento",
    "oraProtocollo",
    "progressivoProtocollo",
    "protocolloMittente",
    "testoOggetto",
    "tipoProtocollo",
    "destinatari"
})
@XmlSeeAlso({
    ProtocolloErrore.class
})
public class Protocollo {

    @XmlElement(name = "anno_protocollo")
    protected int annoProtocollo;
    @XmlElement(name = "data_arrivo_documento", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataArrivoDocumento;
    @XmlElement(name = "data_protocollo", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataProtocollo;
    @XmlElement(name = "data_protocollo_mittente", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataProtocolloMittente;
    @XmlElement(required = true, nillable = true)
    protected Fascicolo fascicolo;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfMittente mittenti;
    @XmlElement(name = "note_documento", required = true, nillable = true)
    protected String noteDocumento;
    @XmlElement(name = "ora_arrivo_documento", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar oraArrivoDocumento;
    @XmlElement(name = "ora_protocollo", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar oraProtocollo;
    @XmlElement(name = "progressivo_protocollo")
    protected int progressivoProtocollo;
    @XmlElement(name = "protocollo_mittente", required = true, nillable = true)
    protected String protocolloMittente;
    @XmlElement(name = "testo_oggetto", required = true, nillable = true)
    protected String testoOggetto;
    @XmlElement(name = "tipo_protocollo", required = true, nillable = true)
    protected String tipoProtocollo;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfDestinatario destinatari;

    /**
     * Recupera il valore della proprietà annoProtocollo.
     * 
     */
    public int getAnnoProtocollo() {
        return annoProtocollo;
    }

    /**
     * Imposta il valore della proprietà annoProtocollo.
     * 
     */
    public void setAnnoProtocollo(int value) {
        this.annoProtocollo = value;
    }

    /**
     * Recupera il valore della proprietà dataArrivoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataArrivoDocumento() {
        return dataArrivoDocumento;
    }

    /**
     * Imposta il valore della proprietà dataArrivoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataArrivoDocumento(XMLGregorianCalendar value) {
        this.dataArrivoDocumento = value;
    }

    /**
     * Recupera il valore della proprietà dataProtocollo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataProtocollo() {
        return dataProtocollo;
    }

    /**
     * Imposta il valore della proprietà dataProtocollo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataProtocollo(XMLGregorianCalendar value) {
        this.dataProtocollo = value;
    }

    /**
     * Recupera il valore della proprietà dataProtocolloMittente.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataProtocolloMittente() {
        return dataProtocolloMittente;
    }

    /**
     * Imposta il valore della proprietà dataProtocolloMittente.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataProtocolloMittente(XMLGregorianCalendar value) {
        this.dataProtocolloMittente = value;
    }

    /**
     * Recupera il valore della proprietà fascicolo.
     * 
     * @return
     *     possible object is
     *     {@link Fascicolo }
     *     
     */
    public Fascicolo getFascicolo() {
        return fascicolo;
    }

    /**
     * Imposta il valore della proprietà fascicolo.
     * 
     * @param value
     *     allowed object is
     *     {@link Fascicolo }
     *     
     */
    public void setFascicolo(Fascicolo value) {
        this.fascicolo = value;
    }

    /**
     * Recupera il valore della proprietà mittenti.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMittente }
     *     
     */
    public ArrayOfMittente getMittenti() {
        return mittenti;
    }

    /**
     * Imposta il valore della proprietà mittenti.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMittente }
     *     
     */
    public void setMittenti(ArrayOfMittente value) {
        this.mittenti = value;
    }

    /**
     * Recupera il valore della proprietà noteDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteDocumento() {
        return noteDocumento;
    }

    /**
     * Imposta il valore della proprietà noteDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteDocumento(String value) {
        this.noteDocumento = value;
    }

    /**
     * Recupera il valore della proprietà oraArrivoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOraArrivoDocumento() {
        return oraArrivoDocumento;
    }

    /**
     * Imposta il valore della proprietà oraArrivoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOraArrivoDocumento(XMLGregorianCalendar value) {
        this.oraArrivoDocumento = value;
    }

    /**
     * Recupera il valore della proprietà oraProtocollo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOraProtocollo() {
        return oraProtocollo;
    }

    /**
     * Imposta il valore della proprietà oraProtocollo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOraProtocollo(XMLGregorianCalendar value) {
        this.oraProtocollo = value;
    }

    /**
     * Recupera il valore della proprietà progressivoProtocollo.
     * 
     */
    public int getProgressivoProtocollo() {
        return progressivoProtocollo;
    }

    /**
     * Imposta il valore della proprietà progressivoProtocollo.
     * 
     */
    public void setProgressivoProtocollo(int value) {
        this.progressivoProtocollo = value;
    }

    /**
     * Recupera il valore della proprietà protocolloMittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolloMittente() {
        return protocolloMittente;
    }

    /**
     * Imposta il valore della proprietà protocolloMittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolloMittente(String value) {
        this.protocolloMittente = value;
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
     * Recupera il valore della proprietà tipoProtocollo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoProtocollo() {
        return tipoProtocollo;
    }

    /**
     * Imposta il valore della proprietà tipoProtocollo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoProtocollo(String value) {
        this.tipoProtocollo = value;
    }

    /**
     * Recupera il valore della proprietà destinatari.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDestinatario }
     *     
     */
    public ArrayOfDestinatario getDestinatari() {
        return destinatari;
    }

    /**
     * Imposta il valore della proprietà destinatari.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDestinatario }
     *     
     */
    public void setDestinatari(ArrayOfDestinatario value) {
        this.destinatari = value;
    }

}
