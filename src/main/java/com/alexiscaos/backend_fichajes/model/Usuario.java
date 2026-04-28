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

	@Column(name = "password_usr", nullable = false, length = 60)
	private String password;

	@Column(name = "name_usr", nullable = false, length = 60)
	private String name;

	@Column(name = "email_usr", nullable = false)
	private String email;
	
	@Column(name = "phone_usr", nullable = false)
	private String phone;
	
	@Column(name = "lastname_usr", nullable = false, length = 60)
	private String lastname;
	
	@Column(name = "codEmpleado_usr", nullable = false)
	private Integer codEmpleado;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(Integer codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "users_rol", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
//	private Set<Rol> roles = new HashSet<>();
//
//	@ManyToOne(fetch = FetchType.LAZY) 
//    @JoinColumn(name = "empresa_id")   
//    private Empresa empresa;
//


}
