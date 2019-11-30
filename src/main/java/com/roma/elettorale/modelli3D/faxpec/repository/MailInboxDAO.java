package com.roma.elettorale.modelli3D.faxpec.repository;

import com.roma.elettorale.modelli3D.faxpec.entity.mailinbox;
import com.roma.elettorale.modelli3D.faxpec.entity.mailinboxflusso;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Qualifier("faxpecBean")
public interface MailInboxDAO extends JpaRepository<mailinbox, Long> {

    @Modifying
    @Query("select b.mailserverid, b.datainvio, b.dataricezione,b.flgattachements, b.idmail, b.mailaccount, b.mailfrom, b.mailsubject, b.mailto from mailinbox b " +
            " inner join  mailinboxflusso c on b.idmail=c.refidmail " +
            " where (b.dataricezione between ?1 and ?2) and b.mailfolder=?3 and b.mailto=?4 and b.flgattachements=?6 and (upper(b.mailsubject) like upper(?5))")
    List<mailinbox> findByDataricezioneBetweenAndMailfolderAndMailto(LocalDate data, LocalDate datafine, String mailfolder,String mailTo,  int flgatt);
    @Modifying
    @Query("select b.mailserverid, b.datainvio, b.dataricezione,b.flgattachements, b.idmail, b.mailaccount, b.mailfrom, b.mailsubject, b.mailto from mailinbox b " +
            " inner join  mailinboxflusso c on b.idmail=c.refidmail " +
            " where (b.dataricezione between ?1 and ?2) and b.mailfolder=?3 and b.mailto=?4 and b.flgattachements=?5")
    List<mailinbox> findByDataricezioneAndMailfolderAndMailto(LocalDate data,LocalDate datafine, String mailfolder,String mailTo, Integer att);

    List<mailinbox> findByDataricezioneBetweenAndMailfolderAndMailtoAndFlgattachementsAndFolderidNot(LocalDate data, LocalDate datafine, String mailfolder,String mailTo, String flgatt, Integer folderid);
}
