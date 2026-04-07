package com.alexiscaos.backend_fichajes.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alexiscaos.backend_fichajes.DTO.UsuarioDTO;
import com.alexiscaos.backend_fichajes.model.Usuario;
import com.alexiscaos.backend_fichajes.repository.UsuarioRepository;
import com.alexiscaos.backend_fichajes.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/usuarios")
	public List<Usuario> allUsuarios(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUno(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }
	
	@PostMapping("/usuario")
	public Usuario postMethodName(@RequestBody Usuario entity) {
		return repository.save(entity);
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario putMethodName(@PathVariable Integer id, @RequestBody Usuario entity) {		
		return repository.save(entity);
	}
	
	
}
