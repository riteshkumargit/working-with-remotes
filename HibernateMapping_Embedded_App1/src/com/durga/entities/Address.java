package com.durga.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="address")
public class Address {

	@Column(name="PNO")
	private String pno;
	
	@Column(name="STREET")
	private String street;
	private String city;
	
	@Column(name="CITY")
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}