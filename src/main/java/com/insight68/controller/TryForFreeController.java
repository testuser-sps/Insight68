package com.insight68.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insight68.models.TryForFree;
import com.insight68.service.TryForFreeService;
import com.insight68.utils.ResponseStatusEnum;

@Controller
public class TryForFreeController {

	@Autowired
	TryForFreeService tryForFreeService;

	@PostMapping(value = "/tryforfree", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> contactUs(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		final TryForFree tryForFree = mapper.convertValue(map, TryForFree.class);
		if (tryForFreeService.saveTryForFree(tryForFree)) {
			respMap.put("message", "we will get you soon");
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Failed to save your contact");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;

	}

}
