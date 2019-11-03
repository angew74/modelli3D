package com.roma.elettorale.modelli3D.unidoc.service;


import com.roma.elettorale.modelli3D.unidoc.contract.IModelliService;
import com.roma.elettorale.modelli3D.unidoc.entity.modelli;
import com.roma.elettorale.modelli3D.unidoc.repository.ModelliDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ModelliService implements IModelliService {

    @Autowired
    ModelliDAO modelliDAO;

    @Override
    public List<modelli> findByCodicefiscale(String codicefiscale) {
        return modelliDAO.findByCodicefiscale(codicefiscale);
    }

    @Override
    public List<modelli> findByRefidstream(int refidstream) {
        return modelliDAO.findByRefidstream(refidstream);
    }

    @Override
    public List<modelli> findByFlgoperazione(int flg) {
        return modelliDAO.findByFlgoperazione(flg);
    }

    @Override
    public List<modelli> findByFlgoperazioneAndRefidstream(int flg, int refidstream) {
        return modelliDAO.findByFlgoperazioneAndRefidstream(flg,refidstream);
    }

    @Override
    public void Save(modelli c) {
        modelliDAO.saveAndFlush(c);
    }
}
