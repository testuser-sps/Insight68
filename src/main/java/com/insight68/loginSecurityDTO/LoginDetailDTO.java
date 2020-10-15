package com.insight68.loginSecurityDTO;

import java.io.Serializable;

/**
 * Login details data transfer object.
 * 
 * @author VSanthosh
 *
 */
public class LoginDetailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String UserName;

	private String password;

	private String email;

	/**
	 * @return the loginId
	 */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
