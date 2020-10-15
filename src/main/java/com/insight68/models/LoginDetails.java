package com.insight68.models;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.insight68.configurer.Auditable;

@Entity
@Table(name = "LoginCredentials")
public class LoginDetails extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column
	public String UserName;

	@Column
	public String lastName;

	@Column
	public String password;

	@Column
	public String email;

	@Column(columnDefinition = "varchar(255) default 'USER'")
	public String role;

	@Column
	@Temporal(TIMESTAMP)
	public Date recentLoginTime;

	@Column
	@Temporal(TIMESTAMP)
	public Date recentLogoutTime;

	@Column
	@Temporal(TemporalType.TIME)
	public Date totalTimeSpent;

	@Column(columnDefinition = "boolean default true")
	public boolean firstLoginStatus;

	@Column(name = "isUserBlocked", columnDefinition = "varchar(255) default 'ALLOWED'")
	public String isUserBlocked;

	@Column(name = "noOfLoginAttemptsByUser")
	public Long noOfLoginAttemptsByUser;

	public Long getNoOfLoginAttemptsByUser() {
		return noOfLoginAttemptsByUser;
	}

	public void setNoOfLoginAttemptsByUser(Long noOfLoginAttemptsByUser) {
		this.noOfLoginAttemptsByUser = noOfLoginAttemptsByUser;
	}

	public boolean isFirstLoginStatus() {
		return firstLoginStatus;
	}

	public void setFirstLoginStatus(boolean firstLoginStatus) {
		this.firstLoginStatus = firstLoginStatus;
	}

	public String getIsUserBlocked() {
		return isUserBlocked;
	}

	public void setIsUserBlocked(String isUserBlocked) {
		this.isUserBlocked = isUserBlocked;
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

	public Date getRecentLoginTime() {
		return recentLoginTime;
	}

	public void setRecentLoginTime(Date recentLoginTime) {
		this.recentLoginTime = recentLoginTime;
	}

	public Date getRecentLogoutTime() {
		return recentLogoutTime;
	}

	public void setRecentLogoutTime(Date recentLogoutTime) {
		this.recentLogoutTime = recentLogoutTime;
	}

	public Date getTotalTimeSpent() {
		return totalTimeSpent;
	}

	public void setTotalTimeSpent(Date totalTimeSpent) {
		this.totalTimeSpent = totalTimeSpent;
	}

}
