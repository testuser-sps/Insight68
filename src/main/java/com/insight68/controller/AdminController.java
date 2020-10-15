package com.insight68.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insight68.dto.ContactUsDTO;
import com.insight68.dto.InsightUsersDTO;
import com.insight68.dto.LoginDetailsDTO;
import com.insight68.dto.PricingDTO;
import com.insight68.loginTracking.IndividualPageTracing;
import com.insight68.loginTracking.IndividualPageTracingDTO;
import com.insight68.loginTracking.PageLoginLogoutTracingDTO;
import com.insight68.models.Coupons;
import com.insight68.models.LoginDetails;
import com.insight68.models.NumberOfLoginAttempts;
import com.insight68.models.Pricing;
import com.insight68.service.AdminService;
import com.insight68.utils.ResponseStatusEnum;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	// Retruns all Try for free InsightUsers
	@GetMapping(path = "/getAllInsightUsers")
	@ResponseBody
	public List<InsightUsersDTO> getAllInsightUsers() {
		return adminService.getAllTryForFreeUsers();
	}

	// Saving pricing details
	@PostMapping(value = "/savePricingDetails", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> saveUser(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final Pricing pricing = mapper.convertValue(map, Pricing.class);
		if (adminService.savePricingDetails(pricing)) {
			respMap.put("message", "Details changed successfully");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
			// Audit section ends here
		} else {
			respMap.put("message", "Failed to save details");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	// Retruns all Try for free InsightUsers
	@GetMapping(path = "/getAllEnquiryUsers")
	@ResponseBody
	public List<ContactUsDTO> getAllEnquiryUsers() {
		return adminService.getAllEnquiryUsers();
	}

	// Get Pricing plans by Plan name
	@GetMapping(path = "/getByPricingPlan")
	@ResponseBody
	public PricingDTO getByPricingPlan(@RequestParam Map<String, Object> map) {
		return adminService.getPricingByPlan(map.get("pricingPlans").toString());
	}

	// Retruns all Unique email id from InsightUsers
	@GetMapping(path = "/displayEmailid")
	@ResponseBody
	public List<String> getAllUniqueEmailId() {
		return adminService.getUniqueEmailID();
	}

	@PostMapping(value = "/saveCouponDetails", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> saveCoupon(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final Coupons coupons = mapper.convertValue(map, Coupons.class);
		if (adminService.checkCouponsLimit(coupons)) {
			if (adminService.saveCouponsDetails(coupons)) {
				respMap.put("message", "Details saved successfully");
				respMap.put("status", ResponseStatusEnum.SUCCESS);
				// Audit section ends here
			} else {
				respMap.put("message", "Failed to save details");
				respMap.put("status", ResponseStatusEnum.ERROR);
			}
			return respMap;
		} else {
			respMap.put("message", "Coupon exists for User registered with emailAddress " + coupons.getEmailAddress()
					+ " with plan " + coupons.getPlanName());
			respMap.put("status", ResponseStatusEnum.ERROR);
			return respMap;
		}
	}

	@PostMapping(value = "/saveCouponDetailsandSendEmail", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> saveCouponandSendEmail(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final Coupons coupons = mapper.convertValue(map, Coupons.class);
		if (adminService.checkCouponsLimit(coupons)) {
			try {
				if (adminService.saveCouponsDetailsAndSendEmail(coupons)) {
					respMap.put("message", "Details saved successfully");
					respMap.put("status", ResponseStatusEnum.SUCCESS);
					// Audit section ends here
				} else {
					respMap.put("message", "Failed to save details");
					respMap.put("status", ResponseStatusEnum.ERROR);
				}
			} catch (AddressException e) {
				respMap.put("message", e.getMessage());
				respMap.put("status", ResponseStatusEnum.WARNING);
			} catch (MessagingException e) {
				respMap.put("message", e.getMessage());
				respMap.put("status", ResponseStatusEnum.WARNING);
			}
			return respMap;
		} else {
			respMap.put("message", "Coupon exists for User registered with emailAddress " + coupons.getEmailAddress()
					+ " with plan " + coupons.getPlanName());
			respMap.put("status", ResponseStatusEnum.ERROR);
			return respMap;
		}
	}

	// Create User for login Code
	@PostMapping(value = "/createUserByAdmin", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> createUserByAdmin(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final LoginDetails loginDetails = mapper.convertValue(map, LoginDetails.class);
		loginDetails.setFirstLoginStatus(true);
		if (adminService.creteUserByadmin(loginDetails)) {
			respMap.put("message", "User created successfully");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Email Address already exists with us.");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	// Get User Details
	// Retruns all Unique email id from LoginDetails
	@GetMapping(path = "/displayLoginDetailsOfUser")
	@ResponseBody
	public List<LoginDetailsDTO> getAllEmailIdOfLoginDetails(@RequestParam String zone) {
		return adminService.getAllLoginDetails(zone);
	}

	// Get PageTracing details By email
	@GetMapping(value = "/getPageTracingDetailsByEmail", produces = { "application/json" })
	@ResponseBody
	public List<PageLoginLogoutTracingDTO> getAllPageTracingDetails(@RequestParam String email,@RequestParam String zone) {
		
		return adminService.getAllPageTracingDetails(email,zone);
	}

	// Change Password
	// Create User for login Code
	@PostMapping(value = "/checkUserPassword", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> checkUserPassword(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		String oldPassword = (String) map.get("coldpassword");
		String cnewpassword = (String) map.get("cnewpassword");
		String email = (String) map.get("email");
		final LoginDetails loginDetails = new LoginDetails();
		loginDetails.setEmail(email);
		loginDetails.setPassword(cnewpassword);
		if (adminService.checkUserPassword(oldPassword, email)) {
			if (adminService.saveChangedPassword(loginDetails)) {
				respMap.put("message", "Password changed successfully");
				respMap.put("status", ResponseStatusEnum.SUCCESS);
			} else {
				respMap.put("message", "Failed to save the New Password");
				respMap.put("status", ResponseStatusEnum.ERROR);
			}
		} else {
			respMap.put("message", "Please enter the valid Password");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	// Number of Login Attempts Saving Code
	@PostMapping(value = "/numberOfLoginAttempts", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> numberOfLoginAttempts(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final NumberOfLoginAttempts numberOfLoginAttempts = mapper.convertValue(map, NumberOfLoginAttempts.class);
		if (adminService.numberOfLoginAttempts(numberOfLoginAttempts)) {
			respMap.put("message", "Number of failed Attempts updated successfully.");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Failed to update Number of failed Attempts.");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	// Get PageTracing details By email
	@GetMapping(value = "/getLoginAttemptsNumber", produces = { "application/json" })
	@ResponseBody
	public Long getLoginAttemptsNumber() {
		return adminService.getLoginAttemptsNumber();
	}

	// Get Pages details By email and Token
	@GetMapping(value = "/getPagesDetailsByEmailAndToken", produces = { "application/json" })
	@ResponseBody
	public List<IndividualPageTracingDTO> getAllIndividualPagesRecord(@RequestParam String email,
			@RequestParam String token,@RequestParam String zone) {
		return adminService.getAllPagesDetails(email, token,zone);
	}

}
