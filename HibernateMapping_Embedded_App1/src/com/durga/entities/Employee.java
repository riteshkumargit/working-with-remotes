package com.durga.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="emp4")
public class Employee {

	@Id
	@Column(name="ENO")
	private int eno;

	@Column(name="ENAME")
	private String ename;
	
	@Column(name="ESAL")
	private float esal;
	
	@Embedded
	private Account eacc;
	
	@Embedded
	private Address eaddr;

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public float getEsal() {
		return esal;
	}

	public void setEsal(float esal) {
		this.esal = esal;
	}

	public Account getEacc() {
		return eacc;
	}

	public void setEacc(Account eacc) {
		this.eacc = eacc;
	}

	public Address getEaddr() {
		return eaddr;
	}

	public void setEaddr(Address eaddr) {
		this.eaddr = eaddr;
	}
	
	
	
	
}
