package com.alexiscaos.backend_fichajes.service;

import java.util.List;
import java.util.Optional;
import com.alexiscaos.backend_fichajes.model.Empresa;

public interface EmpresaService {
	
	Empresa guardarEmpresa(Empresa empresa);
		
	Optional <Empresa> obtenerEmpresaPorId(Integer idEmpresa);

}
