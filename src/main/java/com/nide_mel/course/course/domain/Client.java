package com.nide_mel.course.course.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	id;
	private String	name;
	private String	email;

	@OneToMany(mappedBy = "client")
	private List<Address> adrresses = new ArrayList<>();

	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "number_phone")
	private Set<String> phone = new HashSet<>();

	public Client() {
	}

	public Client(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client id(Integer id) {
		setId(id);
		return this;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client name(String name) {
		setName(name);
		return this;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Client email(String email) {
		setEmail(email);
		return this;
	}

	public List<Address> getAdrresses() {
		return this.adrresses;
	}

	public void setAdrresses(List<Address> adrresses) {
		this.adrresses = adrresses;
	}

	public Client adrresses(List<Address> adrresses) {
		setAdrresses(adrresses);
		return this;
	}

	public Set<String> getPhone() {
		return this.phone;
	}

	public void setPhone(Set<String> phone) {
		this.phone = phone;
	}

	public Client phone(Set<String> phone) {
		setPhone(phone);
		return this;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Order> orders(List<Order> orders) {
		this.orders = orders;
		return this.orders;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Client)) {
			return false;
		}
		Client client = (Client) o;
		return Objects.equals(id, client.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
