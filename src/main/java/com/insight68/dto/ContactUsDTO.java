package com.insight68.dto;

public class ContactUsDTO {

	public Long id;

	public String fName;

	public String lName;

	public String emailAddress;

	public String subject;

	public String selectProduct;

	public String socialMediaId;
	
	public String whatsappNumber;

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
