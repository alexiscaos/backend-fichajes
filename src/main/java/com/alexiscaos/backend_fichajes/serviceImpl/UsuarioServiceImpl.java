package com.alexiscaos.backend_fichajes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexiscaos.backend_fichajes.DTO.UsuarioDTO;
import com.alexiscaos.backend_fichajes.repository.UsuarioRepository;
import com.alexiscaos.backend_fichajes.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioDTO buscarPorId(Integer id) {
		return null;
		
	}

	@Override
	public List<UsuarioDTO> listarTodos() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll().stream()
				.map(u-> new UsuarioDTO(u.getIdUsuario(), u.getUsername(), u.getEmail(), "Empresa ..."))
				.toList();
	}
	
}
