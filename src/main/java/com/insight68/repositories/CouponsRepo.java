package com.insight68.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.insight68.models.Coupons;

public interface CouponsRepo extends JpaRepository<Coupons, Long> {

	@Query("SELECT emailAddress FROM Coupons where emailAddress=:emailAddress and planName=:planName")
	String findEmailAddress(@Param(value = "emailAddress") String emailAddress,
			@Param(value = "planName") String planName);

	@Query("SELECT discount FROM Coupons where couponCode=:couponCode and planName=:planName and emailAddress=:emailAddress")
	Long findCouponCode(@Param(value = "couponCode") String couponCode, @Param(value = "planName") String planName,
			@Param(value = "emailAddress") String emailAddress);

	Coupons findOneBycouponCode(String coupounCode);

}
