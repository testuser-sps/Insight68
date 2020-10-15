package com.insight68.loginTracking.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insight68.loginTracking.IndividualPageTracing;
import com.insight68.loginTracking.PageLoginLogoutTracing;
import com.insight68.loginTracking.service.PageTracingService;
import com.insight68.utils.ResponseStatusEnum;

@Controller
public class PageTracingController {

	@Autowired
	PageTracingService pageTracingService;

	// Saving pricing details
	@PostMapping(value = "/savePageTracing", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> savePageTracing(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final PageLoginLogoutTracing pageLoginLogoutTracing = mapper.convertValue(map, PageLoginLogoutTracing.class);
		if (pageTracingService.savePageDetails(pageLoginLogoutTracing)) {
			respMap.put("message", "Details changed successfully");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Failed to save details");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	@PostMapping(value = "/updateLoginLogout", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> updateLoginLogout(@RequestParam Map<String, Object> map) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final PageLoginLogoutTracing pageLoginLogoutTracing = mapper.convertValue(map, PageLoginLogoutTracing.class);
		if (pageTracingService.updateLoginLogoutDetailsinPageTracing(pageLoginLogoutTracing)) {
			respMap.put("message", "Update Logout Time");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Failed to Update Logout Time");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	// Saving pageDetails details
	@PostMapping(value = "/individualPageTracing", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> individualPageTracing(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final IndividualPageTracing individualPageTracing = mapper.convertValue(map, IndividualPageTracing.class);
		if (pageTracingService.saveIndividualPageDetails(individualPageTracing)) {
			respMap.put("message", "Details changed successfully");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Failed to save details");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

}
