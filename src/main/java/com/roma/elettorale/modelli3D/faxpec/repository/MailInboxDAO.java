package com.roma.elettorale.modelli3D.faxpec.repository;

import com.roma.elettorale.modelli3D.faxpec.entity.mailinbox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MailInboxDAO extends JpaRepository<mailinbox, Long> {

    List<mailinbox> findByDataricezioneAndMailfolderAndMailtoAndMailsubject(LocalDate data, String mailfolder,String mailTo, String mailSubject );
    List<mailinbox> findByDataricezioneAndMailfolderAndMailto(LocalDate data, String mailfolder,String mailTo);
}
