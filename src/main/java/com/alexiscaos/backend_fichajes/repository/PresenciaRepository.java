package com.alexiscaos.backend_fichajes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.alexiscaos.backend_fichajes.model.Presencia;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
@Repository
public interface PresenciaRepository extends JpaRepository<Presencia, Integer> {
	
	List<Presencia> findByUsuarioId(@Param("usuarioId") Integer usuarioId);
	
	Optional <Presencia> findByFechaPresenciaBetween(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
	
	Optional <Presencia> findByFechaPresenciaBetweenAndUsuarioId(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin, @Param("usuarioId") Integer usuarioId);
	
}
