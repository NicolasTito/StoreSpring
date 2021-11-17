package com.nide_mel.store.store.dto;

import java.io.Serializable;

import com.nide_mel.store.store.domain.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer	id;
	private String	name;
	private Double	price;

	public ProductDTO() {
	}

	public ProductDTO (Product obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.price = obj.getPrice();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductDTO id(Integer id) {
		setId(id);
		return this;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductDTO name(String name) {
		setName(name);
		return this;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductDTO price(Double price) {
		setPrice(price);
		return this;
	}

}
