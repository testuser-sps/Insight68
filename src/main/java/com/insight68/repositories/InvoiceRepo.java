package com.insight68.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insight68.models.InvoiceBill;

public interface InvoiceRepo extends JpaRepository<InvoiceBill, Long> {

}
