package com.nide_mel.course.course.repositories;

import com.nide_mel.course.course.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
