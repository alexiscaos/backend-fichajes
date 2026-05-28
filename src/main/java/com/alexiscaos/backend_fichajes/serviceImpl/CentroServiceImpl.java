package com.alexiscaos.backend_fichajes.serviceImpl;

import com.alexiscaos.backend_fichajes.model.Centro;
import com.alexiscaos.backend_fichajes.repository.CentroRepository;
import com.alexiscaos.backend_fichajes.service.CentroService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentroServiceImpl implements CentroService {
	
	@Autowired
	private  CentroRepository centroRepository;
	

	@Override
	public Centro guardarCentro(Centro centro) {
		return centroRepository.save(centro);
	}
	
	@Override
	public List<Centro> obtenerCentroPorEmpresaId(Integer idEmpresa) {
		return centroRepository.findByEmpresaId(idEmpresa);
	}
	
	@Override
	public Centro obtenerCentroPorNombre(String nombreCentro) {
		return centroRepository.findByNombreCentro(nombreCentro).orElse(null);
	}
	
	@Override
	public Centro obtenerCentroPorDireccion(String direccCentro) {
		return centroRepository.findByDireccCentro(direccCentro).orElse(null);
	}

}
