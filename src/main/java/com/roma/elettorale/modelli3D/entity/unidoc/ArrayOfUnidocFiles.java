
package com.roma.elettorale.modelli3D.entity.unidoc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ArrayOfUnidocFiles complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUnidocFiles">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnidocFiles" type="{}UnidocFiles" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUnidocFiles", namespace = "", propOrder = {
    "unidocFiles"
})
public class ArrayOfUnidocFiles {

    @XmlElement(name = "UnidocFiles", nillable = true)
    protected List<UnidocFiles> unidocFiles;

    /**
     * Gets the value of the unidocFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unidocFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnidocFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnidocFiles }
     * 
     * 
     */
    public List<UnidocFiles> getUnidocFiles() {
        if (unidocFiles == null) {
            unidocFiles = new ArrayList<UnidocFiles>();
        }
        return this.unidocFiles;
    }

}
