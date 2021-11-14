package com.nide_mel.course.course.repositories;

import com.nide_mel.course.course.domain.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
