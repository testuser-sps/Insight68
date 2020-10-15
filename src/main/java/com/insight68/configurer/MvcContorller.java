package com.insight68.configurer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insight68.loginTracking.IndividualPageTracing;
import com.insight68.loginTracking.PageLoginLogoutTracing;
import com.insight68.loginTracking.service.PageTracingService;
import com.insight68.models.LoginDetails;
import com.insight68.security.JwtTokenProvider;
import com.insight68.security.dto.LoginCredentialsDTO;
import com.insight68.security.service.LoginDetailsServiceImpl;
import com.insight68.service.AdminService;
import com.insight68.service.InsightUserService;
import com.insight68.utils.ResponseStatusEnum;

@Controller
public class MvcContorller {

	@Autowired
	InsightUserService ius;

	@Autowired
	LoginDetailsServiceImpl loginDetailsServiceImpl;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AdminService adminService;

	@Autowired
	PageTracingService pageTracingService;

	// Input from Sign in form to verify details

	@PostMapping(value = "/login", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> login(@RequestParam Map<String, Object> map, HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> respMap = new HashMap<>();
		final ObjectMapper mapper = new ObjectMapper();
		LoginCredentialsDTO loginCredentials = mapper.convertValue(map, LoginCredentialsDTO.class);
		try {
			Map<String, String> response = loginDetailsServiceImpl.loadLoginDetails(loginCredentials);
			if (((String) response.get("status")).equals("Ok")) {
				HttpSession session = req.getSession(false);
				res.addHeader("SbmsAuthorization", (String) response.get("token"));
				session.setAttribute("jwtToken", (String) response.get("token"));
				Date date = new Date();
				String token = (String) response.get("token");
				session.setAttribute("role", jwtTokenProvider.getRole((response.get("token"))));
				session.setAttribute("email", loginCredentials.getEmail());
				session.setAttribute("token", token);
				session.setAttribute("latestLoginTime", date);
				// Saving recent Login Time and resetting number of login attempts to 0
				LoginDetails loginDetails = new LoginDetails();
				loginDetails.setEmail(loginCredentials.getEmail());
				loginDetails.setRecentLoginTime(date);
				loginDetails.setNoOfLoginAttemptsByUser((long) 0);
				pageTracingService.updateLoginLogoutDetails(loginDetails);
				// Page Tracking for login and logout Starts Here
				PageLoginLogoutTracing pageLoginLogoutTracing = new PageLoginLogoutTracing();
				pageLoginLogoutTracing.setEmail(loginCredentials.getEmail());
				pageLoginLogoutTracing.setUserLoginedTime(date);
				pageLoginLogoutTracing.setToken(token);
				pageTracingService.savePageDetails(pageLoginLogoutTracing);
				respMap.put("message", "Logged In Successfully");
				respMap.put("status", ResponseStatusEnum.SUCCESS);
				respMap.put("token", (String) response.get("token"));
				respMap.put("firstLoginStatus", (String) response.get("firstLoginStatus"));
			}
			// User Blocked
			else if (((String) response.get("status")).equals("UserBlocked")) {
				respMap.put("message", "Your account has been blocked!");
				respMap.put("status", ResponseStatusEnum.ERROR);
			}
			// User Not Found
			else {
				respMap.put("message", "User Not Found ");
				respMap.put("status", ResponseStatusEnum.ERROR);
			}
		}
		// When Users Attempts login with Bad Credentials
		catch (BadCredentialsException e) {
			Long attempts = loginDetailsServiceImpl.updateNumberOfLoginAttempts(loginCredentials.getEmail());
			Long userAttemptsRemaining = adminService.AllowedNumberOfLoginAttempts() - attempts;
			if (userAttemptsRemaining > 0) {
				respMap.put("message", "Invalid Credentials!. You have " + userAttemptsRemaining
						+ " attempt(s) before your account is blocked!");
			} else {
				respMap.put("message", "Invalid Credentials!. The maximum number of login attempts has been reached");
			}
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		// Application exceptions
		catch (AuthenticationException | NullPointerException e) {
			respMap.put("message", "Internal Server Error - Authentication Exception");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

	// First page manipulation

	@RequestMapping({ "/", "/signin.jsp", })
	public String signInPage(HttpServletResponse response, HttpServletRequest request) {
		return "signin";
	}

	@PostMapping(value = "/home", produces = { "application/json" })
	@ResponseBody
	public Map<String, Object> index(HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> respMap = new HashMap<>();
		if (Objects.nonNull(jwtTokenProvider.resolveToken(request))) {
			respMap.put("status", ResponseStatusEnum.SUCCESS);
		} else {
			respMap.put("message", "Invalid Token");
			respMap.put("status", ResponseStatusEnum.ERROR);
		}
		return respMap;
	}

}
