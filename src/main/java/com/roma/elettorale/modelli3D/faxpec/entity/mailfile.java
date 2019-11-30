package com.roma.elettorale.modelli3D.faxpec.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Clob;

@Entity
@Table(name = "MAIL_INBOX")
@EntityListeners(AuditingEntityListener.class)
public class mailfile {


    public mailfile(Clob f)
    {
        mailraw = f;
    }

    @Id
    @Column(name = "MAIL_SERVER_ID")
    private String mailserverid;


   @Lob @Basic(fetch = FetchType.LAZY)
   @Column(name = "MAIL_FILE", columnDefinition="CLOB")
   private Clob mailraw;

    @Column(name = "MAIL_ACCOUNT")
   private String mail_account;

    public String getMailserverid() {
        return mailserverid;
    }

    public void setMailserverid(String mailserverid) {
        this.mailserverid = mailserverid;
    }

    public Clob getMailraw() {
        return mailraw;
    }

    public void setMailraw(Clob mailraw) {
        this.mailraw = mailraw;
    }

    public String getMail_account() {
        return mail_account;
    }

    public void setMail_account(String mail_account) {
        this.mail_account = mail_account;
    }
}
