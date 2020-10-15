package com.insight68.loginTracking;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.insight68.configurer.Auditable;

@Entity
@Table(name = "pageInPageOutTracing")
public class IndividualPageTracing extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "userlogined")
	public String email;

	@Column(name = "tokenGeneratedDuringLogin")
	public String token;

	@Column(name = "pageEntered")
	public String pageEnteredName;

	@Column
	@Temporal(TIMESTAMP)
	public Date pageEnteredTime;

	@Column
	@Temporal(TIMESTAMP)
	public Date pageExitedTime;

	@Column
	@Temporal(TIMESTAMP)
	public Date totalTimeSpentOnPage;

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

	public Date getPageEnteredTime() {
		return pageEnteredTime;
	}

	public void setPageEnteredTime(Date pageEnteredTime) {
		this.pageEnteredTime = pageEnteredTime;
	}

	public Date getPageExitedTime() {
		return pageExitedTime;
	}

	public void setPageExitedTime(Date pageExitedTime) {
		this.pageExitedTime = pageExitedTime;
	}

	public Date getTotalTimeSpentOnPage() {
		return totalTimeSpentOnPage;
	}

	public String getPageEnteredName() {
		return pageEnteredName;
	}

	public void setPageEnteredName(String pageEnteredName) {
		this.pageEnteredName = pageEnteredName;
	}

	public void setTotalTimeSpentOnPage(Date totalTimeSpentOnPage) {
		this.totalTimeSpentOnPage = totalTimeSpentOnPage;
	}

}
