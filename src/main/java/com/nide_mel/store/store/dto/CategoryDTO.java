package com.nide_mel.store.store.dto;

import java.io.Serializable;

import com.nide_mel.store.store.domain.Category;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;


	public CategoryDTO() {
	}

	public CategoryDTO (Category obj) {
		this.id = obj.getId();
		this.name = obj.getName();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CategoryDTO id(Integer id) {
		setId(id);
		return this;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryDTO name(String name) {
		setName(name);
		return this;
	}
}
