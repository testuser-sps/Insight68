package com.insight68.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insight68.models.NumberOfLoginAttempts;

public interface NumberOfLoginAtrtemptsRepo extends JpaRepository<NumberOfLoginAttempts, Long> {

	NumberOfLoginAttempts findTopByOrderById();

}
