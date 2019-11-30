package com.roma.elettorale.modelli3D.faxpec.service;

import com.roma.elettorale.modelli3D.faxpec.contract.IMailCLOBFile;
import com.roma.elettorale.modelli3D.faxpec.repository.MailCLOBFileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Blob;
import java.sql.Clob;

@Service
@Transactional
public class MailCLOBFile implements IMailCLOBFile {

    @Autowired
    MailCLOBFileDAO mailCLOBFileDAO;

    @Override
    //public byte[] getMailRaw(String refidmail) {
    public Clob getMailRaw(String refidmail,String mailaccount){
        return mailCLOBFileDAO.getMailRaw(refidmail,mailaccount);
    }
}
