package com.nide_mel.store.store.services;

import java.util.List;
import java.util.Optional;

import com.nide_mel.store.store.domain.Category;
import com.nide_mel.store.store.domain.Product;
import com.nide_mel.store.store.repositories.CategoryRepository;
import com.nide_mel.store.store.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	@Autowired
	private CategoryRepository categoryRepository;

	public Product find(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Page<Product> search(String name, List<Integer> ids, Integer page, Integer linesPages, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPages, Direction.valueOf(direction), orderBy);
		List<Category> categories = categoryRepository.findAllById(ids);
		return repo.search(name, categories, pageRequest);
	}

}
