package com.roma.elettorale.modelli3D.faxpec.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

@Entity
@Table(name = "MAIL_INBOX")
public class mailinbox {

    @Id
    @Column(name = "MAIL_SERVER_ID")
    private String mailserverid;

    @Column(name = "MAIL_ACCOUNT")
    private String mailaccount;

    @Column(name = "MAIL_FROM")
    private String mailfrom;

    @Column(name = "MAIL_TO")
    private String mailto;

    @Column(name = "MAIL_SUBJECT")
    private String mailsubject;

    @Column(name = "MAIL_TEXT")
    private String mailtext;

    @Column(name = "DATA_INVIO")
    private LocalDate datainvio;

    @Column(name = "DATA_RICEZIONE")
    private LocalDate dataricezione;

    @Column(name = "STATUS_SERVER")
    private LocalDate statusserver;

    @Column(name = "STATUS_MAIL")
    private String statusmail;

    @Lob
    @Column(name = "MAIL_FILE")
    private byte[] mailfile;

    @Column(name = "REF_ID_COM")
    private Integer refidcom;

    @Column(name = "FLG_ATTACHMENTS")
    private Integer flgattachements;

    @Column(name = "ID_MAIL")
    private Integer idmail;

    @Column(name = "MAIL_FOLDER")
    private String mailfolder;

    public String getMailserverid() {
        return mailserverid;
    }

    public void setMailserverid(String mailserverid) {
        this.mailserverid = mailserverid;
    }

    public String getMailaccount() {
        return mailaccount;
    }

    public void setMailaccount(String mailaccount) {
        this.mailaccount = mailaccount;
    }

    public String getMailfrom() {
        return mailfrom;
    }

    public void setMailfrom(String mailfrom) {
        this.mailfrom = mailfrom;
    }

    public String getMailto() {
        return mailto;
    }

    public void setMailto(String mailto) {
        this.mailto = mailto;
    }

    public String getMailsubject() {
        return mailsubject;
    }

    public void setMailsubject(String mailsubject) {
        this.mailsubject = mailsubject;
    }

    public String getMailtext() {
        return mailtext;
    }

    public void setMailtext(String mailtext) {
        this.mailtext = mailtext;
    }

    public LocalDate getDatainvio() {
        return datainvio;
    }

    public void setDatainvio(LocalDate datainvio) {
        this.datainvio = datainvio;
    }

    public LocalDate getDataricezione() {
        return dataricezione;
    }

    public void setDataricezione(LocalDate dataricezione) {
        this.dataricezione = dataricezione;
    }

    public LocalDate getStatusserver() {
        return statusserver;
    }

    public void setStatusserver(LocalDate statusserver) {
        this.statusserver = statusserver;
    }

    public String getStatusmail() {
        return statusmail;
    }

    public void setStatusmail(String statusmail) {
        this.statusmail = statusmail;
    }

    public byte[] getMailfile() {
        return mailfile;
    }

    public void setMailfile(byte[] mailfile) {
        this.mailfile = mailfile;
    }

    public Integer getRefidcom() {
        return refidcom;
    }

    public void setRefidcom(Integer refidcom) {
        this.refidcom = refidcom;
    }

    public Integer getFlgattachements() {
        return flgattachements;
    }

    public void setFlgattachements(Integer flgattachements) {
        this.flgattachements = flgattachements;
    }

    public Integer getIdmail() {
        return idmail;
    }

    public void setIdmail(Integer idmail) {
        this.idmail = idmail;
    }

    public String getMailfolder() {
        return mailfolder;
    }

    public void setMailfolder(String mailfolder) {
        this.mailfolder = mailfolder;
    }
}
