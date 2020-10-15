package com.insight68.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.insight68.configurer.Auditable;

@Entity
@Table(name = "contactus")
public class ContactUs extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "f_name")
	public String fName;

	@Column(name = "l_name")
	public String lName;

	@Column(name = "email_address")
	public String emailAddress;

	@Column(name = "subject")
	public String subject;

	@Column(name = "select_product")
	public String selectProduct;

	@Column(name = "social_mediaid")
	public String socialMediaId;

	@Column(name = "whatsappNumber")
	public String whatsappNumber;
	
	@Column(name = "message", columnDefinition = "TEXT")
	public String message;

	public String getWhatsappNumber() {
		return whatsappNumber;
	}

	public void setWhatsappNumber(String whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSelectProduct() {
		return selectProduct;
	}

	public void setSelectProduct(String selectProduct) {
		this.selectProduct = selectProduct;
	}

	public String getSocialMediaId() {
		return socialMediaId;
	}

	public void setSocialMediaId(String socialMediaId) {
		this.socialMediaId = socialMediaId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
