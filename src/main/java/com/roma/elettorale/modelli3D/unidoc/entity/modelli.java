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
        @SequenceGenerator(name = "MODELL_3D_ALL", sequenceName = "MODELLI3D_SEQ")
        private Integer id;

        @Column(name = "codice_individuale")
        private String codiceindividuale;

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
    }

