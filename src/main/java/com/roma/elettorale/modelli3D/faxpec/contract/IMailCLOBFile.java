package com.roma.elettorale.modelli3D.faxpec.contract;

import java.sql.Blob;
import java.sql.Clob;

public interface IMailCLOBFile {

   // byte[] getMailRaw(String refidmail);

  Clob getMailRaw(String refidmail, String mailaccount);

}
