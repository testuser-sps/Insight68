package com.insight68.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.insight68.configurer.Auditable;

@Entity
@Table(name = "insightusers")
public class InsightUsers extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "firstname")
	public String firstName;

	@Column(name = "lastname")
	public String lastName;

	@Column(name = "emailaddress", unique = true)
	public String emailAddress;

	@Column(name = "password")
	public String password;

	@Column(name = "companydomain")
	public String companyDomain;

	@Column(name = "companyname")
	public String companyName;

	@Column(name = "question_one")
	public String Howmanypeopleworkatyourcompany;

	@Column(name = "question_two")
	public String Whatfielddoyouworkin;

	@Column(name = "question_three")
	public String Whichofthefollowingbestdescribesyourrole;

	@Column(name = "question_four")
	public String Whichofthesesoundsmostlikeyou;

	@Column(name = "plan")
	public String plan;

	@Column(name = "phoneNumber", unique = true)
	public String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyDomain() {
		return companyDomain;
	}

	public void setCompanyDomain(String companyDomain) {
		this.companyDomain = companyDomain;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getHowmanypeopleworkatyourcompany() {
		return Howmanypeopleworkatyourcompany;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public void setHowmanypeopleworkatyourcompany(String howmanypeopleworkatyourcompany) {
		Howmanypeopleworkatyourcompany = howmanypeopleworkatyourcompany;
	}

	public String getWhatfielddoyouworkin() {
		return Whatfielddoyouworkin;
	}

	public void setWhatfielddoyouworkin(String whatfielddoyouworkin) {
		Whatfielddoyouworkin = whatfielddoyouworkin;
	}

	public String getWhichofthefollowingbestdescribesyourrole() {
		return Whichofthefollowingbestdescribesyourrole;
	}

	public void setWhichofthefollowingbestdescribesyourrole(String whichofthefollowingbestdescribesyourrole) {
		Whichofthefollowingbestdescribesyourrole = whichofthefollowingbestdescribesyourrole;
	}

	public String getWhichofthesesoundsmostlikeyou() {
		return Whichofthesesoundsmostlikeyou;
	}

	public void setWhichofthesesoundsmostlikeyou(String whichofthesesoundsmostlikeyou) {
		Whichofthesesoundsmostlikeyou = whichofthesesoundsmostlikeyou;
	}

}
