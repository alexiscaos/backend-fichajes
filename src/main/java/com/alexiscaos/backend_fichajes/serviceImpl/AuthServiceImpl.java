package com.alexiscaos.backend_fichajes.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.alexiscaos.backend_fichajes.model.Usuario;
import com.alexiscaos.backend_fichajes.repository.UsuarioRepository;
import com.alexiscaos.backend_fichajes.service.AuthService;
import com.alexiscaos.backend_fichajes.service.JwtService;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Map<String, String> Login(String username, String password) {
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		
		if(!passwordEncoder.matches(password, usuario.getPassword())) {
			throw new RuntimeException("Contraseña incorrecta");
		}
		
		String accessToken = jwtService.generateAccessToken(usuario);
		String refreshToken = jwtService.generateRefreshToken(usuario);
		
		Map<String, String> response = new HashMap<>();
		response.put("accessToken", accessToken);
		response.put("refreshToken", refreshToken);
		response.put("type", "Bearer");
		response.put("expiresIn", "1800"); 
		
		return response;
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
	
	@Override
	public Map<String, String> refreshAccessToken(String refreshToken) {
		if (!jwtService.isTokenValid(refreshToken)) {
			throw new RuntimeException("Refresh token inválido o expirado");
		}
		
		String username = jwtService.extractUsername(refreshToken);
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		
		String newAccessToken = jwtService.generateAccessToken(usuario);
		
		Map<String, String> response = new HashMap<>();
		response.put("accessToken", newAccessToken);
		response.put("type", "Bearer");
		response.put("expiresIn", "1800");
		
		return response;
	}
}
