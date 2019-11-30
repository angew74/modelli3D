package com.roma.elettorale.modelli3D.faxpec.repository;


import com.roma.elettorale.modelli3D.faxpec.entity.mailfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.sql.Clob;

@Repository
public interface MailCLOBFileDAO extends JpaRepository<mailfile, Long> {

   // @Modifying
   // @Query(" SELECT new mailfile(a.mailraw) from mailfile a where a.mailserverid = ?1")
    // byte[] getMailRaw(String mailserverid);
   @Query(" SELECT a.mailraw from mailfile a where a.mailserverid = ?1 and a.mail_account= ?2")
    Clob getMailRaw(String mailserverid, String mailaccount);
}
