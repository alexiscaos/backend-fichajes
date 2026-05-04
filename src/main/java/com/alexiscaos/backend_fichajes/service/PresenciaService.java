package com.alexiscaos.backend_fichajes.service;

import com.alexiscaos.backend_fichajes.model.Presencia;
import java.util.List;

public interface PresenciaService {
	
	List<Presencia> obtenerPresenciasPorUsuario(Integer usuarioId);
}
