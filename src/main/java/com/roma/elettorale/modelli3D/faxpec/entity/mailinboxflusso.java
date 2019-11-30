package com.roma.elettorale.modelli3D.faxpec.entity;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MAIL_INBOX_FLUSSO")
@EntityListeners(AuditingEntityListener.class)
public class mailinboxflusso implements Serializable {

    @Id
    @Column(name = "REF_ID_MAIL")
    private Integer refidmail;

    @Column(name = "STATUS_MAIL_OLD")
    private String statusmailold;

    @Column(name = "STATUS_MAIL_NEW")
    private String statusmailnew;

    @Column(name = "UTE_OPE")
    private String utente;

    @Column(name = "DATA_OPERAZIONE")
    private LocalDate dataoperazione;

    public Integer getRefidmail() {
        return refidmail;
    }

    public void setRefidmail(Integer refidmail) {
        this.refidmail = refidmail;
    }

    public String getStatusmailold() {
        return statusmailold;
    }

    public void setStatusmailold(String statusmailold) {
        this.statusmailold = statusmailold;
    }

    public String getStatusmailnew() {
        return statusmailnew;
    }

    public void setStatusmailnew(String statusmailnew) {
        this.statusmailnew = statusmailnew;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public LocalDate getDataoperazione() {
        return dataoperazione;
    }

    public void setDataoperazione(LocalDate dataoperazione) {
        this.dataoperazione = dataoperazione;
    }

}
