
package com.roma.elettorale.modelli3D.entity.unidoc;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idFolder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="da" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="per" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idFolder",
    "status",
    "da",
    "per"
})
@XmlRootElement(name = "getPagedFilesFromIdFolderStatus")
public class GetPagedFilesFromIdFolderStatus {

    @XmlElement(namespace = "http://tempuri.org/")
    protected int idFolder;
    @XmlElement(namespace = "http://tempuri.org/")
    protected String status;
    @XmlElement(namespace = "http://tempuri.org/")
    protected int da;
    @XmlElement(namespace = "http://tempuri.org/")
    protected int per;

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
     * Recupera il valore della proprieta da.
     * 
     */
    public int getDa() {
        return da;
    }

    /**
     * Imposta il valore della proprieta da.
     * 
     */
    public void setDa(int value) {
        this.da = value;
    }

    /**
     * Recupera il valore della proprieta per.
     * 
     */
    public int getPer() {
        return per;
    }

    /**
     * Imposta il valore della proprieta per.
     * 
     */
    public void setPer(int value) {
        this.per = value;
    }

}
