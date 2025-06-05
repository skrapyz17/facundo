package org.pacifico.persistence;

import org.pacifico.entity.bean.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT c.nombre, h.diagnostico FROM Cliente c JOIN c.historiasClinicas h " +
		       "WHERE h.fecha > :fecha ORDER BY h.fecha DESC")
		public List<Object[]> findDiagnosticosClientes2024(@Param("fecha")LocalDate fecha);
    
    @Query(value = "SELECT * FROM cliente WHERE apellido LIKE 'A%'",nativeQuery = true)
        public List<Cliente> findByApellidoComienzanConA();
}