package com.nide_mel.store.store.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.nide_mel.store.store.domain.Client;

import org.hibernate.validator.constraints.Length;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Mandatory field")
	@Length(min = 5, max = 120, message = "Min: 5 Max: 120")
	private String name;

	@NotEmpty(message = "Mandatory field")
	@Email(message = "Invalid Email")
	private String email;

	public ClientDTO() {
	}

	public ClientDTO(Client obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClientDTO id(Integer id) {
		setId(id);
		return this;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClientDTO name(String name) {
		setName(name);
		return this;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ClientDTO email(String email) {
		setEmail(email);
		return this;
	}
}
