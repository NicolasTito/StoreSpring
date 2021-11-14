package com.nide_mel.course.course.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nide_mel.course.course.domain.enums.StatePayment;

@Entity
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private StatePayment state;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Payment() {
	}


	public Payment(Integer id, StatePayment state, Order order) {
		this.id = id;
		this.state = state;
		this.order = order;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Payment id(Integer id) {
		setId(id);
		return this;
	}

	public StatePayment getState() {
		return this.state;
	}

	public void setState(StatePayment state) {
		this.state = state;
	}

	public Payment state(StatePayment state) {
		setState(state);
		return this;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Payment order(Order order) {
		setOrder(order);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Payment)) {
			return false;
		}
		Payment payment = (Payment) o;
		return Objects.equals(id, payment.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
