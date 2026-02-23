package com.alexiscaos.backend_fichajes.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alexiscaos.backend_fichajes.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
    Usuario findByUsername(@Param("username") String userName);

	List<Usuario> findByName(@Param("name") String name);

}
