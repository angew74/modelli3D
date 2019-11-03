package com.roma.elettorale.modelli3D.unidoc.entity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "BASE_MODELLI3D")
@EntityListeners(AuditingEntityListener.class)
public class streamModelli implements Serializable {

    private static final long serialVersionUID = 1L;



    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BASE_MODELLI3D_SEQ")
    @SequenceGenerator(name = "BASE_MODELLI_3D_ALL", sequenceName = "BASE_MODELLI3D_SEQ")
    private Integer id;


    @Column(name = "numero")
    private Integer numero;


    @Column(name = "data_caricamento")
    private LocalDateTime datacarimento;

    @Column(name = "numero_file")
    private Integer numerofile;

    @Column(name = "tipologia")
    private Integer tipologia;


    @Column(name = "NUMERO_SCARTI")
    private Integer numeroscarti;

    @Column(name = "NUMERO_ELABORATI")
    private Integer numeroelaborati;

    @Column(name = "PROGRAMMA_CARICAMENTO")
    private String programmaCaricamento;

    @Column(name = "DATA_INIZIO_SELEZIONE")
    private String dataInizioSelezione;

    @Column(name = "DATA_FINE_SELEZIONE")
    private String dataFineSelezione;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDatacarimento() {
        return datacarimento;
    }

    public void setDatacarimento(LocalDateTime datacarimento) {
        this.datacarimento = datacarimento;
    }


    public Integer getNumerofile() {
        return numerofile;
    }

    public void setNumerofile(Integer numerofile) {
        this.numerofile = numerofile;
    }

    public Integer getTipologia() {
        return tipologia;
    }

    public void setTipologia(Integer tipologia) {
        this.tipologia = tipologia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumeroscarti() {
        return numeroscarti;
    }

    public void setNumeroscarti(Integer numeroscarti) {
        this.numeroscarti = numeroscarti;
    }

    public Integer getNumeroelaborati() {
        return numeroelaborati;
    }

    public void setNumeroelaborati(Integer numeroelaborati) {
        this.numeroelaborati = numeroelaborati;
    }

    public String getProgrammaCaricamento() {
        return programmaCaricamento;
    }

    public void setProgrammaCaricamento(String programmaCaricamento) {
        this.programmaCaricamento = programmaCaricamento;
    }

    public String getDataInizioSelezione() {
        return dataInizioSelezione;
    }

    public void setDataInizioSelezione(String dataInizioSelezione) {
        this.dataInizioSelezione = dataInizioSelezione;
    }

    public String getDataFineSelezione() {
        return dataFineSelezione;
    }

    public void setDataFineSelezione(String dataFineSelezione) {
        this.dataFineSelezione = dataFineSelezione;
    }
}
