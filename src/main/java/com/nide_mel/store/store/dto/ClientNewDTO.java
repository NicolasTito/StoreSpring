package com.nide_mel.store.store.dto;

import java.io.Serializable;

public class ClientNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String	name;
	private String	email;

	private String	cep;
	private String	address;
	private	String	number;

	private String numberPhone1;
	private String numberPhone2;
	private String numberPhone3;

	private Integer cityId;

	public ClientNewDTO() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClientNewDTO name(String name) {
		setName(name);
		return this;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ClientNewDTO email(String email) {
		setEmail(email);
		return this;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public ClientNewDTO cep(String cep) {
		setCep(cep);
		return this;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ClientNewDTO address(String address) {
		setAddress(address);
		return this;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public ClientNewDTO number(String number) {
		setNumber(number);
		return this;
	}

	public String getNumberPhone1() {
		return this.numberPhone1;
	}

	public void setNumberPhone1(String numberPhone1) {
		this.numberPhone1 = numberPhone1;
	}

	public ClientNewDTO numberPhone1(String numberPhone1) {
		setNumberPhone1(numberPhone1);
		return this;
	}

	public String getNumberPhone2() {
		return this.numberPhone2;
	}

	public void setNumberPhone2(String numberPhone2) {
		this.numberPhone2 = numberPhone2;
	}

	public ClientNewDTO numberPhone2(String numberPhone2) {
		setNumberPhone2(numberPhone2);
		return this;
	}

	public String getNumberPhone3() {
		return this.numberPhone3;
	}

	public void setNumberPhone3(String numberPhone3) {
		this.numberPhone3 = numberPhone3;
	}

	public ClientNewDTO numberPhone3(String numberPhone3) {
		setNumberPhone3(numberPhone3);
		return this;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public ClientNewDTO cityId(Integer cityId) {
		setCityId(cityId);
		return this;
	}

}
