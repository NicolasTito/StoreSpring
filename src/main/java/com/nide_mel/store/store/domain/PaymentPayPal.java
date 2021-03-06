package com.nide_mel.store.store.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nide_mel.store.store.domain.enums.StatePayment;

@Entity
@JsonTypeName("paypal")
public class PaymentPayPal extends Payment{

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date datePayment;

	public PaymentPayPal() {
	}


	public PaymentPayPal(Integer id, StatePayment state, Order order, Date datePayment) {
		super(id, state, order);
		this.datePayment = datePayment;
	}

	public Date getDatePayment() {
		return this.datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public PaymentPayPal datePayment(Date datePayment) {
		setDatePayment(datePayment);
		return this;
	}

}
