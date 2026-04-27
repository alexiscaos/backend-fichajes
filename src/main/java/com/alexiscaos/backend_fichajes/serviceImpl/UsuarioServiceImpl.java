package com.alexiscaos.backend_fichajes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.alexiscaos.backend_fichajes.model.Usuario;
import com.alexiscaos.backend_fichajes.repository.UsuarioRepository;
import com.alexiscaos.backend_fichajes.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario Login(String username, String password) {
		
		return usuarioRepository.findByUsername(username)
				.map(u -> u.getPassword().equals(password) ? u: null)
				.orElseThrow(() -> new RuntimeException("No encontrado"))
				;
		
	}
	
	@Override
	public Usuario Registrar(Usuario usuario) {
		if(usuarioRepository.existsByUsername(usuario.getUsername())) {
			throw new RuntimeException("El nombre de usuario ya existe");
		}
		return usuarioRepository.save(usuario);
	}
}
