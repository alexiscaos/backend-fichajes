package com.alexiscaos.backend_fichajes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.alexiscaos.backend_fichajes.model.Empresa;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
	List<Empresa> findByNombreEmpresa(@Param("nombreEmpresa") String nombreEmpresa);
	
	Optional <Empresa> findByIdEmpresa(@Param("idEmpresa") Integer idEmpresa);

}
