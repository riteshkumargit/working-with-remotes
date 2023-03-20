package com.durga.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="payment")
public class Payment {

	@Id
	@Column(name="TX_ID")
	private String tx_id;
	
	@Column(name="PAYMENTDATE")
	private String paymentDate;
	
	@Column(name="PAYMENTAMT")
	private long paymentAmt;
	
	public String getTx_id() {
		return tx_id;
	}
	public void setTx_id(String tx_id) {
		this.tx_id = tx_id;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public long getPaymentAmt() {
		return paymentAmt;
	}
	public void setPaymentAmt(long paymentAmt) {
		this.paymentAmt = paymentAmt;
	}
	
	
	
}
