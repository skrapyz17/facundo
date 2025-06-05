package org.pacifico.persistence;

import org.pacifico.entity.bean.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {

    @Query("SELECT h FROM HistoriaClinica h JOIN h.cliente c WHERE c.dni = :dni")
    List<Historia	Clinica> findByClienteDni(@Param("dni") String dni);
}