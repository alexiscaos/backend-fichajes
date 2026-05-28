package com.alexiscaos.backend_fichajes.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.alexiscaos.backend_fichajes.service.EmpresaService;
import com.alexiscaos.backend_fichajes.model.Empresa;
import org.springframework.http.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarEmpresa(@RequestBody Empresa empresa) {
		try {
			Empresa nuevaEmpresa = empresaService.guardarEmpresa(empresa);
			return ResponseEntity.ok(nuevaEmpresa);
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
	
	@GetMapping("/{idEmpresa}")
	public ResponseEntity<?> obtenerEmpresaPorId(@PathVariable Integer idEmpresa) {
		try {
			return empresaService.obtenerEmpresaPorId(idEmpresa)
					.map(ResponseEntity::ok)
					.orElseGet(() -> ResponseEntity.notFound().build());
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
	
	
}

