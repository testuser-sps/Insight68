package com.insight68.security.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insight68.Exceptions.ApplicationException;
import com.insight68.Exceptions.NotFoundException;
import com.insight68.loginSecurityDTO.LoginResposeDTO;
import com.insight68.models.LoginDetails;
import com.insight68.models.NumberOfLoginAttempts;
import com.insight68.repositories.LoginDetailsRepo;
import com.insight68.security.JwtTokenProvider;
import com.insight68.security.dto.LoginCredentialsDTO;
import com.insight68.service.AdminService;
import com.insight68.utils.UtilClass;

/**
 * Login details service implementation class.
 * 
 * @author VSanthosh
 *
 */
@Service
@Transactional
public class LoginDetailsServiceImpl {

	@Autowired
	private LoginDetailsRepo userRepository;

	@Autowired
	private AdminService adminService;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	public Map<String, String> loadLoginDetails(LoginCredentialsDTO loginDetailParameter)
			throws AuthenticationException, BadCredentialsException {
		Map<String, String> map = new HashMap<String, String>();
		String loginId = loginDetailParameter.getEmail();
		if (Objects.nonNull(userRepository.findByEmail(loginId))) {// Checking User Exist by Email
			LoginDetails user = userRepository.findByEmail(loginId);
			if (user.getIsUserBlocked().equals("ALLOWED")) {// Checking User Blocked Condition
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginId, loginDetailParameter.getPassword()));
				String token = jwtTokenProvider.createToken(loginId, user.getRole());
				map.put("status", "Ok");
				map.put("token", token);
				if (user.firstLoginStatus) {
					map.put("firstLoginStatus", "true");
				} else {
					map.put("firstLoginStatus", "false");
				}
				return map;
			} else {
				map.put("status", "UserBlocked");
				return map;
			}
		} else {
			map.put("status", "error");
			return map;
		}
	}

	public String verifyJwtToken() throws ApplicationException {
		try {
			Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (userDetails instanceof org.springframework.security.core.userdetails.User) {
				return ((org.springframework.security.core.userdetails.User) userDetails).getUsername();
			}

			return null;
		} catch (AuthenticationException e) {
			throw new NotFoundException("Invalid token", HttpStatus.NOT_FOUND);
		}
	}

	public LoginResposeDTO generateTokenByUserName(String userName) throws ApplicationException, NotFoundException {
		LoginDetails user = userRepository.findByEmail(userName);
		// getUserDetailsByLoginId(userName);
		if (user != null) {
			String token = jwtTokenProvider.createToken(userName, user.getRole());
			return new LoginResposeDTO(token, user);
		} else {
			throw new NotFoundException("Given user name not exist in the system", HttpStatus.EXPECTATION_FAILED);
		}
	}

	// When User enters Bad Credentials the Number of Login Attempts
	public Long updateNumberOfLoginAttempts(String email) {
		Long numberOfAllowedLoginAttempts = adminService.AllowedNumberOfLoginAttempts();
		LoginDetails existing = userRepository.findByEmail(email);
		if (existing.isUserBlocked.equals("ALLOWED")) {
			existing.setNoOfLoginAttemptsByUser(
					Objects.nonNull(existing.getNoOfLoginAttemptsByUser()) ? existing.getNoOfLoginAttemptsByUser() + 1
							: 1);
			userRepository.save(existing);
		}
		if (Objects.nonNull(existing.getNoOfLoginAttemptsByUser())) {
			if (existing.getNoOfLoginAttemptsByUser() == numberOfAllowedLoginAttempts) {
				existing.setIsUserBlocked("BLOCKED");
				userRepository.save(existing);
			}
		}
		return existing.getNoOfLoginAttemptsByUser();
	}
}
