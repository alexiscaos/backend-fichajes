package com.alexiscaos.backend_fichajes.model;

import java.io.Serializable;

import jakarta.persistence.*;


@Table(name = "rol")
@Entity

public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rolId;
	
	@Column(name = "descrip", nullable = false)
	private String descrip;
}
