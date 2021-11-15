package com.nide_mel.store.store.services;

import java.util.List;
import java.util.Optional;

import com.nide_mel.store.store.domain.Category;
import com.nide_mel.store.store.repositories.CategoryRepository;
import com.nide_mel.store.store.services.exceptions.DataExceptionIntegrity;
import com.nide_mel.store.store.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public List<Category> findAll() {
		return repo.findAll();
	}

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

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataExceptionIntegrity("Cannot delete!!!");
		}
	}
}
