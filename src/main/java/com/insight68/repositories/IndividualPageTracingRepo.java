package com.insight68.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insight68.loginTracking.IndividualPageTracing;

public interface IndividualPageTracingRepo extends JpaRepository<IndividualPageTracing, Long> {

	IndividualPageTracing findFirstByTokenAndEmailOrderByLastModifiedDateDesc(String token, String email);

	List<IndividualPageTracing> findAllByEmailAndTokenOrderByLastModifiedDateAsc(String Email, String token);

}
