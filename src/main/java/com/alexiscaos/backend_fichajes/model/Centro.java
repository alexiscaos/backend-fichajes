package com.alexiscaos.backend_fichajes.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "centro")
public class Centro implements Serializable {
	private static final long serialVersionUID =  1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCen", nullable=false)
    private Integer idCentro;
    
    @Column(name="idEmpresaCen", nullable=false)
    private Integer empresaId;
    
    @Column(name="coordenadasCen", length = 23)
    private String coordenadas;
    
    @Column(name="descripcionCen")
    private String descripcionCen;

	public Integer getId() {
		return idCentro;
	}

	public void setId(Integer id) {
		this.idCentro = id;
	}

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getDescripcionCen() {
		return descripcionCen;
	}

	public void setDescripcionCen(String descripcionCen) {
		this.descripcionCen = descripcionCen;
	}
}
