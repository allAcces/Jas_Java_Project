package com.all.access.model;

import java.util.Date;

public class Enquiry {

	int enquiryID;
	String enquiryMsg;
	Date enquiryMsgDate;
	String enquiryReply;
	Date enquiryReplyDate;
	int shopID;
	int signupID;


	public int getEnquiryID() {
		return enquiryID;
	}
	public void setEnquiryID(int enquiryID) {
		this.enquiryID = enquiryID;
	}
	public String getEnquiryMsg() {
		return enquiryMsg;
	}
	public void setEnquiryMsg(String enquiryMsg) {
		this.enquiryMsg = enquiryMsg;
	}
	public Date getEnquiryMsgDate() {
		return enquiryMsgDate;
	}
	public void setEnquiryMsgDate(Date enquiryMsgDate) {
		this.enquiryMsgDate = enquiryMsgDate;
	}
	public String getEnquiryReply() {
		return enquiryReply;
	}
	public void setEnquiryReply(String enquiryReply) {
		this.enquiryReply = enquiryReply;
	}
	public Date getEnquiryReplyDate() {
		return enquiryReplyDate;
	}
	public void setEnquiryReplyDate(Date enquiryReplyDate) {
		this.enquiryReplyDate = enquiryReplyDate;
	}
	public int getShopID() {
		return shopID;
	}
	public void setShopID(int shopID) {
		this.shopID = shopID;
	}
	public int getSignupID() {
		return signupID;
	}
	public void setSignupID(int signupID) {
		this.signupID = signupID;
	}


	public Enquiry(int enquiryID, String enquiryMsg, Date enquiryMsgDate, String enquiryReply, Date enquiryReplyDate,
			int shopID, int signupID) {
		super();
		this.enquiryID = enquiryID;
		this.enquiryMsg = enquiryMsg;
		this.enquiryMsgDate = enquiryMsgDate;
		this.enquiryReply = enquiryReply;
		this.enquiryReplyDate = enquiryReplyDate;
		this.shopID = shopID;
		this.signupID = signupID;
	}

}
