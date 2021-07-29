package com.all.access.model;
import java.sql.Blob;

public class Users 
{
	int userId;
	String username;
	String userPassword;
	int type;
	String userAddress;
	String contactNumber;
	String gender;
	Blob profilePhoto;
	
	public Users() {}
	
	

	public Users(int userId, String username, String userPassword, int type, String userAddress, String contactNumber,
			String gender, Blob profilePhoto) {
		this.userId = userId;
		this.username = username;
		this.userPassword = userPassword;
		this.type = type;
		this.userAddress = userAddress;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.profilePhoto = profilePhoto;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Blob getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(Blob profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	
	
	
	
	
	

}