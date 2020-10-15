package com.insight68.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.insight68.configurer.Auditable;

@Entity
@Table(name = "numberOfLoginAttempts")
public class NumberOfLoginAttempts extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "numberOfLoginAttemptsToAllow")
	public Long numberOfLoginAttemptsToAllow;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumberOfLoginAttemptsToAllow() {
		return numberOfLoginAttemptsToAllow;
	}

	public void setNumberOfLoginAttemptsToAllow(Long numberOfLoginAttemptsToAllow) {
		this.numberOfLoginAttemptsToAllow = numberOfLoginAttemptsToAllow;
	}

}
