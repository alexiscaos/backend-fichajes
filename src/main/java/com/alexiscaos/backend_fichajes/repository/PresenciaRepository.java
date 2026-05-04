package com.alexiscaos.backend_fichajes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.alexiscaos.backend_fichajes.model.Presencia;
import java.util.List;

@Repository
public interface PresenciaRepository extends JpaRepository<Presencia, Integer> {
	
	List<Presencia> findByUsuarioId(@Param("usuarioId") Integer usuarioId);
}
