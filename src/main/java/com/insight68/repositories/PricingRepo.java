package com.insight68.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insight68.models.Pricing;
import java.lang.String;

public interface PricingRepo extends JpaRepository<Pricing, Long> {

	Pricing findOneByPricingPlans(String pricingplans);
}
