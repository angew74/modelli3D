package com.roma.elettorale.modelli3D.faxpec.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MAIL_INBOX")
@EntityListeners(AuditingEntityListener.class)
public class mailinbox implements Serializable {

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

    @Column(name = "STATUS_MAIL")
    private String statusmail;


    @Column(name="FOLDERID")
    private Integer folderid;

    @Column(name = "REF_ID_COM")
    private Integer refidcom;

    @Column(name = "FLG_ATTACHMENTS")
    private String flgattachements;

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

    public String getStatusmail() {
        return statusmail;
    }

    public void setStatusmail(String statusmail) {
        this.statusmail = statusmail;
    }

    public Integer getRefidcom() {
        return refidcom;
    }

    public void setRefidcom(Integer refidcom) {
        this.refidcom = refidcom;
    }

    public String getFlgattachements() {
        return flgattachements;
    }

    public void setFlgattachements(String flgattachements) {
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

    public Integer getFolderid() {
        return folderid;
    }

    public void setFolderid(Integer folderid) {
        this.folderid = folderid;
    }
}
