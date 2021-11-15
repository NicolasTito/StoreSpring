package com.nide_mel.store.store.services;

import java.util.Optional;

import com.nide_mel.store.store.domain.Product;
import com.nide_mel.store.store.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public Product find(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
