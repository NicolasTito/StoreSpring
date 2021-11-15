package com.nide_mel.store.store.repositories;

import com.nide_mel.store.store.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
