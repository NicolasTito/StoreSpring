package com.nide_mel.course.course.services;

import java.util.Optional;

import com.nide_mel.course.course.domain.Category;
import com.nide_mel.course.course.repositories.CategoryRepository;
import com.nide_mel.course.course.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Object not found!! Id: " + id + ", Tipo: " + Category.class.getName()));
	}

	public Category insert(Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Category update(Category obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
