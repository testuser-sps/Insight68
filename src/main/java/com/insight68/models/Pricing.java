package com.insight68.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.insight68.configurer.Auditable;

@Entity
@Table(name = "pricing")
public class Pricing extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column
	public Long aiModule;

	@Column
	public Long inventoryModule;

	@Column
	public Long schedularOrderLogistics;

	@Column
	public Long irtClinicalStudied;

	@Column(unique = true)
	public String pricingPlans;

	public String getPricingPlans() {
		return pricingPlans;
	}

	public void setPricingPlans(String pricingPlans) {
		this.pricingPlans = pricingPlans;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAiModule() {
		return aiModule;
	}

	public void setAiModule(Long aiModule) {
		this.aiModule = aiModule;
	}

	public Long getInventoryModule() {
		return inventoryModule;
	}

	public void setInventoryModule(Long inventoryModule) {
		this.inventoryModule = inventoryModule;
	}

	public Long getSchedularOrderLogistics() {
		return schedularOrderLogistics;
	}

	public void setSchedularOrderLogistics(Long schedularOrderLogistics) {
		this.schedularOrderLogistics = schedularOrderLogistics;
	}

	public Long getIrtClinicalStudied() {
		return irtClinicalStudied;
	}

	public void setIrtClinicalStudied(Long irtClinicalStudied) {
		this.irtClinicalStudied = irtClinicalStudied;
	}

}
