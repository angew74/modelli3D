package com.roma.elettorale.modelli3D.faxpec.contract;

import com.roma.elettorale.modelli3D.faxpec.entity.mailinbox;

import java.time.LocalDate;
import java.util.List;

public interface IMailInBoxService {

    List<mailinbox> findByDataricezioneAndMailfolderAndMailtoAndMailsubject(LocalDate data, String mailfolder, String mailTo, String mailSubject );
    List<mailinbox> findByDataricezioneAndMailfolderAndMailto(LocalDate data, String mailfolder,String mailTo);
}
