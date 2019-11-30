package com.roma.elettorale.modelli3D.faxpec.service;

import com.roma.elettorale.modelli3D.faxpec.contract.IMailInBoxServiceFlusso;
import com.roma.elettorale.modelli3D.faxpec.entity.mailinboxflusso;
import com.roma.elettorale.modelli3D.faxpec.repository.MailInboxFlussoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MailInBoxFlussoService implements IMailInBoxServiceFlusso {

    @Autowired
    MailInboxFlussoDAO mailInboxDAO;

    @Override
    public List<mailinboxflusso> findByRefidmail(Integer id) {
        return mailInboxDAO.findByRefidmail(id);
    }

    @Override
    public List<mailinboxflusso> findByRefidmailAndUtente(Integer id, String utente) {
        return mailInboxDAO.findByRefidmailAndUtente(id, utente);
    }

    @Override
    public void save(mailinboxflusso mailinboxflusso) {
        mailInboxDAO.save(mailinboxflusso);
    }

    @Override
    public void delete(mailinboxflusso mailinBoxFlusso) {
        mailInboxDAO.delete(mailinBoxFlusso);
    }

    @Override
    public List<mailinboxflusso> findByRefidmailAndUtenteAndStatusmailnew(Integer id, String utente, String statusnew) {
        return mailInboxDAO.findByRefidmailAndUtenteAndStatusmailnew(id,utente,statusnew);
    }
}
