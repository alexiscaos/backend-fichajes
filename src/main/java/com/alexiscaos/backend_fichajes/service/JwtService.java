package com.alexiscaos.backend_fichajes.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alexiscaos.backend_fichajes.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	@Value("${project.jwt.secret}")
    private String secretKey;
	
	@Value("${project.jwt.expiration:1800000}")
	private long accessTokenExpiration;
	
	private static final long REFRESH_TOKEN_EXPIRATION = 7 * 24 * 60 * 60 * 1000;

	public String generateAccessToken(Usuario usuario) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("idUsuario", usuario.getIdUsuario());
        claims.put("nombre", usuario.getName());
        claims.put("email", usuario.getEmail());
        
        return createToken(claims, usuario.getUsername(), accessTokenExpiration);
    }
	
	public String generateRefreshToken(Usuario usuario) {
		return createToken(new HashMap<>(), usuario.getUsername(), REFRESH_TOKEN_EXPIRATION);
	}
	
	private String createToken(Map<String, Object> claims, String subject, long expiration) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey())
                .compact();
    }
	
	public boolean isTokenValid(String token) {
		try {
			Jwts.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}
	
	public String extractUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	public Integer extractIdUsuario(String token) {
		Object idUsuario = getClaims(token).get("idUsuario");
		if (idUsuario instanceof Integer) {
			return (Integer) idUsuario;
		} else if (idUsuario instanceof Long) {
			return ((Long) idUsuario).intValue();
		}
		return null;
	}
	
	private Claims getClaims(String token) {
		return Jwts.parserBuilder()
			.setSigningKey(getSignInKey())
			.build()
			.parseClaimsJws(token)
			.getBody();
	}

    private SecretKey getSignInKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
}
