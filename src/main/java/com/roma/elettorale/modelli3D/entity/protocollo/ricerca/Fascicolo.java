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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Fascicolo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Fascicolo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="anno_protocollo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="progressivo_protocollo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_protocollo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fascicolo", propOrder = {
    "annoProtocollo",
    "progressivoProtocollo",
    "tipoProtocollo"
})
public class Fascicolo {

    @XmlElement(name = "anno_protocollo", required = true, nillable = true)
    protected String annoProtocollo;
    @XmlElement(name = "progressivo_protocollo", required = true, nillable = true)
    protected String progressivoProtocollo;
    @XmlElement(name = "tipo_protocollo", required = true, nillable = true)
    protected String tipoProtocollo;

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
     * Recupera il valore della proprietà progressivoProtocollo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgressivoProtocollo() {
        return progressivoProtocollo;
    }

    /**
     * Imposta il valore della proprietà progressivoProtocollo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgressivoProtocollo(String value) {
        this.progressivoProtocollo = value;
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

}
