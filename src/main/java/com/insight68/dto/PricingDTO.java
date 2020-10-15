package com.insight68.dto;

public class PricingDTO {

	public Long id;

	public Long aiModule;

	public Long inventoryModule;

	public Long schedularOrderLogistics;

	public Long irtClinicalStudied;

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
