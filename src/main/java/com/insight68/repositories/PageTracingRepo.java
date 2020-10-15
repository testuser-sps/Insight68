package com.insight68.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insight68.loginTracking.PageLoginLogoutTracing;

public interface PageTracingRepo extends JpaRepository<PageLoginLogoutTracing, Long> {

	PageLoginLogoutTracing findByEmailAndToken(String email, String token);

	// List<PageLoginLogoutTracing> findAllByEmailOrderByIdDesc(String Email);

	List<PageLoginLogoutTracing> findAllByEmailOrderByLastModifiedDateDesc(String Email);

	// List<PageLoginLogoutTracing> findAllByEmailOrderByUserLoginedTimeDesc(String
	// Email);

}
