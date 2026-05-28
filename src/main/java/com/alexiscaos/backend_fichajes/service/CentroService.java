package com.alexiscaos.backend_fichajes.service;

import com.alexiscaos.backend_fichajes.model.Centro;
import java.util.List;

public interface CentroService {

	Centro guardarCentro(Centro centro);
	
	List<Centro> obtenerCentroPorEmpresaId(Integer idEmpresa);
	
	Centro obtenerCentroPorNombre(String nombreCentro);
	
	Centro obtenerCentroPorDireccion(String direccCentro);
}
