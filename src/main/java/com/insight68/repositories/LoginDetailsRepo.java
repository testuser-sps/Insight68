package com.insight68.repositories;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.insight68.models.LoginDetails;

public interface LoginDetailsRepo extends JpaRepository<LoginDetails, Id> {

	LoginDetails findByEmail(String email);

	LoginDetails findOneByEmail(String email);

	LoginDetails findById(Long id);

	@Query("SELECT DISTINCT email FROM LoginDetails")
	List<String> findDistinctEmail();

	@Query("SELECT DISTINCT UserName FROM LoginDetails where email=:email")
	String findDistinctUserName(@Param(value = "email") String email);

	List<LoginDetails> findAllByOrderByLastModifiedDateDesc();

	@Query("SELECT DISTINCT noOfLoginAttemptsByUser FROM LoginDetails where email=:email")
	Long findDistinctNoOfLoginAttemptsByUser(@Param(value = "email") String email);

}
