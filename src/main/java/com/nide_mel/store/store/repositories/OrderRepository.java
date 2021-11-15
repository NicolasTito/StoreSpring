package com.nide_mel.store.store.repositories;

import com.nide_mel.store.store.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
