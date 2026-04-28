package com.alexiscaos.backend_fichajes.repository;

import org.springframework.data.domain.Page; // Correcto
import org.springframework.data.domain.Pageable; // Correcto
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alexiscaos.backend_fichajes.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional <Usuario> findByUsername(@Param("username") String username);
	
	Usuario findByCodEmpleado(@Param("codEmpleado") Integer codEmpleado);
	
	Usuario findByidUsuario(@Param("idUsuario") Integer idUsuario);

	List<Usuario> findByNameContainingIgnoreCaseOrLastnameContainingIgnoreCase(String name, String lastname);

	Page <Usuario> findAll(Pageable pageable);
	
	Page  <Usuario> findByNameContainingIgnoreCaseOrLastnameContainingIgnoreCase(String name, String lastname, Pageable pageable);
	
	boolean existsByEmail(String email);
	
	boolean existsByCodEmpleado(Integer codEmpleado);
	
	boolean existsByUsername(String username);
	
	boolean existsByPhone(String phone);
	
	
	
}
