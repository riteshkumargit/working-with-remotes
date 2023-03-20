package com.durga.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="TX_ID")
@Table(name="cheque_payment")
public class ChequePayment extends Payment {

	@Id
	@Column(name="CHEQUENO")
	private int chequeNo;
	
	@Column(name="ACCNO")
	private String accNo;
	
	public int getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
}