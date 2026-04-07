package com.alexiscaos.backend_fichajes.DTO;

public record UsuarioDTO(
		Integer idUsuario,
		String username,
		String email,
		String nombreEmpresa
) {}
