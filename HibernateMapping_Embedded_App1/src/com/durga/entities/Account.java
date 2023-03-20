package com.durga.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="account")
public class Account {

	@Column(name="ACCNO")
	private String accNo;
	
	@Column(name="ACCNAME")
	private String accName;
	
	@Column(name="ACCTYPE")
	private String accType;
	
	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	
	
	
}