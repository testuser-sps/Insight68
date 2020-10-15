package com.insight68.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.insight68.models.ContactUs;

 
public interface ContactsRepo extends JpaRepository<ContactUs, Long>{
	
	List<ContactUs> findAllByOrderByLastModifiedDateDesc();

}
