package com.insight68.loginTracking;

public class IndividualPageTracingDTO {

	public Long id;

	public String email;

	public String token;

	public String pageEnteredName;

	public String pageEnteredTime;

	public String pageExitedTime;

	public String totalTimeSpentOnPage;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPageEnteredName() {
		return pageEnteredName;
	}

	public void setPageEnteredName(String pageEnteredName) {
		this.pageEnteredName = pageEnteredName;
	}

	public String getPageEnteredTime() {
		return pageEnteredTime;
	}

	public void setPageEnteredTime(String pageEnteredTime) {
		this.pageEnteredTime = pageEnteredTime;
	}

	public String getPageExitedTime() {
		return pageExitedTime;
	}

	public void setPageExitedTime(String pageExitedTime) {
		this.pageExitedTime = pageExitedTime;
	}

	public String getTotalTimeSpentOnPage() {
		return totalTimeSpentOnPage;
	}

	public void setTotalTimeSpentOnPage(String totalTimeSpentOnPage) {
		this.totalTimeSpentOnPage = totalTimeSpentOnPage;
	}

}
