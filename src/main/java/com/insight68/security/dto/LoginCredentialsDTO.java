package com.insight68.security.dto;

import java.io.Serializable;

/**
 * Login details data transfer object.
 * 
 * @author VSanthosh
 *
 */
public class LoginCredentialsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String password;

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
