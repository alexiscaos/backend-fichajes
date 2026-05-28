package com.alexiscaos.backend_fichajes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
	private LocalDateTime fechaPresencia;
	
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
	private LocalDateTime createdAt;
	
	@Column(name = "created_by", nullable = false)
	private Integer createdBy;
	
	@Column(name = "updated_by", nullable = true)
	private Integer updatedBy;
	
	@Column(name = "updated_at", nullable = true)
	private Date updatedAt;

	public Integer getIdPresencia() {
		return idPresencia;
	}

	public void setIdPresencia(Integer idPresencia) {
		this.idPresencia = idPresencia;
	}

	public LocalDateTime getFechaPresencia() {
		return fechaPresencia;
	}

	public void setFechaPresencia(LocalDateTime fechaPresencia) {
		this.fechaPresencia = fechaPresencia;
	}

	public BigDecimal getHoraPresencia() {
		return horaPresencia;
	}

	public void setHoraPresencia(BigDecimal horaPresencia) {
		this.horaPresencia = horaPresencia;
	}

	public Boolean getIsEntrada() {
		return isEntrada;
	}

	public void setIsEntrada(Boolean isEntrada) {
		this.isEntrada = isEntrada;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getCentroId() {
		return centroId;
	}

	public void setCentroId(Integer centroId) {
		this.centroId = centroId;
	}

	public Integer getDispositivoId() {
		return dispositivoId;
	}

	public void setDispositivoId(Integer dispositivoId) {
		this.dispositivoId = dispositivoId;
	}

	public boolean isRemoto() {
		return remoto;
	}

	public void setRemoto(boolean remoto) {
		this.remoto = remoto;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
