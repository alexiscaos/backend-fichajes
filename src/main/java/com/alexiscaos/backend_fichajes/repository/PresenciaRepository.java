package com.alexiscaos.backend_fichajes.repository;

import org.springframework.data.jpa.repository.*;

import com.alexiscaos.backend_fichajes.model.Presencia;

import java.time.LocalDateTime;
import java.util.List;


public interface PresenciaRepository extends JpaRepository<Presencia, Integer>{
	
	Presencia findByIdPresencia(Integer idPresencia);
	
	List <Presencia> findByIdUsuario(Integer idUsuario);
	
	List<Presencia> findByIdUsuarioAndFechaEntradaBetween(Integer idUsuario, LocalDateTime inicio, LocalDateTime fin);

}
