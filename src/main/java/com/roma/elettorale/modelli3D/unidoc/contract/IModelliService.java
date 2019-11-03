package com.roma.elettorale.modelli3D.unidoc.contract;

import com.roma.elettorale.modelli3D.unidoc.entity.modelli;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface IModelliService {

    List<modelli> findByCodicefiscale(String codicefiscale);
    List<modelli> findByRefidstream(int refidstream);
    List<modelli> findByFlgoperazione(int flg);
    List<modelli> findByFlgoperazioneAndRefidstream(int flg, int refidstream);
    void Save(modelli c);
}
