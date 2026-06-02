package com.alexiscaos.backend_fichajes.service;

import com.alexiscaos.backend_fichajes.model.Presencia;
import java.util.List;
import java.util.Optional;

import com.alexiscaos.backend_fichajes.model.Usuario;
public interface PresenciaService {
	
	List<Presencia> obtenerPresenciasPorUsername(String username);
	List<Presencia> obtenerPresenciasPorUsuario(Integer usuarioId);
	Presencia guardarPresencia( Integer usuario);
	List<Presencia> presenciasDelDia(Integer usuarioId);
	Optional<Presencia> obtenerUltimaPresencia(Integer usuarioId);
}
