package com.nide_mel.course.course.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	id;
	private String	name;
	private Double	price;

	@JsonIgnore
	@ManyToMany
	@JoinTable (
		name = "product_category",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn (name = "category_id")
	)

	private List<Category> categories = new ArrayList<>();


	public Product() {
	}

	public Product(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product id(Integer id) {
		setId(id);
		return this;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product name(String name) {
		setName(name);
		return this;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product price(Double price) {
		setPrice(price);
		return this;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Product categories(List<Category> categories) {
		setCategories(categories);
		return this;
	}


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Product)) {
			return false;
		}
		Product product = (Product) o;
		return Objects.equals(id, product.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
