package com.alexiscaos.backend_fichajes.controller;

import com.alexiscaos.backend_fichajes.model.Usuario;
import com.alexiscaos.backend_fichajes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/login")
	public String iniciarSesion(@RequestBody Usuario loginData) {
		try {
			Usuario usuario = usuarioService.Login(loginData.getUsername(), loginData.getPassword());
			return "Bienvenido " + usuario.getName() + ", login exitoso";
		}catch (Exception e) {
			return e.getMessage();
		}
	}

}
