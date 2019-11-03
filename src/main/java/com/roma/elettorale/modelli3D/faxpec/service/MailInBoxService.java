package com.roma.elettorale.modelli3D.faxpec.service;

import com.roma.elettorale.modelli3D.faxpec.contract.IMailInBoxService;
import com.roma.elettorale.modelli3D.faxpec.entity.mailinbox;
import com.roma.elettorale.modelli3D.faxpec.repository.MailInboxDAO;

import java.time.LocalDate;
import java.util.List;

public class MailInBoxService implements IMailInBoxService {

    MailInboxDAO mailInboxDAO;
    @Override
    public List<mailinbox> findByDataricezioneAndMailfolderAndMailtoAndMailsubject(LocalDate data, String mailfolder, String mailTo, String mailSubject) {
        return mailInboxDAO.findByDataricezioneAndMailfolderAndMailtoAndMailsubject(data,mailfolder,mailTo,mailSubject);
    }

    @Override
    public List<mailinbox> findByDataricezioneAndMailfolderAndMailto(LocalDate data, String mailfolder, String mailTo) {
        return mailInboxDAO.findByDataricezioneAndMailfolderAndMailto(data,mailfolder,mailTo);
    }
}
