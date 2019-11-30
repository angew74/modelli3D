package com.roma.elettorale.modelli3D.faxpec.contract;

import com.roma.elettorale.modelli3D.faxpec.entity.mailinboxflusso;

import java.util.List;

public interface IMailInBoxServiceFlusso {


    List<mailinboxflusso> findByRefidmail(Integer id);

    List<mailinboxflusso> findByRefidmailAndUtente(Integer id, String utente);

    void save(mailinboxflusso mailinboxflusso);

    void delete(mailinboxflusso mailinBoxFlusso);

    List<mailinboxflusso> findByRefidmailAndUtenteAndStatusmailnew(Integer id, String utemte, String statusnew);
}
