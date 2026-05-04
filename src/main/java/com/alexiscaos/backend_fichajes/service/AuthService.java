package com.alexiscaos.backend_fichajes.service;

import com.alexiscaos.backend_fichajes.model.Usuario;
import java.util.Map;


public interface AuthService {
	
	Map<String, String> Login(String username, String password);
	
	Usuario Registrar(Usuario usuario);
	
	Map<String, String> refreshAccessToken(String refreshToken);
	
}
