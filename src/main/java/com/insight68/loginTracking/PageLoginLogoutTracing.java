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
@Table(name = "pageloginlogouttracing")
public class PageLoginLogoutTracing extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "userlogined")
	public String email;

	@Column(name = "tokenGeneratedDuringLogin")
	public String token;

	@Column
	@Temporal(TIMESTAMP)
	public Date userLoginedTime;

	@Column
	@Temporal(TIMESTAMP)
	public Date userLogoutTime;

	@Column
	@Temporal(TIMESTAMP)
	public Date totalTimeSpentOnWebsite;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getUserLoginedTime() {
		return userLoginedTime;
	}

	public void setUserLoginedTime(Date userLoginedTime) {
		this.userLoginedTime = userLoginedTime;
	}

	public Date getTotalTimeSpentOnWebsite() {
		return totalTimeSpentOnWebsite;
	}

	public void setTotalTimeSpentOnWebsite(Date totalTimeSpentOnWebsite) {
		this.totalTimeSpentOnWebsite = totalTimeSpentOnWebsite;
	}

	public Date getUserLogoutTime() {
		return userLogoutTime;
	}

	public void setUserLogoutTime(Date userLogoutTime) {
		this.userLogoutTime = userLogoutTime;
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

}
