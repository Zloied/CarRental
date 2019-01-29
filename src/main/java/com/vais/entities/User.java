package com.vais.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Eduard . This class is entity for User from Database. This class has
 *         generated getters and setters for interaction with fields like id ,
 *         name etc.
 *
 */
@Entity
@Table(name = "car_rental.users")
public class User implements Serializable {

	private static final long serialVersionUID = -4062784936522642553L;

	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_PASSWORD = "password";
	public static final String ATTRIBUTE_ROLE = "role";
	public static final String ATTRIBUTE_EMAIL = "email";
	public static final String ATTRIBUTE_STATUS = "status";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_seq")
	@SequenceGenerator(name = "rental_seq", sequenceName = "car_rental.users_id_seq", allocationSize = 10)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	@Column(name = "email")
	private String email;

	@Column(name = "status")
	private String status;

	public User() {

	}

	public User(String name, String password, String role, String email, String status) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
		this.email = email;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + ", email=" + email
				+ ", status=" + status + "]";
	}

}
