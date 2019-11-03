//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.10.21 alle 10:29:35 AM CEST 
//


package com.roma.elettorale.modelli3D.entity.protocollo.ricerca;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ArrayOf_186797045_1319523186_nillable_ProtocolloConAllegati complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOf_186797045_1319523186_nillable_ProtocolloConAllegati"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ProtocolloConAllegati" type="{http://v1.data.protocollazione.protocollo.eng}ProtocolloConAllegati" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOf_186797045_1319523186_nillable_ProtocolloConAllegati", namespace = "http://ws.protocollo.eng", propOrder = {
    "protocolloConAllegati"
})
public class ArrayOf1867970451319523186NillableProtocolloConAllegati {

    @XmlElement(name = "ProtocolloConAllegati", nillable = true)
    protected List<ProtocolloConAllegati> protocolloConAllegati;

    /**
     * Gets the value of the protocolloConAllegati property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the protocolloConAllegati property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProtocolloConAllegati().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProtocolloConAllegati }
     * 
     * 
     */
    public List<ProtocolloConAllegati> getProtocolloConAllegati() {
        if (protocolloConAllegati == null) {
            protocolloConAllegati = new ArrayList<ProtocolloConAllegati>();
        }
        return this.protocolloConAllegati;
    }

}
