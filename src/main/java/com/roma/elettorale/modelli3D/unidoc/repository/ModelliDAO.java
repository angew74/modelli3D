package com.roma.elettorale.modelli3D.unidoc.repository;

import com.roma.elettorale.modelli3D.unidoc.entity.modelli;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("unidocBean")
public interface ModelliDAO extends JpaRepository<modelli, Long> {


    List<modelli> findByCodicefiscale(String codicefiscale);
    List<modelli> findByRefidstream(int refidstream);
    List<modelli> findByFlgoperazione(int flg);
    List<modelli> findByFlgoperazioneAndRefidstream(int flg, int refidstream);
}


