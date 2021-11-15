package com.nide_mel.store.store.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	id;
	private String	cep;
	private String	address;
	private	String	number;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client	client;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City	city;

	public Address() {
	}

	public Address(Integer id, String cep, String address, String number, Client client, City city) {
		this.id = id;
		this.cep = cep;
		this.address = address;
		this.number = number;
		this.client = client;
		this.city = city;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address id(Integer id) {
		setId(id);
		return this;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Address cep(String cep) {
		setCep(cep);
		return this;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Address address(String address) {
		setAddress(address);
		return this;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Address number(String number) {
		setNumber(number);
		return this;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address client(Client client) {
		setClient(client);
		return this;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Address city(City city) {
		setCity(city);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Address)) {
			return false;
		}
		Address address = (Address) o;
		return Objects.equals(id, address.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
