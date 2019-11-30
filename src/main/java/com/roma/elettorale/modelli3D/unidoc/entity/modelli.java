package com.roma.elettorale.modelli3D.unidoc.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;


@Entity
@Table(name = "MODELLI3D")
public class modelli {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MODELLI3D_SEQ")
    @SequenceGenerator(name = "MODELLI_3D_ALL", sequenceName = "MODELLI3D_SEQ" ,allocationSize = 50)
    private Integer id;

    @Column(name = "codice_individuale")
    private String codiceindividuale;

    @Column(name = "codice_fiscale")
    private String codicefiscale;


    @Column(name = "descrizione_file")
    private String descrizionefile;

    @Column(name = "flg_operazione")
    private Integer flgoperazione;

    @Column(name = "data_operazione")
    private LocalDateTime dataoperazione;

    @Column(name = "programma_operazione")
    private String programmaelaborazione;

    @Column(name = "descrizione_errore")
    private String descrizioneerrore;

    @Column(name = "ref_id_stream")
    private Integer refidstream;

    @Column(name = "FILE_MODELLO3D")
    @Lob
    private String fileModello3D;

    @Column(name = "FILE_SCARTATO")
    @Lob
    private byte[] fileScartato;


    @Column(name = "MITTENTE")
    private String mittente;

    @Column(name = "ANNO_PROTOCOLLO")
    private String annoprotocollo;

    @Column(name = "NUMERO_PROTOCOLLO")
    private String numeroprotocollo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodiceindividuale() {
        return codiceindividuale;
    }

    public void setCodiceindividuale(String codiceindividuale) {
        this.codiceindividuale = codiceindividuale;
    }

    public String getDescrizionefile() {
        return descrizionefile;
    }

    public void setDescrizionefile(String descrizionefile) {
        this.descrizionefile = descrizionefile;
    }

    public Integer getFlgoperazione() {
        return flgoperazione;
    }

    public void setFlgoperazione(Integer flgoperazione) {
        this.flgoperazione = flgoperazione;
    }

    public LocalDateTime getDataoperazione() {
        return dataoperazione;
    }

    public void setDataoperazione(LocalDateTime dataoperazione) {
        this.dataoperazione = dataoperazione;
    }

    public String getProgrammaelaborazione() {
        return programmaelaborazione;
    }

    public void setProgrammaelaborazione(String programmaelaborazione) {
        this.programmaelaborazione = programmaelaborazione;
    }

    public String getDescrizioneerrore() {
        return descrizioneerrore;
    }

    public void setDescrizioneerrore(String descrizioneerrore) {
        this.descrizioneerrore = descrizioneerrore;
    }

    public Integer getRefidstream() {
        return refidstream;
    }

    public void setRefidstream(Integer refidstream) {
        this.refidstream = refidstream;
    }

    public String getCodicefiscale() {
        return codicefiscale;
    }

    public void setCodicefiscale(String codicefiscale) {
        this.codicefiscale = codicefiscale;
    }


    public String getFileModello3D() {
        return fileModello3D;
    }

    public void setFileModello3D(String fileModello3D) {
        this.fileModello3D = fileModello3D;
    }

    public byte[] getFileScartato() {
        return fileScartato;
    }

    public void setFileScartato(byte[] fileScartato) {
        this.fileScartato = fileScartato;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getAnnoprotocollo() {
        return annoprotocollo;
    }

    public void setAnnoprotocollo(String annoprotocollo) {
        this.annoprotocollo = annoprotocollo;
    }

    public String getNumeroprotocollo() {
        return numeroprotocollo;
    }

    public void setNumeroprotocollo(String numeroprotocollo) {
        this.numeroprotocollo = numeroprotocollo;
    }
}

