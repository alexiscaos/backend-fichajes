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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/presencia")
public class PresenciaController {
	
	@Autowired
	private PresenciaService presenciaService;
	
	@GetMapping("/mis-presencias")
	public ResponseEntity<?> obtenerMisPresencias(Authentication authentication) {
		try {
			String username = authentication.getName();
			List<Presencia> presencias = presenciaService.obtenerPresenciasPorUsername(username);
			return ResponseEntity.ok(presencias);
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
	
	@GetMapping("/presencia/{usuarioId}")
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
	
	@PostMapping("guardarPresencia/{usuarioId}")
	public ResponseEntity<?> guardarPresencia(@PathVariable Integer usuarioId, @PathVariable BigDecimal tiempo, @PathVariable Boolean entrada, Authentication authentication) {
		try {
			Presencia presencia = presenciaService.guardarPresencia(usuarioId, tiempo, entrada);
			return ResponseEntity.ok(presencia);
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<?> obtenerPresenciasDelDia(@PathVariable Integer usuarioId, Authentication authentication) {
		try {
			List<Presencia> presencias = presenciaService.presenciasDelDia(usuarioId);
			return ResponseEntity.ok(presencias);
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
	
	@GetMapping("/ultima/{usuarioId}")
	public ResponseEntity<?> obtenerUltimaPresencia(@PathVariable Integer usuarioId, Authentication authentication) {
	    try {
	        Optional<Presencia> presenciaOpt = presenciaService.obtenerUltimaPresencia(usuarioId);

	        if (presenciaOpt.isPresent()) {
	            return ResponseEntity.ok(presenciaOpt.get());
	        } else {
	            Map<String, String> error = new HashMap<>();
	            error.put("mensaje", "No se encontró ninguna presencia para el usuario con ID: " + usuarioId);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	        }

	    } catch (Exception e) {
	        Map<String, String> error = new HashMap<>();
	        error.put("error", e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	    }
	}
}
