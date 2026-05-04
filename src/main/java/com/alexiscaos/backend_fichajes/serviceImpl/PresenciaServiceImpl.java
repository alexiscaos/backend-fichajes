package com.alexiscaos.backend_fichajes.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alexiscaos.backend_fichajes.model.Presencia;
import com.alexiscaos.backend_fichajes.repository.PresenciaRepository;
import com.alexiscaos.backend_fichajes.service.PresenciaService;
import java.util.List;

@Service
public class PresenciaServiceImpl implements PresenciaService {
	
	@Autowired
	private PresenciaRepository presenciaRepository;

	@Override
	public List<Presencia> obtenerPresenciasPorUsuario(Integer usuarioId) {
		return presenciaRepository.findByUsuarioId(usuarioId);
	}
}
