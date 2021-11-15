package com.nide_mel.course.course.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemOrderPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;


	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ItemOrderPK order(Order order) {
		setOrder(order);
		return this;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ItemOrderPK product(Product product) {
		setProduct(product);
		return this;
	}


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ItemOrderPK)) {
			return false;
		}
		ItemOrderPK itemOrderPK = (ItemOrderPK) o;
		return Objects.equals(order, itemOrderPK.order) && Objects.equals(product, itemOrderPK.product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

}
