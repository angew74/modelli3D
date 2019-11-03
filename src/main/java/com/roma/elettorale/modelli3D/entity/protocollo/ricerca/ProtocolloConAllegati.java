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
 * <p>Classe Java per ProtocolloConAllegati complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ProtocolloConAllegati"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://data.protocollazione.protocollo.eng}ProtocolloErrore"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipologia_protocollo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="allegati" type="{http://v1.data.protocollazione.protocollo.eng}ArrayOf_1319523186_342555263_nillable_Allegato"/&gt;
 *         &lt;element name="annoProtocolloProvenienza" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="progProtocolloProvenienza" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipoProtocolloProvenienza" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceDocumentoFisico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceDocumentoLogico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceDocumentoSTPLogico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dataUlterioreIdentificativo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizioneDocumentoFisico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizioneDocumentoLogico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizioneDocumentoSTPLogico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ulterioreIdentificativo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizioneStrutturaProtocollante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizioneUtenteProtocollante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceStrutturaProtocollante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="utenteProtocollante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProtocolloConAllegati", namespace = "http://v1.data.protocollazione.protocollo.eng", propOrder = {
    "tipologiaProtocollo",
    "allegati",
    "annoProtocolloProvenienza",
    "progProtocolloProvenienza",
    "tipoProtocolloProvenienza",
    "codiceDocumentoFisico",
    "codiceDocumentoLogico",
    "codiceDocumentoSTPLogico",
    "dataUlterioreIdentificativo",
    "descrizioneDocumentoFisico",
    "descrizioneDocumentoLogico",
    "descrizioneDocumentoSTPLogico",
    "ulterioreIdentificativo",
    "descrizioneStrutturaProtocollante",
    "descrizioneUtenteProtocollante",
    "codiceStrutturaProtocollante",
    "utenteProtocollante"
})
public class ProtocolloConAllegati
    extends ProtocolloErrore
{

    @XmlElement(name = "tipologia_protocollo", required = true, nillable = true)
    protected String tipologiaProtocollo;
    @XmlElement(required = true, nillable = true)
    protected ArrayOf1319523186342555263NillableAllegato allegati;
    @XmlElement(required = true, nillable = true)
    protected String annoProtocolloProvenienza;
    @XmlElement(required = true, nillable = true)
    protected String progProtocolloProvenienza;
    @XmlElement(required = true, nillable = true)
    protected String tipoProtocolloProvenienza;
    @XmlElement(required = true, nillable = true)
    protected String codiceDocumentoFisico;
    @XmlElement(required = true, nillable = true)
    protected String codiceDocumentoLogico;
    @XmlElement(required = true, nillable = true)
    protected String codiceDocumentoSTPLogico;
    @XmlElement(required = true, nillable = true)
    protected String dataUlterioreIdentificativo;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneDocumentoFisico;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneDocumentoLogico;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneDocumentoSTPLogico;
    @XmlElement(required = true, nillable = true)
    protected String ulterioreIdentificativo;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneStrutturaProtocollante;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneUtenteProtocollante;
    @XmlElement(required = true, nillable = true)
    protected String codiceStrutturaProtocollante;
    @XmlElement(required = true, nillable = true)
    protected String utenteProtocollante;

    /**
     * Recupera il valore della proprietà tipologiaProtocollo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipologiaProtocollo() {
        return tipologiaProtocollo;
    }

    /**
     * Imposta il valore della proprietà tipologiaProtocollo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipologiaProtocollo(String value) {
        this.tipologiaProtocollo = value;
    }

    /**
     * Recupera il valore della proprietà allegati.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOf1319523186342555263NillableAllegato }
     *     
     */
    public ArrayOf1319523186342555263NillableAllegato getAllegati() {
        return allegati;
    }

    /**
     * Imposta il valore della proprietà allegati.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOf1319523186342555263NillableAllegato }
     *     
     */
    public void setAllegati(ArrayOf1319523186342555263NillableAllegato value) {
        this.allegati = value;
    }

    /**
     * Recupera il valore della proprietà annoProtocolloProvenienza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoProtocolloProvenienza() {
        return annoProtocolloProvenienza;
    }

    /**
     * Imposta il valore della proprietà annoProtocolloProvenienza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoProtocolloProvenienza(String value) {
        this.annoProtocolloProvenienza = value;
    }

    /**
     * Recupera il valore della proprietà progProtocolloProvenienza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgProtocolloProvenienza() {
        return progProtocolloProvenienza;
    }

    /**
     * Imposta il valore della proprietà progProtocolloProvenienza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgProtocolloProvenienza(String value) {
        this.progProtocolloProvenienza = value;
    }

    /**
     * Recupera il valore della proprietà tipoProtocolloProvenienza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoProtocolloProvenienza() {
        return tipoProtocolloProvenienza;
    }

    /**
     * Imposta il valore della proprietà tipoProtocolloProvenienza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoProtocolloProvenienza(String value) {
        this.tipoProtocolloProvenienza = value;
    }

    /**
     * Recupera il valore della proprietà codiceDocumentoFisico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceDocumentoFisico() {
        return codiceDocumentoFisico;
    }

    /**
     * Imposta il valore della proprietà codiceDocumentoFisico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceDocumentoFisico(String value) {
        this.codiceDocumentoFisico = value;
    }

    /**
     * Recupera il valore della proprietà codiceDocumentoLogico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceDocumentoLogico() {
        return codiceDocumentoLogico;
    }

    /**
     * Imposta il valore della proprietà codiceDocumentoLogico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceDocumentoLogico(String value) {
        this.codiceDocumentoLogico = value;
    }

    /**
     * Recupera il valore della proprietà codiceDocumentoSTPLogico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceDocumentoSTPLogico() {
        return codiceDocumentoSTPLogico;
    }

    /**
     * Imposta il valore della proprietà codiceDocumentoSTPLogico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceDocumentoSTPLogico(String value) {
        this.codiceDocumentoSTPLogico = value;
    }

    /**
     * Recupera il valore della proprietà dataUlterioreIdentificativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataUlterioreIdentificativo() {
        return dataUlterioreIdentificativo;
    }

    /**
     * Imposta il valore della proprietà dataUlterioreIdentificativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataUlterioreIdentificativo(String value) {
        this.dataUlterioreIdentificativo = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneDocumentoFisico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneDocumentoFisico() {
        return descrizioneDocumentoFisico;
    }

    /**
     * Imposta il valore della proprietà descrizioneDocumentoFisico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneDocumentoFisico(String value) {
        this.descrizioneDocumentoFisico = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneDocumentoLogico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneDocumentoLogico() {
        return descrizioneDocumentoLogico;
    }

    /**
     * Imposta il valore della proprietà descrizioneDocumentoLogico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneDocumentoLogico(String value) {
        this.descrizioneDocumentoLogico = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneDocumentoSTPLogico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneDocumentoSTPLogico() {
        return descrizioneDocumentoSTPLogico;
    }

    /**
     * Imposta il valore della proprietà descrizioneDocumentoSTPLogico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneDocumentoSTPLogico(String value) {
        this.descrizioneDocumentoSTPLogico = value;
    }

    /**
     * Recupera il valore della proprietà ulterioreIdentificativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlterioreIdentificativo() {
        return ulterioreIdentificativo;
    }

    /**
     * Imposta il valore della proprietà ulterioreIdentificativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlterioreIdentificativo(String value) {
        this.ulterioreIdentificativo = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneStrutturaProtocollante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneStrutturaProtocollante() {
        return descrizioneStrutturaProtocollante;
    }

    /**
     * Imposta il valore della proprietà descrizioneStrutturaProtocollante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneStrutturaProtocollante(String value) {
        this.descrizioneStrutturaProtocollante = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneUtenteProtocollante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneUtenteProtocollante() {
        return descrizioneUtenteProtocollante;
    }

    /**
     * Imposta il valore della proprietà descrizioneUtenteProtocollante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneUtenteProtocollante(String value) {
        this.descrizioneUtenteProtocollante = value;
    }

    /**
     * Recupera il valore della proprietà codiceStrutturaProtocollante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceStrutturaProtocollante() {
        return codiceStrutturaProtocollante;
    }

    /**
     * Imposta il valore della proprietà codiceStrutturaProtocollante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceStrutturaProtocollante(String value) {
        this.codiceStrutturaProtocollante = value;
    }

    /**
     * Recupera il valore della proprietà utenteProtocollante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtenteProtocollante() {
        return utenteProtocollante;
    }

    /**
     * Imposta il valore della proprietà utenteProtocollante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtenteProtocollante(String value) {
        this.utenteProtocollante = value;
    }

}
