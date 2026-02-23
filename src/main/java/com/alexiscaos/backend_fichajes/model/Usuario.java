package com.alexiscaos.backend_fichajes.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@Column(name = "username", nullable = false, length = 60)
	private String username;

	@Column(name = "password", nullable = false, length = 12)
	private String password;

	@Column(name = "name", nullable = false, length = 60)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_rol", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();

	@Column(name = "empresaId")
	private Integer EmpresaId;

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

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public Integer getEmpresaId() {
		return EmpresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		EmpresaId = empresaId;
	}
}
