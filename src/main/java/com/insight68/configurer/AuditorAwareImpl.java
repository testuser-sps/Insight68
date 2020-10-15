package com.insight68.configurer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import com.insight68.repositories.LoginDetailsRepo;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Autowired
	LoginDetailsRepo loginDetailsRepo;

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName().toString());
	}

}