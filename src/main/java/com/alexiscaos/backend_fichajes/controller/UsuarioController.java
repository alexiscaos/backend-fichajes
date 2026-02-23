package com.alexiscaos.backend_fichajes.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alexiscaos.backend_fichajes.model.Usuario;
import com.alexiscaos.backend_fichajes.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/usuarios")
	public List<Usuario> allUsuarios(){
		return repository.findAll();
	}
	
	@PostMapping("/usuario")
	public Usuario postMethodName(@RequestBody Usuario entity) {
		
		return repository.save(entity);
	}
	
}
