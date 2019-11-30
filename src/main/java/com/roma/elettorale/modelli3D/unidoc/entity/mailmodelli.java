package com.roma.elettorale.modelli3D.unidoc.entity;

import org.w3c.dom.Document;

public class mailmodelli {


    private String idmail;
    private String nomeFile;
    private Document documentXML;
    private String mittente;

    public String getIdmail() {
        return idmail;
    }

    public void setIdmail(String idmail) {
        this.idmail = idmail;
    }

    public String getNomeFile() {
        return nomeFile;
    }

    public void setNomeFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }


    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public Document getDocumentXML() {
        return documentXML;
    }

    public void setDocumentXML(Document documentXML) {
        this.documentXML = documentXML;
    }
}
