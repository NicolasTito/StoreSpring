package com.nide_mel.store.store.repositories;

import com.nide_mel.store.store.domain.ItemOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Integer>{

}
