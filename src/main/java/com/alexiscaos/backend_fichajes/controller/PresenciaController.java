package com.alexiscaos.backend_fichajes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alexiscaos.backend_fichajes.model.Presencia;
import com.alexiscaos.backend_fichajes.repository.PresenciaRepository;

@RestController
@RequestMapping("/api")
public class PresenciaController {
	
	@Autowired
	private PresenciaRepository repository;
	
	@GetMapping("/presencias")
	public List <Presencia> allPresencias(){
		return repository.findAll();	
	}
	
	@GetMapping("/presencias/{id}")
	public List <Presencia> findPresenciaById(@PathVariable Integer id){
		return repository.findByIdUsuario(id);	
	}
	
	@PostMapping("/presencia")
	public Presencia postPresencia(@RequestBody Presencia Entity) {
		return repository.save(Entity);
	}
	
//	@GetMapping("/presencia/{fecha}")
//	public list <Presencia> findByFechaHoy
}
