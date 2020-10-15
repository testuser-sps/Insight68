package com.insight68.loginSecurityDTO;

import java.io.Serializable;
import java.util.Objects;
import com.insight68.models.LoginDetails;

/**
 * JWT data transfer object
 * 
 * @author VSanthosh
 *
 */
public class LoginResposeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String jwtToken;

	private String role;

	private String name;

	private String email;

	/**
	 * default constructor
	 */
	public LoginResposeDTO() {
	}

	/**
	 * @param jwtToken
	 * @param user
	 */
	public LoginResposeDTO(String jwtToken, LoginDetails user) {
		Objects.requireNonNull(user);
		this.jwtToken = jwtToken;
		this.role = user.getRole();
		this.name = user.getUserName();
		this.email = user.getEmail();
	}

	/**
	 * @return the jwtToken
	 */
	public String getJwtToken() {
		return jwtToken;
	}

	/**
	 * @param jwtToken the jwtToken to set
	 */
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
