package com.alexiscaos.backend_fichajes.model;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "empresa")
public class Empresa implements Serializable {
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empr", nullable = false)
	private Integer idEmpresa;
	
	@Column(name = "nombre_empr", nullable = false, length = 60)
	private String nombre_empr;
}
