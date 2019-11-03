//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.10.19 alle 12:14:52 PM CEST 
//


package com.roma.elettorale.modelli3D.entity.protocollo.allegati;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DettagliAllegato complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DettagliAllegato"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipo_protocollo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="anno_protocollo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numero_protocollo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="id_file" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nome_file" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="virual_path" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizione_file" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dimensione_file" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="id_hash" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="identificativo_hash_originale" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="identificativo_file_originale" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="file" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="motivoAnnullamento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errore" type="{http://data.protocollazione.protocollo.eng}Errore"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettagliAllegato", namespace = "http://data.protocollazione.protocollo.eng", propOrder = {
    "tipoProtocollo",
    "annoProtocollo",
    "numeroProtocollo",
    "idFile",
    "nomeFile",
    "path",
    "virualPath",
    "descrizioneFile",
    "dimensioneFile",
    "idHash",
    "identificativoHashOriginale",
    "identificativoFileOriginale",
    "file",
    "motivoAnnullamento",
    "errore"
})
public class DettagliAllegato {

    @XmlElement(name = "tipo_protocollo", required = true, nillable = true)
    protected String tipoProtocollo;
    @XmlElement(name = "anno_protocollo", required = true, nillable = true)
    protected String annoProtocollo;
    @XmlElement(name = "numero_protocollo", required = true, nillable = true)
    protected String numeroProtocollo;
    @XmlElement(name = "id_file", required = true, nillable = true)
    protected String idFile;
    @XmlElement(name = "nome_file", required = true, nillable = true)
    protected String nomeFile;
    @XmlElement(required = true, nillable = true)
    protected String path;
    @XmlElement(name = "virual_path", required = true, nillable = true)
    protected String virualPath;
    @XmlElement(name = "descrizione_file", required = true, nillable = true)
    protected String descrizioneFile;
    @XmlElement(name = "dimensione_file", required = true, nillable = true)
    protected String dimensioneFile;
    @XmlElement(name = "id_hash", required = true, nillable = true)
    protected String idHash;
    @XmlElement(name = "identificativo_hash_originale", required = true, nillable = true)
    protected String identificativoHashOriginale;
    @XmlElement(name = "identificativo_file_originale", required = true, nillable = true)
    protected String identificativoFileOriginale;
    @XmlElement(required = true)
    protected byte[] file;
    @XmlElement(required = true, nillable = true)
    protected String motivoAnnullamento;
    @XmlElement(required = true, nillable = true)
    protected Errore errore;

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
     *     {@link String }
     *     
     */
    public String getAnnoProtocollo() {
        return annoProtocollo;
    }

    /**
     * Imposta il valore della proprietà annoProtocollo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoProtocollo(String value) {
        this.annoProtocollo = value;
    }

    /**
     * Recupera il valore della proprietà numeroProtocollo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroProtocollo() {
        return numeroProtocollo;
    }

    /**
     * Imposta il valore della proprietà numeroProtocollo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroProtocollo(String value) {
        this.numeroProtocollo = value;
    }

    /**
     * Recupera il valore della proprietà idFile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFile() {
        return idFile;
    }

    /**
     * Imposta il valore della proprietà idFile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFile(String value) {
        this.idFile = value;
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
     * Recupera il valore della proprietà path.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Imposta il valore della proprietà path.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Recupera il valore della proprietà virualPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirualPath() {
        return virualPath;
    }

    /**
     * Imposta il valore della proprietà virualPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirualPath(String value) {
        this.virualPath = value;
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
     * Recupera il valore della proprietà dimensioneFile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimensioneFile() {
        return dimensioneFile;
    }

    /**
     * Imposta il valore della proprietà dimensioneFile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimensioneFile(String value) {
        this.dimensioneFile = value;
    }

    /**
     * Recupera il valore della proprietà idHash.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdHash() {
        return idHash;
    }

    /**
     * Imposta il valore della proprietà idHash.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdHash(String value) {
        this.idHash = value;
    }

    /**
     * Recupera il valore della proprietà identificativoHashOriginale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativoHashOriginale() {
        return identificativoHashOriginale;
    }

    /**
     * Imposta il valore della proprietà identificativoHashOriginale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativoHashOriginale(String value) {
        this.identificativoHashOriginale = value;
    }

    /**
     * Recupera il valore della proprietà identificativoFileOriginale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativoFileOriginale() {
        return identificativoFileOriginale;
    }

    /**
     * Imposta il valore della proprietà identificativoFileOriginale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativoFileOriginale(String value) {
        this.identificativoFileOriginale = value;
    }

    /**
     * Recupera il valore della proprietà file.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFile() {
        return file;
    }

    /**
     * Imposta il valore della proprietà file.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFile(byte[] value) {
        this.file = value;
    }

    /**
     * Recupera il valore della proprietà motivoAnnullamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoAnnullamento() {
        return motivoAnnullamento;
    }

    /**
     * Imposta il valore della proprietà motivoAnnullamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoAnnullamento(String value) {
        this.motivoAnnullamento = value;
    }

    /**
     * Recupera il valore della proprietà errore.
     * 
     * @return
     *     possible object is
     *     {@link Errore }
     *     
     */
    public Errore getErrore() {
        return errore;
    }

    /**
     * Imposta il valore della proprietà errore.
     * 
     * @param value
     *     allowed object is
     *     {@link Errore }
     *     
     */
    public void setErrore(Errore value) {
        this.errore = value;
    }

}
