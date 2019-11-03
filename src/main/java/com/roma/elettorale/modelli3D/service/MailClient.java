package com.roma.elettorale.modelli3D.service;

import com.roma.elettorale.modelli3D.faxpec.contract.IMailInBoxService;
import com.roma.elettorale.modelli3D.faxpec.entity.mailinbox;
import com.roma.elettorale.modelli3D.helpers.TransformationFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.mail.Message;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class MailClient {


    private static final Logger log = LoggerFactory.getLogger(MailClient.class);

    @Autowired
    Environment env;

    @Autowired
    TransformationFile transformationFile;

    @Autowired
    IMailInBoxService mailInBoxService;

    public HashMap<String,Message> getMessages(LocalDate datainizio, LocalDate datafine,String mailAccount, StringBuilder s)
    {
       HashMap<String,Message> messageList = new HashMap<>();
        String mailFolder = env.getProperty("mailfolder");
        try
        {
           List<mailinbox> mailinboxes = mailInBoxService.findByDataricezioneAndMailfolderAndMailto(datainizio,mailFolder,mailAccount);
           for(mailinbox m : mailinboxes)
           {
             byte[] mbyte = m.getMailfile();

           }
        }catch (Exception ex)
        {

        }
        return  messageList;
    }
}
