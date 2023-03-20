package com.durga.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="TX_ID")
@Table(name="card_payment")
public class CardPayment extends Payment {

	@Id
	@Column(name="CARDNO")
	private int cardNo;
	
	@Column(name="EXPRDATE")
	private String exprDate;
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public String getExprDate() {
		return exprDate;
	}
	public void setExprDate(String exprDate) {
		this.exprDate = exprDate;
	}
}
