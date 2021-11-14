package com.nide_mel.course.course.repositories;

import com.nide_mel.course.course.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
