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
 *         &lt;element name="visualizzaAllegatoReturn" type="{http://data.protocollazione.protocollo.eng}DettagliAllegato"/&gt;
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
    "visualizzaAllegatoReturn"
})
@XmlRootElement(name = "visualizzaAllegatoResponse")
public class VisualizzaAllegatoResponse {

    @XmlElement(required = true, nillable = true)
    protected DettagliAllegato visualizzaAllegatoReturn;

    /**
     * Recupera il valore della proprietà visualizzaAllegatoReturn.
     * 
     * @return
     *     possible object is
     *     {@link DettagliAllegato }
     *     
     */
    public DettagliAllegato getVisualizzaAllegatoReturn() {
        return visualizzaAllegatoReturn;
    }

    /**
     * Imposta il valore della proprietà visualizzaAllegatoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link DettagliAllegato }
     *     
     */
    public void setVisualizzaAllegatoReturn(DettagliAllegato value) {
        this.visualizzaAllegatoReturn = value;
    }

}
