package com.all.access.model;

import java.util.Date;

public class Payment {

	int paymentID;
	int paymentAmount;
	Date paymentDate;
	Date paymentDueDate;
	int shopID;


	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Date getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	public int getShopID() {
		return shopID;
	}
	public void setShopID(int shopID) {
		this.shopID = shopID;
	}


	public Payment(int paymentID, int paymentAmount, Date paymentDate, Date paymentDueDate, int shopID) {
		super();
		this.paymentID = paymentID;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
		this.paymentDueDate = paymentDueDate;
		this.shopID = shopID;
	}



}
