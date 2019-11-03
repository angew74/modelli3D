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
 * <p>Classe Java per Allegato complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Allegato"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descrizione_file" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="identificativo_allegato" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="identificativo_hash" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nome_file" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Allegato", namespace = "http://data.protocollazione.protocollo.eng", propOrder = {
    "descrizioneFile",
    "identificativoAllegato",
    "identificativoHash",
    "nomeFile"
})
public class Allegato {

    @XmlElement(name = "descrizione_file", required = true, nillable = true)
    protected String descrizioneFile;
    @XmlElement(name = "identificativo_allegato")
    protected int identificativoAllegato;
    @XmlElement(name = "identificativo_hash", required = true, nillable = true)
    protected String identificativoHash;
    @XmlElement(name = "nome_file", required = true, nillable = true)
    protected String nomeFile;

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
     * Recupera il valore della proprietà identificativoAllegato.
     * 
     */
    public int getIdentificativoAllegato() {
        return identificativoAllegato;
    }

    /**
     * Imposta il valore della proprietà identificativoAllegato.
     * 
     */
    public void setIdentificativoAllegato(int value) {
        this.identificativoAllegato = value;
    }

    /**
     * Recupera il valore della proprietà identificativoHash.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativoHash() {
        return identificativoHash;
    }

    /**
     * Imposta il valore della proprietà identificativoHash.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativoHash(String value) {
        this.identificativoHash = value;
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

}
