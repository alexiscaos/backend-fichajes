package com.alexiscaos.backend_fichajes.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alexiscaos.backend_fichajes.service.JwtService;
import com.alexiscaos.backend_fichajes.service.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
	                                 HttpServletResponse response, 
	                                 FilterChain filterChain) throws ServletException, IOException {
		try {
			// Extraer token del header Authorization
			String token = extractTokenFromRequest(request);
			
			// Si el token existe y es válido
			if (token != null && jwtService.isTokenValid(token)) {
				// Extraer username del token
				String username = jwtService.extractUsername(token);
				
				// Cargar detalles del usuario
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				
				// Crear objeto de autenticación
				UsernamePasswordAuthenticationToken authentication = 
					new UsernamePasswordAuthenticationToken(
						userDetails, 
						null, 
						userDetails.getAuthorities()
					);
				
				authentication.setDetails(
					new WebAuthenticationDetailsSource().buildDetails(request)
				);
				
				// Establecer la autenticación en el contexto de seguridad
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			logger.error("No se pudo establecer autenticación de usuario", e);
		}
		
		// Continuar con el siguiente filtro
		filterChain.doFilter(request, response);
	}
	
	/**
	 * Extrae el JWT del header Authorization
	 * Formato esperado: "Bearer <token>"
	 */
	private String extractTokenFromRequest(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);  // Remover "Bearer " (7 caracteres)
		}
		
		return null;
	}
}
