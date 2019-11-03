package com.roma.elettorale.modelli3D.unidoc.repository;

import com.roma.elettorale.modelli3D.unidoc.entity.streamModelli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface StreamDAO extends JpaRepository<streamModelli, Long> {


    List<streamModelli> findByDatacarimento(LocalDate dataCaricamento);
    List<streamModelli> findById(int refidstream);
    List<streamModelli> findByNumero(int numero);
    List<streamModelli> findByTipologia(int tipologia);
    @Query("SELECT coalesce(max(ch.numero), 0) FROM streamModelli ch where id=(select max(id) from streamModelli )")
    Integer getMaxId();


}
