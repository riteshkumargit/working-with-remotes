package com.durga.entities;

public class CardPayment extends Payment {

	private int cardNo;
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
