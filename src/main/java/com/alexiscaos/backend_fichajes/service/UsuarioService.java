package com.alexiscaos.backend_fichajes.service;

import com.alexiscaos.backend_fichajes.model.Usuario;


public interface UsuarioService {
	
	Usuario Login(String username, String password);
	
	Usuario Registrar(Usuario usuario);
	
}
