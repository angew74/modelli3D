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
 *         &lt;element name="ricercaProtocolliReturn" type="{http://ws.protocollo.eng}ArrayOf_186797045_1319523186_nillable_ProtocolloConAllegati"/&gt;
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
    "ricercaProtocolliReturn"
})
@XmlRootElement(name = "ricercaProtocolliResponse", namespace = "http://ws.protocollo.eng")
public class RicercaProtocolliResponse {

    @XmlElement(required = true, nillable = true)
    protected ArrayOf1867970451319523186NillableProtocolloConAllegati ricercaProtocolliReturn;

    /**
     * Recupera il valore della proprietà ricercaProtocolliReturn.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOf1867970451319523186NillableProtocolloConAllegati }
     *     
     */
    public ArrayOf1867970451319523186NillableProtocolloConAllegati getRicercaProtocolliReturn() {
        return ricercaProtocolliReturn;
    }

    /**
     * Imposta il valore della proprietà ricercaProtocolliReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOf1867970451319523186NillableProtocolloConAllegati }
     *     
     */
    public void setRicercaProtocolliReturn(ArrayOf1867970451319523186NillableProtocolloConAllegati value) {
        this.ricercaProtocolliReturn = value;
    }

}
