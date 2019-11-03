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
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per Destinatario complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Destinatario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="anno_protocollo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codice_destinatario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizione_destinatario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="progressivo_destinatario" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="progressivo_protocollo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="stato_destinatario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_destinatario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_protocollo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codice_utente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="data_carico" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="descrizione_utente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Destinatario", propOrder = {
    "annoProtocollo",
    "codiceDestinatario",
    "descrizioneDestinatario",
    "progressivoDestinatario",
    "progressivoProtocollo",
    "statoDestinatario",
    "tipoDestinatario",
    "tipoProtocollo",
    "codiceUtente",
    "dataCarico",
    "descrizioneUtente"
})
public class Destinatario {

    @XmlElement(name = "anno_protocollo")
    protected int annoProtocollo;
    @XmlElement(name = "codice_destinatario", required = true, nillable = true)
    protected String codiceDestinatario;
    @XmlElement(name = "descrizione_destinatario", required = true, nillable = true)
    protected String descrizioneDestinatario;
    @XmlElement(name = "progressivo_destinatario")
    protected int progressivoDestinatario;
    @XmlElement(name = "progressivo_protocollo")
    protected int progressivoProtocollo;
    @XmlElement(name = "stato_destinatario", required = true, nillable = true)
    protected String statoDestinatario;
    @XmlElement(name = "tipo_destinatario", required = true, nillable = true)
    protected String tipoDestinatario;
    @XmlElement(name = "tipo_protocollo", required = true, nillable = true)
    protected String tipoProtocollo;
    @XmlElement(name = "codice_utente", required = true, nillable = true)
    protected String codiceUtente;
    @XmlElement(name = "data_carico", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataCarico;
    @XmlElement(name = "descrizione_utente", required = true, nillable = true)
    protected String descrizioneUtente;

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
     * Recupera il valore della proprietà codiceDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceDestinatario() {
        return codiceDestinatario;
    }

    /**
     * Imposta il valore della proprietà codiceDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceDestinatario(String value) {
        this.codiceDestinatario = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneDestinatario() {
        return descrizioneDestinatario;
    }

    /**
     * Imposta il valore della proprietà descrizioneDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneDestinatario(String value) {
        this.descrizioneDestinatario = value;
    }

    /**
     * Recupera il valore della proprietà progressivoDestinatario.
     * 
     */
    public int getProgressivoDestinatario() {
        return progressivoDestinatario;
    }

    /**
     * Imposta il valore della proprietà progressivoDestinatario.
     * 
     */
    public void setProgressivoDestinatario(int value) {
        this.progressivoDestinatario = value;
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
     * Recupera il valore della proprietà statoDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoDestinatario() {
        return statoDestinatario;
    }

    /**
     * Imposta il valore della proprietà statoDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoDestinatario(String value) {
        this.statoDestinatario = value;
    }

    /**
     * Recupera il valore della proprietà tipoDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDestinatario() {
        return tipoDestinatario;
    }

    /**
     * Imposta il valore della proprietà tipoDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDestinatario(String value) {
        this.tipoDestinatario = value;
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
     * Recupera il valore della proprietà codiceUtente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceUtente() {
        return codiceUtente;
    }

    /**
     * Imposta il valore della proprietà codiceUtente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceUtente(String value) {
        this.codiceUtente = value;
    }

    /**
     * Recupera il valore della proprietà dataCarico.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataCarico() {
        return dataCarico;
    }

    /**
     * Imposta il valore della proprietà dataCarico.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataCarico(XMLGregorianCalendar value) {
        this.dataCarico = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneUtente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneUtente() {
        return descrizioneUtente;
    }

    /**
     * Imposta il valore della proprietà descrizioneUtente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneUtente(String value) {
        this.descrizioneUtente = value;
    }

}
