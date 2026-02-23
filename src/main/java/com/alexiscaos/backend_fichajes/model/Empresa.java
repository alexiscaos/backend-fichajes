package com.alexiscaos.backend_fichajes.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="empresa")
@Data
public class Empresa implements Serializable{

	private static final long serialVersionUID =  1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEmp", nullable=false)
    private Integer idEmpresa;
    
    @Column (name="nombrEmp", length = 80 )
    private String nombre;
    
    @Column (name="ausenciasEmp")
    private Boolean ausencias;

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getAusencias() {
		return ausencias;
	}

	public void setAusencias(Boolean ausencias) {
		this.ausencias = ausencias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
