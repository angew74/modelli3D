//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.10.19 alle 12:14:52 PM CEST 
//


package com.roma.elettorale.modelli3D.entity.protocollo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="utente_connesso" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_protocollo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="anno_protocollo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="progressivo_protocollo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descrizione_file" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nome_file" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dimensione_file" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tipo_file" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="allegato" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
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
    "utenteConnesso",
    "tipoProtocollo",
    "annoProtocollo",
    "progressivoProtocollo",
    "descrizioneFile",
    "nomeFile",
    "dimensioneFile",
    "tipoFile",
    "allegato"
})
@XmlRootElement(name = "inserimentoAllegato")
public class InserimentoAllegato {

    @XmlElement(name = "codice_applicazione_chiamante", required = true, nillable = true)
    protected String codiceApplicazioneChiamante;
    @XmlElement(name = "password_applicazione_chiamante", required = true, nillable = true)
    protected String passwordApplicazioneChiamante;
    @XmlElement(name = "codice_procedura", required = true, nillable = true)
    protected String codiceProcedura;
    @XmlElement(name = "codice_documento", required = true, nillable = true)
    protected String codiceDocumento;
    @XmlElement(name = "utente_connesso", required = true, nillable = true)
    protected String utenteConnesso;
    @XmlElement(name = "tipo_protocollo", required = true, nillable = true)
    protected String tipoProtocollo;
    @XmlElement(name = "anno_protocollo", required = true, type = Integer.class, nillable = true)
    protected Integer annoProtocollo;
    @XmlElement(name = "progressivo_protocollo", required = true, type = Integer.class, nillable = true)
    protected Integer progressivoProtocollo;
    @XmlElement(name = "descrizione_file", required = true, nillable = true)
    protected String descrizioneFile;
    @XmlElement(name = "nome_file", required = true, nillable = true)
    protected String nomeFile;
    @XmlElement(name = "dimensione_file", required = true, type = Integer.class, nillable = true)
    protected Integer dimensioneFile;
    @XmlElement(name = "tipo_file", required = true, nillable = true)
    protected String tipoFile;
    @XmlElement(required = true)
    protected byte[] allegato;

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
     * Recupera il valore della proprietà utenteConnesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtenteConnesso() {
        return utenteConnesso;
    }

    /**
     * Imposta il valore della proprietà utenteConnesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtenteConnesso(String value) {
        this.utenteConnesso = value;
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
     * Recupera il valore della proprietà progressivoProtocollo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProgressivoProtocollo() {
        return progressivoProtocollo;
    }

    /**
     * Imposta il valore della proprietà progressivoProtocollo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProgressivoProtocollo(Integer value) {
        this.progressivoProtocollo = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneFile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneFile() {
        return descrizioneFile;
    }

    /**
     * Imposta il valore della proprietà descrizioneFile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneFile(String value) {
        this.descrizioneFile = value;
    }

    /**
     * Recupera il valore della proprietà nomeFile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeFile() {
        return nomeFile;
    }

    /**
     * Imposta il valore della proprietà nomeFile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeFile(String value) {
        this.nomeFile = value;
    }

    /**
     * Recupera il valore della proprietà dimensioneFile.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDimensioneFile() {
        return dimensioneFile;
    }

    /**
     * Imposta il valore della proprietà dimensioneFile.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDimensioneFile(Integer value) {
        this.dimensioneFile = value;
    }

    /**
     * Recupera il valore della proprietà tipoFile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoFile() {
        return tipoFile;
    }

    /**
     * Imposta il valore della proprietà tipoFile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoFile(String value) {
        this.tipoFile = value;
    }

    /**
     * Recupera il valore della proprietà allegato.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAllegato() {
        return allegato;
    }

    /**
     * Imposta il valore della proprietà allegato.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAllegato(byte[] value) {
        this.allegato = value;
    }

}
