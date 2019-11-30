package com.roma.elettorale.modelli3D.faxpec.service;

import com.roma.elettorale.modelli3D.faxpec.contract.IMailInBoxService;
import com.roma.elettorale.modelli3D.faxpec.entity.mailinbox;
import com.roma.elettorale.modelli3D.faxpec.repository.MailInboxDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Service
@Transactional
public class MailInBoxService implements IMailInBoxService {

    @Autowired
    MailInboxDAO mailInboxDAO;

    @Override
    public List<mailinbox> findByDataricezioneBetweenAndMailfolderAndMailto(LocalDate data, LocalDate datafine, String mailfolder, String mailTo, String mailSubject, Integer flgatt) {
        return mailInboxDAO.findByDataricezioneAndMailfolderAndMailto(data, datafine, mailfolder,mailTo, flgatt);
    }

    @Override
    public List<mailinbox> findByDataricezioneAndMailfolderAndMailto(LocalDate data, LocalDate dataFine, String mailfolder, String mailTo, Integer att) {
        return mailInboxDAO.findByDataricezioneAndMailfolderAndMailto(data,dataFine,mailfolder,mailTo, att);
    }

    @Override
    public List<mailinbox> findByDataricezioneBetweenAndMailfolderAndMailtoAndFlgattachements(LocalDate data, LocalDate datafine, String mailfolder, String mailTo, String flgatt,Integer folderid) {
        return mailInboxDAO.findByDataricezioneBetweenAndMailfolderAndMailtoAndFlgattachementsAndFolderidNot(data,datafine,mailfolder,mailTo,flgatt, folderid);
    }
}
