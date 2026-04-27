package com.alexiscaos.backend_fichajes.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@Column(name = "username_usr", nullable = false, length = 60)
	private String username;

	@Column(name = "password_usr", nullable = false, length = 12)
	private transient  String password;

	@Column(name = "name_usr", nullable = false, length = 60)
	private String name;

	@Column(name = "email_usr", nullable = false)
	private String email;
	
	@Column(name = "phone_usr", nullable = false)
	private transient String phone;
	
	@Column(name = "lastname_usr", nullable = false, length = 60)
	private String lastname;
	
	@Column(name = "codEmpleado_usr", nullable = false)
	private Integer codEmpleado;

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "users_rol", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
//	private Set<Rol> roles = new HashSet<>();
//
//	@ManyToOne(fetch = FetchType.LAZY) 
//    @JoinColumn(name = "empresa_id")   
//    private Empresa empresa;
//


}
