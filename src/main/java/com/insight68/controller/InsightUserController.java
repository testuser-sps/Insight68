package com.insight68.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insight68.models.InsightUsers;
import com.insight68.models.LoginDetails;
import com.insight68.service.InsightUserService;
import com.insight68.utils.ResponseStatusEnum;

@Controller
public class InsightUserController {

	@Autowired
	InsightUserService ius;

	// Sing up first page data saving for User registration

	@PostMapping(value = "/signup", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> saveUser(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final InsightUsers insightUsers = mapper.convertValue(map, InsightUsers.class);
		Map<String, String> response = ius.savefirstLastEmailFromForm(insightUsers);
		if (((String) response.get("status")).equals("Ok")) {
			respMap.put("id", response.get("id").toString());
			respMap.put("message", "Details saved successfully");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
			// Audit section ends here
		} else if (((String) response.get("status")).equals("exists")) {
			respMap.put("message", "You have already registered for Try for Free");
			respMap.put("status", ResponseStatusEnum.ERROR);
		} else {
			respMap.put("message", "Failed to save details");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	// Password will be Update here

	@PostMapping(path = "/updatePasswordDeatails")
	@ResponseBody
	public Map<String, Object> savePassword(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final InsightUsers insightUsers = mapper.convertValue(map, InsightUsers.class);
		if (ius.savePassword(insightUsers)) {
			respMap.put("message", "Details saved");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Failed to save details");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	// Sign up details will be updated here

	@PostMapping(path = "/updateSignupDeatails")
	@ResponseBody
	public Map<String, Object> saveDetails(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final InsightUsers insightUsers = mapper.convertValue(map, InsightUsers.class);
		if (ius.saveDetails(insightUsers)) {
			respMap.put("message", "Details saved");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Failed to save details");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	// ForgotPassword Codes
	@PostMapping(path = "/recoverPasswordDeatails")
	@ResponseBody
	public Map<String, Object> updatePassword(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final LoginDetails loginDetails = mapper.convertValue(map, LoginDetails.class);
		// final InsightUsers insightUsers = mapper.convertValue(map,
		// InsightUsers.class);
		try {
			if (ius.sendPasswordChangeLinkEmail(loginDetails)) {
				respMap.put("message", "Password reset link sent successfully");
				respMap.put("status", ResponseStatusEnum.SUCCESS);
			} else {
				respMap.put("message", "Email Address is not registered with Insight68.");
				respMap.put("status", ResponseStatusEnum.ERROR);
			}
		} catch (Exception e) {
			respMap.put("message", e.getMessage());
			respMap.put("status", ResponseStatusEnum.WARNING);
		}
		return respMap;
	}

	// ForgotPassword Codes
	@RequestMapping(path = "/passwordreset")
	@ResponseBody
	public Map<String, Object> passwordreset(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final LoginDetails loginDetails = mapper.convertValue(map, LoginDetails.class);
		if (ius.passwordreset(loginDetails)) {
			respMap.put("message", "Password changed successfully");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Failed to change Password");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	@PostMapping(path = "/updateSignupDetailsAndSendMail")
	@ResponseBody
	public Map<String, Object> saveDetailsAndSendMail(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final InsightUsers insightUsers = mapper.convertValue(map, InsightUsers.class);
		try {
			if (ius.saveDetailsAndSendEmail(insightUsers)) {
				respMap.put("message", "Details saved");
				respMap.put("status", ResponseStatusEnum.SUCCESS);
			} else {
				respMap.put("message", "Failed to save details");
				respMap.put("status", ResponseStatusEnum.ERROR);
			}
		} catch (Exception e) {
			respMap.put("message", e.getMessage());
			respMap.put("status", ResponseStatusEnum.WARNING);
		}
		return respMap;
	}

}
