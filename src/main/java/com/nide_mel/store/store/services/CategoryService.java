package com.nide_mel.store.store.services;

import java.util.List;
import java.util.Optional;

import com.nide_mel.store.store.domain.Category;
import com.nide_mel.store.store.dto.CategoryDTO;
import com.nide_mel.store.store.repositories.CategoryRepository;
import com.nide_mel.store.store.services.exceptions.DataExceptionIntegrity;
import com.nide_mel.store.store.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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

	public Page<Category> findPage(Integer page, Integer linesPages, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPages, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Category fromDto(CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName());
	}
}
