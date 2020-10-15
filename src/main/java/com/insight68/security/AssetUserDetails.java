package com.insight68.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.insight68.Exceptions.ApplicationException;
import com.insight68.models.LoginDetails;
import com.insight68.repositories.LoginDetailsRepo;

/**
 * AssetUserDetails class.
 * 
 * @author VSanthosh
 *
 */
@Service
public class AssetUserDetails implements UserDetailsService {

	@Autowired
	private LoginDetailsRepo userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LoginDetails user;
		try {
			user = userRepository.findByEmail(email);
			// getUserDetailsByLoginId(loginId);
		} catch (Exception e) {
			throw new ApplicationException("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (user == null) {
			throw new UsernameNotFoundException("User login id '" + email + "' not found");
		}

		return org.springframework.security.core.userdetails.User//
				.withUsername(email)//
				.password(user.getPassword())//
				.authorities(user.getRole())//
				.accountExpired(false)//
				.accountLocked(false)//
				.credentialsExpired(false)//
				.disabled(false)//
				.build();
	}

}
