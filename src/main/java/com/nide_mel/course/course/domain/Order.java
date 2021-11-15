package com.nide_mel.course.course.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date date;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
	private Payment payment;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "send_address_id")
	private Address sendAddress;

	@OneToMany(mappedBy = "id.order")
	private Set<ItemOrder> items = new HashSet<>();

	public Order() {
	}

	public Order(Integer id, Date date, Client client, Address sendAddress) {
		this.id = id;
		this.date = date;
		this.client = client;
		this.sendAddress = sendAddress;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order id(Integer id) {
		setId(id);
		return this;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Order date(Date date) {
		setDate(date);
		return this;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Order payment(Payment payment) {
		setPayment(payment);
		return this;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Order client(Client client) {
		setClient(client);
		return this;
	}

	public Address getSendAddress() {
		return this.sendAddress;
	}

	public void setSendAddress(Address sendAddress) {
		this.sendAddress = sendAddress;
	}

	public Order sendAddress(Address sendAddress) {
		setSendAddress(sendAddress);
		return this;
	}

	public Set<ItemOrder> getItemOrders() {
		return this.items;
	}

	public void setItemOrders(Set<ItemOrder> items) {
		this.items = items;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Order)) {
			return false;
		}
		Order order = (Order) o;
		return Objects.equals(id, order.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
