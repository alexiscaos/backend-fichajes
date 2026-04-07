package com.alexiscaos.backend_fichajes.service;

import com.alexiscaos.backend_fichajes.DTO.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
	
	UsuarioDTO buscarPorId(Integer id);
	List<UsuarioDTO> listarTodos();
	
}
