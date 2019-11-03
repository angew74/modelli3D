package com.roma.elettorale.modelli3D.unidoc.contract;

import com.roma.elettorale.modelli3D.unidoc.entity.modelli;
import com.roma.elettorale.modelli3D.unidoc.entity.streamModelli;

import java.time.LocalDate;
import java.util.List;

public interface IStreamService {

    List<streamModelli> findByDatacarimento(LocalDate dataCaricamento);
    List<streamModelli> findById(int refidstream);
    List<streamModelli> findByNumero(int numero);
    List<streamModelli> findByTipologia(int tipologia);
    void Save(streamModelli c);
    Integer getMaxId();
}
