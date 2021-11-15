package com.nide_mel.store.store.repositories;

import com.nide_mel.store.store.domain.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
