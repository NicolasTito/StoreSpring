package com.nide_mel.course.course.domain;

import com.nide_mel.course.course.domain.enums.StatePayment;

public class PaymentCreditCard extends Payment{

	private Integer numberInstallments;

	public PaymentCreditCard() {
	}


	public PaymentCreditCard(Integer id, StatePayment state, Order order, Integer numberInstallments) {
		super(id, state, order);
		this.numberInstallments = numberInstallments;
	}

	public Integer getNumberInstallments() {
		return this.numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}

	public PaymentCreditCard numberInstallments(Integer numberInstallments) {
		setNumberInstallments(numberInstallments);
		return this;
	}

}
