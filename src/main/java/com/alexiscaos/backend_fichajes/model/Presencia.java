package com.alexiscaos.backend_fichajes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table (name="presencia")
@Data
public class Presencia implements Serializable {

	private static final long serialVersionUID =1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPresencia", nullable=false)
    private Integer idPresencia;
    
    @Column(name="idEmpresaPre", nullable=false)
    private Integer idEmpresa;
    
    @Column(name="idUsuarioPre", nullable=false)
    private Integer idUsuario;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaEntradaPre", nullable=false)
    private LocalDateTime fechaEntrada;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaSalidaPre")
    private LocalDateTime fechaSalida;
    
	@Column (name="coordEntPre", length = 23, nullable=false)
    private String coordEnt;
    
    @Column (name="coordSalPre", length = 23)
    private String coordSal;
    
    @Column (name="idCentroPre", nullable=false)
    private Integer centroId;
    
    @Column (name="preFisicaPre")
    private Boolean presenciaFisica;
    
    @Column (name="observPre", length = 80)
    private String observPre;
    
	@Column(name="tiempoPre")
    private BigDecimal tiempo;
	
    public BigDecimal getTiempo() {
		return tiempo;
	}

	public void setTiempo(BigDecimal tiempo) {
		this.tiempo = tiempo;
	}

    public String getObservPre() {
		return observPre;
	}

	public void setObservPre(String observPre) {
		this.observPre = observPre;
	}

	public String getCoordEnt() {
		return coordEnt;
	}

	public void setCoordEnt(String coordEnt) {
		this.coordEnt = coordEnt;
	}

	public String getCoordSal() {
		return coordSal;
	}

	public void setCoordSal(String coordSal) {
		this.coordSal = coordSal;
	}
    
    public Integer getId() {
		return idPresencia;
	}

	public void setId(Integer id) {
		this.idPresencia = id;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdPresencia() {
		return idPresencia;
	}

	public void setIdPresencia(Integer idPresencia) {
		this.idPresencia = idPresencia;
	}

	public Boolean getPresenciaFisica() {
		return presenciaFisica;
	}

	public void setPresenciaFisica(Boolean presenciaFisica) {
		this.presenciaFisica = presenciaFisica;
	}

	public Integer getCentroId() {
		return centroId;
	}

	public void setCentroId(Integer centroId) {
		this.centroId = centroId;
	}
	
}
