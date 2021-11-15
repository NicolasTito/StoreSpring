package com.nide_mel.store.store.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	id;
	private String	name;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private District	district;

	public City() {
	}

	public City(Integer id, String name, District district) {
		this.id = id;
		this.name = name;
		this.district = district;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public City id(Integer id) {
		setId(id);
		return this;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City name(String name) {
		setName(name);
		return this;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public City district(District district) {
		setDistrict(district);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof City)) {
			return false;
		}
		City city = (City) o;
		return Objects.equals(id, city.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
