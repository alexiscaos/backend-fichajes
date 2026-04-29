package com.alexiscaos.backend_fichajes.service;

import com.alexiscaos.backend_fichajes.model.Usuario;


public interface AuthService {
	
	String Login(String username, String password);
	
	Usuario Registrar(Usuario usuario);
	
}
