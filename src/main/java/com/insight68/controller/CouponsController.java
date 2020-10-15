package com.insight68.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insight68.models.Coupons;
import com.insight68.models.InvoiceBill;
import com.insight68.service.CouponsService;
import com.insight68.utils.ResponseStatusEnum;

@RestController
public class CouponsController {

	@Autowired
	CouponsService cos;

	// Input data from Service,Support and ContactUs page

	@PostMapping(value = "/getCouponByCouponCode", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> getByCouponCode(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final Coupons coupons = mapper.convertValue(map, Coupons.class);
		Map<String, String> response = cos.getDiscountValue(coupons);
		if (((String) response.get("status")).equals("exists")) {
			respMap.put("discount", Long.valueOf(response.get("discount").toString()));
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else if (((String) response.get("status")).equals("notexists")) {
			respMap.put("message", "Coupon is invalid");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;

	}

	@PostMapping(path = "/SendInvoice")
	@ResponseBody
	public Map<String, Object> savePassword(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		InvoiceBill invoicebill = mapper.convertValue(map, InvoiceBill.class);
		if (cos.saveInvoice(invoicebill)) {
			respMap.put("message", "Invoice Sent Successfully to the Email Address registered with us");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Failed to send Invoice");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}
}
