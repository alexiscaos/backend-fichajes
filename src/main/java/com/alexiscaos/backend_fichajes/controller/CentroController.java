package com.alexiscaos.backend_fichajes.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.alexiscaos.backend_fichajes.service.CentroService;
import com.alexiscaos.backend_fichajes.model.Centro;
import java.util.List;

@RestController
@RequestMapping("/api/centros")
public class CentroController {
	
	@Autowired
	private CentroService centroService;
	
	@PostMapping ("/guardar")
	public ResponseEntity<?> guardarCentro(@RequestBody Centro centro, Authentication authentication) {
		try {
			Centro nuevoCentro = centroService.guardarCentro(centro);
			return ResponseEntity.ok(nuevoCentro);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/empresa/{empresaId}")
	public ResponseEntity<?> obtenerCentrosPorEmpresaId(@PathVariable Integer empresaId, Authentication authentication) {
		try {
			List<Centro> centros = centroService.obtenerCentroPorEmpresaId(empresaId);
			return ResponseEntity.ok(centros);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/nombre/{nombreCentro}")
	public ResponseEntity<?> obtenerCentroPorNombre(@PathVariable String nombreCentro, Authentication authentication) {
		try {
			Centro centro = centroService.obtenerCentroPorNombre(nombreCentro);
			if (centro != null) {
				return ResponseEntity.ok(centro);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/direccion/{direccCentro}")
	public ResponseEntity<?> obtenerCentroPorDireccion(@PathVariable String direccCentro, Authentication authentication) {
		try {
			Centro centro = centroService.obtenerCentroPorDireccion(direccCentro);
			if (centro != null) {
				return ResponseEntity.ok(centro);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}


