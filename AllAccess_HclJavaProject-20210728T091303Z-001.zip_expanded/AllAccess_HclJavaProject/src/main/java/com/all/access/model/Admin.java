package com.all.access.model;

public class Admin 
{
	String emailAddress;
	String password;
	int loginType;
	
	public Admin() {}

	public Admin(String emailAddress, String password, int loginType) {
		this.emailAddress = emailAddress;
		this.password = password;
		this.loginType = loginType;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	
	
	
	

}
