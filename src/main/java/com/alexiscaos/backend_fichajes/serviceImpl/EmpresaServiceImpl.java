package com.alexiscaos.backend_fichajes.serviceImpl;

import com.alexiscaos.backend_fichajes.model.Empresa;
import com.alexiscaos.backend_fichajes.repository.EmpresaRepository;
import com.alexiscaos.backend_fichajes.service.EmpresaService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Empresa guardarEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public Optional<Empresa> obtenerEmpresaPorId(Integer idEmpresa) {
		return empresaRepository.findById(idEmpresa);
	}

}
