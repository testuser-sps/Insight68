package com.insight68.loginTracking;

public class PageLoginLogoutTracingDTO {

	public Long id;

	public String email;

	public String token;

	public String userLoginedTime;

	public String userLogoutTime;

	public String totalTimeSpentOnWebsite;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserLoginedTime() {
		return userLoginedTime;
	}

	public void setUserLoginedTime(String userLoginedTime) {
		this.userLoginedTime = userLoginedTime;
	}

	public String getUserLogoutTime() {
		return userLogoutTime;
	}

	public void setUserLogoutTime(String userLogoutTime) {
		this.userLogoutTime = userLogoutTime;
	}

	public String getTotalTimeSpentOnWebsite() {
		return totalTimeSpentOnWebsite;
	}

	public void setTotalTimeSpentOnWebsite(String string) {
		this.totalTimeSpentOnWebsite = string;
	}

}
