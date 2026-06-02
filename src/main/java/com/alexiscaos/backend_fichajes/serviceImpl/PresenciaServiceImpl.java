package com.alexiscaos.backend_fichajes.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alexiscaos.backend_fichajes.model.Presencia;
import com.alexiscaos.backend_fichajes.model.Usuario;
import com.alexiscaos.backend_fichajes.repository.PresenciaRepository;
import com.alexiscaos.backend_fichajes.repository.UsuarioRepository;
import com.alexiscaos.backend_fichajes.service.PresenciaService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PresenciaServiceImpl implements PresenciaService {
	
	@Autowired
	private PresenciaRepository presenciaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Override
	public List<Presencia> obtenerPresenciasPorUsername(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		return presenciaRepository.findByUsuarioId(usuario.getIdUsuario());
	}
	
	public List<Presencia> obtenerPresenciasPorUsuario(Integer usuarioId) {
		return presenciaRepository.findByUsuarioId(usuarioId);
	}
	
	public Presencia guardarPresencia( Integer usuario) {
		Presencia presencia = new Presencia();
		BigDecimal bigDecimalHora = new BigDecimal("10"); 
		presencia.setUsuarioId(usuario);
		presencia.setHoraPresencia(bigDecimalHora);
		presencia.setFechaPresencia(java.time.LocalDateTime.now());
		presencia.setIsEntrada(true);
		presencia.setCentroId(1);
		presencia.setDispositivoId(1);
		presencia.setRemoto(false);
		presencia.setCreatedAt(java.time.LocalDateTime.now());
		presencia.setCreatedBy(usuario);
		return presenciaRepository.save(presencia);
	}
	
	public List<Presencia> presenciasDelDia(Integer usuarioId) {
		java.time.LocalDateTime inicioDia = java.time.LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
		java.time.LocalDateTime finDia = java.time.LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);
		return presenciaRepository.findByFechaPresenciaBetweenAndUsuarioId(inicioDia, finDia, usuarioId);
				
	}
	
	public Optional<Presencia> obtenerUltimaPresencia(Integer usuarioId) {
		return presenciaRepository.findLastPresenciaByUsuarioId(usuarioId);
	}
}
