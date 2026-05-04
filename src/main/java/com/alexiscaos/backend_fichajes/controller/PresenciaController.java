package com.alexiscaos.backend_fichajes.controller;

import com.alexiscaos.backend_fichajes.model.Presencia;
import com.alexiscaos.backend_fichajes.service.PresenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.alexiscaos.backend_fichajes.model.Usuario;
import com.alexiscaos.backend_fichajes.repository.UsuarioRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/presencia")
public class PresenciaController {
	
	@Autowired
	private PresenciaService presenciaService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/mis-presencias")
	public ResponseEntity<?> obtenerMisPresencias(Authentication authentication) {
		try {
			String username = authentication.getName();
			Usuario usuario = usuarioRepository.findByUsername(username)
					.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
			List<Presencia> presencias = presenciaService.obtenerPresenciasPorUsuario(usuario.getIdUsuario());
			return ResponseEntity.ok(presencias);
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<?> obtenerPresenciasUsuario(@PathVariable Integer usuarioId, Authentication authentication) {
		try {
			List<Presencia> presencias = presenciaService.obtenerPresenciasPorUsuario(usuarioId);
			return ResponseEntity.ok(presencias);
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
}
