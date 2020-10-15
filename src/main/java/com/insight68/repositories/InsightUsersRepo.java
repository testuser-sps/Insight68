package com.insight68.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insight68.models.ContactUs;
import com.insight68.models.InsightUsers;
import java.lang.String;
import java.util.List;

@Repository
public interface InsightUsersRepo extends JpaRepository<InsightUsers, Long> {

	InsightUsers findOneByEmailAddress(String emailaddress);

	InsightUsers findOneByPhoneNumber(String phoneNumber);

	InsightUsers findByEmailAddress(String emailaddress);

	InsightUsers findOneById(Long id);

	InsightUsers findOneByFirstName(String name);

	@Query("SELECT DISTINCT emailAddress FROM InsightUsers")
	List<String> findDistinctEmailAddress();

	@Query("SELECT DISTINCT firstName FROM InsightUsers where emailAddress=:emailAddress")
	String findDistinctEmailAddress(@Param(value = "emailAddress") String emailAddress);
	
	
	List<InsightUsers> findAllByOrderByLastModifiedDateDesc();

}
