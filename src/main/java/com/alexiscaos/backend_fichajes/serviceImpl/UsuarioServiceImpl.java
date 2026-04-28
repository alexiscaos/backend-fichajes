package com.alexiscaos.backend_fichajes.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // Asegúrate de este import
import org.springframework.stereotype.Service;
import com.alexiscaos.backend_fichajes.model.Usuario;
import com.alexiscaos.backend_fichajes.repository.UsuarioRepository;
import com.alexiscaos.backend_fichajes.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario Login(String username, String password) {
		
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("No encontrado"));
		
		if(passwordEncoder.matches(password, usuario.getPassword())) {
			return usuario;
		} else {
			throw new RuntimeException("Contraseña incorrecta");
		}
	}
	
	@Override
	public Usuario Registrar(Usuario usuario) {
		if(usuarioRepository.existsByUsername(usuario.getUsername())) {
			throw new RuntimeException("El nombre de usuario ya existe");
		}
		String passwordHash = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(passwordHash);
		return usuarioRepository.save(usuario);
	}
}
