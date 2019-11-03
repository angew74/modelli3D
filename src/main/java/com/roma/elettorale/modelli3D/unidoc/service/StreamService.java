package com.roma.elettorale.modelli3D.unidoc.service;

import com.roma.elettorale.modelli3D.service.ElaborazioneModelli;
import com.roma.elettorale.modelli3D.unidoc.contract.IStreamService;
import com.roma.elettorale.modelli3D.unidoc.entity.modelli;
import com.roma.elettorale.modelli3D.unidoc.entity.streamModelli;
import com.roma.elettorale.modelli3D.unidoc.repository.StreamDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(dontRollbackOn = Exception.class, rollbackOn = Exception.class)
public class StreamService implements IStreamService {

    private static final Logger log = LoggerFactory.getLogger(StreamService.class);

    @Autowired
    StreamDAO streamDAO;

    @Override
    public List<streamModelli> findByDatacarimento(LocalDate dataCaricamento) {
        return streamDAO.findByDatacarimento(dataCaricamento);
    }

    @Override
    public List<streamModelli> findById(int refidstream) {
        return streamDAO.findById(refidstream);
    }

    @Override
    public List<streamModelli> findByNumero(int numero) {
        return streamDAO.findByNumero(numero);
    }

    @Override
    public List<streamModelli> findByTipologia(int tipologia) {
        return streamDAO.findByTipologia(tipologia);
    }

    @Override
    public void Save(streamModelli c) {
        try {
            streamDAO.save(c);
        }
        catch (Exception ex)
        {
            log.debug("errore infernale: " +ex.getCause());
            ex.printStackTrace();
        }

    }

    @Override
    public Integer getMaxId() {
        return streamDAO.getMaxId();
    }
}
