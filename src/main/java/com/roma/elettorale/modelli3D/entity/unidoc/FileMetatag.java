
package com.roma.elettorale.modelli3D.entity.unidoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per FileMetatag complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="FileMetatag">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RefIdPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MajorVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DataInserimento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Metadati" type="{}ArrayOfMetadato" minOccurs="0"/>
 *         &lt;element name="Versione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Estensione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NomeOriginale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UtenteInserimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdFolder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PathFolder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RifIdRegistro" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NomeFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdDoc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdVerisonePrecedente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdFile" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NomeFolder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileMetatag", namespace = "", propOrder = {
    "refIdPadre",
    "majorVersion",
    "dataInserimento",
    "tipoDocumento",
    "metadati",
    "versione",
    "estensione",
    "nomeOriginale",
    "utenteInserimento",
    "idFolder",
    "pathFolder",
    "rifIdRegistro",
    "idTipoDocumento",
    "nomeFile",
    "note",
    "status",
    "idDoc",
    "idVerisonePrecedente",
    "idFile",
    "nomeFolder"
})
public class FileMetatag {

    @XmlElement(name = "RefIdPadre")
    protected String refIdPadre;
    @XmlElement(name = "MajorVersion")
    protected int majorVersion;
    @XmlElement(name = "DataInserimento", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInserimento;
    @XmlElement(name = "TipoDocumento")
    protected String tipoDocumento;
    @XmlElement(name = "Metadati")
    protected ArrayOfMetadato metadati;
    @XmlElement(name = "Versione")
    protected String versione;
    @XmlElement(name = "Estensione")
    protected String estensione;
    @XmlElement(name = "NomeOriginale")
    protected String nomeOriginale;
    @XmlElement(name = "UtenteInserimento")
    protected String utenteInserimento;
    @XmlElement(name = "IdFolder")
    protected int idFolder;
    @XmlElement(name = "PathFolder")
    protected String pathFolder;
    @XmlElement(name = "RifIdRegistro")
    protected int rifIdRegistro;
    @XmlElement(name = "IdTipoDocumento")
    protected int idTipoDocumento;
    @XmlElement(name = "NomeFile")
    protected String nomeFile;
    @XmlElement(name = "Note")
    protected String note;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "IdDoc")
    protected int idDoc;
    @XmlElement(name = "IdVerisonePrecedente")
    protected int idVerisonePrecedente;
    @XmlElement(name = "IdFile")
    protected int idFile;
    @XmlElement(name = "NomeFolder")
    protected String nomeFolder;

    /**
     * Recupera il valore della proprieta refIdPadre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefIdPadre() {
        return refIdPadre;
    }

    /**
     * Imposta il valore della proprieta refIdPadre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefIdPadre(String value) {
        this.refIdPadre = value;
    }

    /**
     * Recupera il valore della proprieta majorVersion.
     * 
     */
    public int getMajorVersion() {
        return majorVersion;
    }

    /**
     * Imposta il valore della proprieta majorVersion.
     * 
     */
    public void setMajorVersion(int value) {
        this.majorVersion = value;
    }

    /**
     * Recupera il valore della proprieta dataInserimento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInserimento() {
        return dataInserimento;
    }

    /**
     * Imposta il valore della proprieta dataInserimento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInserimento(XMLGregorianCalendar value) {
        this.dataInserimento = value;
    }

    /**
     * Recupera il valore della proprieta tipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Imposta il valore della proprieta tipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumento(String value) {
        this.tipoDocumento = value;
    }

    /**
     * Recupera il valore della proprieta metadati.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMetadato }
     *     
     */
    public ArrayOfMetadato getMetadati() {
        return metadati;
    }

    /**
     * Imposta il valore della proprieta metadati.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMetadato }
     *     
     */
    public void setMetadati(ArrayOfMetadato value) {
        this.metadati = value;
    }

    /**
     * Recupera il valore della proprieta versione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersione() {
        return versione;
    }

    /**
     * Imposta il valore della proprieta versione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersione(String value) {
        this.versione = value;
    }

    /**
     * Recupera il valore della proprieta estensione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstensione() {
        return estensione;
    }

    /**
     * Imposta il valore della proprieta estensione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstensione(String value) {
        this.estensione = value;
    }

    /**
     * Recupera il valore della proprieta nomeOriginale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeOriginale() {
        return nomeOriginale;
    }

    /**
     * Imposta il valore della proprieta nomeOriginale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeOriginale(String value) {
        this.nomeOriginale = value;
    }

    /**
     * Recupera il valore della proprieta utenteInserimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtenteInserimento() {
        return utenteInserimento;
    }

    /**
     * Imposta il valore della proprieta utenteInserimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtenteInserimento(String value) {
        this.utenteInserimento = value;
    }

    /**
     * Recupera il valore della proprieta idFolder.
     * 
     */
    public int getIdFolder() {
        return idFolder;
    }

    /**
     * Imposta il valore della proprieta idFolder.
     * 
     */
    public void setIdFolder(int value) {
        this.idFolder = value;
    }

    /**
     * Recupera il valore della proprieta pathFolder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathFolder() {
        return pathFolder;
    }

    /**
     * Imposta il valore della proprieta pathFolder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathFolder(String value) {
        this.pathFolder = value;
    }

    /**
     * Recupera il valore della proprieta rifIdRegistro.
     * 
     */
    public int getRifIdRegistro() {
        return rifIdRegistro;
    }

    /**
     * Imposta il valore della proprieta rifIdRegistro.
     * 
     */
    public void setRifIdRegistro(int value) {
        this.rifIdRegistro = value;
    }

    /**
     * Recupera il valore della proprieta idTipoDocumento.
     * 
     */
    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    /**
     * Imposta il valore della proprieta idTipoDocumento.
     * 
     */
    public void setIdTipoDocumento(int value) {
        this.idTipoDocumento = value;
    }

    /**
     * Recupera il valore della proprieta nomeFile.
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
     * Imposta il valore della proprieta nomeFile.
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
     * Recupera il valore della proprieta note.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Imposta il valore della proprieta note.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Recupera il valore della proprieta status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Imposta il valore della proprieta status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Recupera il valore della proprieta idDoc.
     * 
     */
    public int getIdDoc() {
        return idDoc;
    }

    /**
     * Imposta il valore della proprieta idDoc.
     * 
     */
    public void setIdDoc(int value) {
        this.idDoc = value;
    }

    /**
     * Recupera il valore della proprieta idVerisonePrecedente.
     * 
     */
    public int getIdVerisonePrecedente() {
        return idVerisonePrecedente;
    }

    /**
     * Imposta il valore della proprieta idVerisonePrecedente.
     * 
     */
    public void setIdVerisonePrecedente(int value) {
        this.idVerisonePrecedente = value;
    }

    /**
     * Recupera il valore della proprieta idFile.
     * 
     */
    public int getIdFile() {
        return idFile;
    }

    /**
     * Imposta il valore della proprieta idFile.
     * 
     */
    public void setIdFile(int value) {
        this.idFile = value;
    }

    /**
     * Recupera il valore della proprieta nomeFolder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeFolder() {
        return nomeFolder;
    }

    /**
     * Imposta il valore della proprieta nomeFolder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeFolder(String value) {
        this.nomeFolder = value;
    }

}
