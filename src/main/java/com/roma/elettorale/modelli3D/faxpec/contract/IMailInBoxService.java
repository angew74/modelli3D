package com.roma.elettorale.modelli3D.faxpec.contract;

import com.roma.elettorale.modelli3D.faxpec.entity.mailinbox;

import java.time.LocalDate;
import java.util.List;

public interface IMailInBoxService {

    List<mailinbox> findByDataricezioneBetweenAndMailfolderAndMailto(LocalDate data,LocalDate datafine, String mailfolder, String mailTo, String mailSubject, Integer flgatt);
    List<mailinbox> findByDataricezioneAndMailfolderAndMailto(LocalDate data,LocalDate dataFine,  String mailfolder,String mailTo,Integer att);
    List<mailinbox> findByDataricezioneBetweenAndMailfolderAndMailtoAndFlgattachements(LocalDate data, LocalDate datafine, String mailfolder,String mailTo, String flgatt, Integer folderid);
}
