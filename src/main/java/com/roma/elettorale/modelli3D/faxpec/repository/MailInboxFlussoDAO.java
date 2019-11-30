package com.roma.elettorale.modelli3D.faxpec.repository;

import com.roma.elettorale.modelli3D.faxpec.entity.mailinboxflusso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailInboxFlussoDAO extends JpaRepository<mailinboxflusso, Long> {

    List<mailinboxflusso> findByRefidmail(Integer id);

    List<mailinboxflusso> findByRefidmailAndUtente(Integer id, String utente);

    List<mailinboxflusso> findByRefidmailAndUtenteAndStatusmailnew(Integer id, String utente, String statusnew);
}
