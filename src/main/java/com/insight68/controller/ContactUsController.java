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
import com.insight68.models.ContactUs;
import com.insight68.service.ContactsService;
import com.insight68.utils.ResponseStatusEnum;

@RestController
public class ContactUsController {

	@Autowired
	ContactsService cos;

	
	//Input data from Service,Support and ContactUs page 
	
	@PostMapping(value = "/contactus", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> contactUs(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final ContactUs contactus = mapper.convertValue(map, ContactUs.class);
		try {
			if (cos.saveContactUsForm(contactus)) {
				respMap.put("message", "We will get back to you soon");
				respMap.put("status", ResponseStatusEnum.SUCCESS);
			} else {
				respMap.put("message", "Failed to save your contact");
				respMap.put("status", ResponseStatusEnum.ERROR);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String exception = e.getMessage();
			respMap.put("message", exception);
			respMap.put("status", ResponseStatusEnum.WARNING);
		}
		return respMap;

	}
}
