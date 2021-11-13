package com.nide_mel.course.course.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class District implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	id;
	private String	name;

	@JsonIgnore
	@OneToMany(mappedBy = "district")
	private List<City> cities = new ArrayList<>();

	public District() {
	}


	public District(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public District id(Integer id) {
		setId(id);
		return this;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District name(String name) {
		setName(name);
		return this;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public District cities(List<City> cities) {
		setCities(cities);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof District)) {
			return false;
		}
		District district = (District) o;
		return Objects.equals(id, district.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
