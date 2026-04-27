package com.alexiscaos.backend_fichajes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "presencia")
public class Presencia implements Serializable {
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pre", nullable = false)
	private Integer idPresencia;
	
	@Column(name = "fecha_pre", nullable = false)
	private Date fechaPresencia;
	
	@Column(name = "hora_pre", nullable = false)
	private BigDecimal horaPresencia;
	
	@Column(name = "isEntrada_pre", nullable = false)
	private Boolean isEntrada;
	
	@Column(name = "usuario_id", nullable = false)
	private Integer usuarioId;

	@Column(name = "centro_id", nullable = false)
	private Integer centroId;
	
	@Column(name = "dispositivo_id", nullable = false)
	private Integer dispositivoId;
	
	@Column(name = "remoto_pre", nullable = false)
	private boolean remoto;
	
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	
	@Column(name = "created_by", nullable = false)
	private Integer createdBy;
	
	@Column(name = "updated_by", nullable = true)
	private Integer updatedBy;
	
	@Column(name = "updated_at", nullable = true)
	private Date updatedAt;
}
