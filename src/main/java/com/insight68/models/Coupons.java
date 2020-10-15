package com.insight68.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.insight68.configurer.Auditable;

@Entity
@Table(name = "coupons")
public class Coupons extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column
	public String emailAddress;

	@Column
	public String planName;

	@Column
	public Long discount;

	@Column
	public String couponCode;

	@Column
	public Date redeemedCouponCodeDate;

	@Column
	public boolean isCouponExpired;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Date getRedeemedCouponCodeDate() {
		return redeemedCouponCodeDate;
	}

	public void setRedeemedCouponCodeDate(Date redeemedCouponCodeDate) {
		this.redeemedCouponCodeDate = redeemedCouponCodeDate;
	}

	public boolean isCouponExpired() {
		return isCouponExpired;
	}

	public void setCouponExpired(boolean isCouponExpired) {
		this.isCouponExpired = isCouponExpired;
	}

}
