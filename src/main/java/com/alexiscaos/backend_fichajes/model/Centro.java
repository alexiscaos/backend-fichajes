package com.alexiscaos.backend_fichajes.model;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "centro")
public class Centro implements Serializable {
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cntr", nullable = false)
	private Integer idCentro;
	
	@Column(name = "nombre_cntr", nullable = false, length = 60)
	private String nombreCentro;
	
	@Column(name = "nombre_cntr", nullable = false, length = 60)
	private String direccCentro;
	
	@Column(name = "latitud_cntr", nullable = false)
	private double latitudCentro;
	
	@Column(name = "longitud_cntr", nullable = false)
	private double longitudCentro;
	
	@Column(name = "empresa_id", nullable = false)
	private Integer empresaId;
	
}
