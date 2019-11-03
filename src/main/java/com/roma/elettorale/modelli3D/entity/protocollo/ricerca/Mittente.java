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
 * <p>Classe Java per Mittente complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Mittente"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codice_mittente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizione_mittente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_mittente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Mittente", propOrder = {
    "codiceMittente",
    "descrizioneMittente",
    "tipoMittente"
})
public class Mittente {

    @XmlElement(name = "codice_mittente", required = true, nillable = true)
    protected String codiceMittente;
    @XmlElement(name = "descrizione_mittente", required = true, nillable = true)
    protected String descrizioneMittente;
    @XmlElement(name = "tipo_mittente", required = true, nillable = true)
    protected String tipoMittente;

    /**
     * Recupera il valore della proprietà codiceMittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceMittente() {
        return codiceMittente;
    }

    /**
     * Imposta il valore della proprietà codiceMittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceMittente(String value) {
        this.codiceMittente = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneMittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneMittente() {
        return descrizioneMittente;
    }

    /**
     * Imposta il valore della proprietà descrizioneMittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneMittente(String value) {
        this.descrizioneMittente = value;
    }

    /**
     * Recupera il valore della proprietà tipoMittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoMittente() {
        return tipoMittente;
    }

    /**
     * Imposta il valore della proprietà tipoMittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoMittente(String value) {
        this.tipoMittente = value;
    }

}
