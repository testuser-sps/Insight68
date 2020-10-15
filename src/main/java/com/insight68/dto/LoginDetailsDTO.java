package com.insight68.dto;

public class LoginDetailsDTO {

	public Long id;

	public String UserName;

	public String lastName;

	public String password;

	public String email;

	public String role;

	public String recentLoginTime;

	public String recentLogoutTime;

	public String totalTimeSpent;

	public String getRecentLoginTime() {
		return recentLoginTime;
	}

	public void setRecentLoginTime(String string) {
		this.recentLoginTime = string;
	}

	public String getRecentLogoutTime() {
		return recentLogoutTime;
	}

	public void setRecentLogoutTime(String recentLogoutTime) {
		this.recentLogoutTime = recentLogoutTime;
	}

	public String getTotalTimeSpent() {
		return totalTimeSpent;
	}

	public void setTotalTimeSpent(String totalTimeSpent) {
		this.totalTimeSpent = totalTimeSpent;
	}

	public Long getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
