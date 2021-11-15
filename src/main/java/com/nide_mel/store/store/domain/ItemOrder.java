package com.nide_mel.store.store.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemOrder implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemOrderPK id = new ItemOrderPK();

	private Double	discount;
	private Integer	quantity;
	private Double	price;


	public ItemOrder() {
	}

	public ItemOrder(Order order, Product product, Double discount, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public ItemOrderPK getId() {
		return this.id;
	}

	public void setId(ItemOrderPK id) {
		this.id = id;
	}

	public ItemOrder id(ItemOrderPK id) {
		setId(id);
		return this;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public ItemOrder discount(Double discount) {
		setDiscount(discount);
		return this;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ItemOrder quantity(Integer quantity) {
		setQuantity(quantity);
		return this;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ItemOrder price(Double price) {
		setPrice(price);
		return this;
	}

}
