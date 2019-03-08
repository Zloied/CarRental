package com.vais.models;

/**
 * this is POJO class used to represent certain columns from users table in
 * database such as: user's id, user's name, user's email
 * 
 * @author Eduard
 *
 */
public class UserInfo {
	private Long id;
	private String name;
	private String email;

	public UserInfo(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
