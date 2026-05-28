package com.alexiscaos.backend_fichajes.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alexiscaos.backend_fichajes.model.Centro;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import org.springframework.data.repository.query.Param;

@Repository
public interface CentroRepository extends JpaRepository<Centro, Integer> {
	
	Optional<Centro> findByNombreCentro(@Param("nombre") String nombre);
	
	Optional<Centro> findByDireccCentro(@Param("direccion") String direccion);
	
//	Optional<Centro> findByTelefono(@Param("telefono") String telefono);
	
//	Optional<Centro> findByEmail(@Param("email") String email);
	
	List<Centro> findByEmpresaId(@Param("empresaId") Integer empresaId);
}
