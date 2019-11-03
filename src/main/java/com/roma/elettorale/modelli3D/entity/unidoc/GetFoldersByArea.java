
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
 *         &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "area"
})
@XmlRootElement(name = "getFoldersByArea")
public class GetFoldersByArea {

    @XmlElement(namespace = "http://tempuri.org/")
    protected int area;

    /**
     * Recupera il valore della proprieta area.
     * 
     */
    public int getArea() {
        return area;
    }

    /**
     * Imposta il valore della proprieta area.
     * 
     */
    public void setArea(int value) {
        this.area = value;
    }

}
