package com.capg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UsersDto {
	private int userId;
	private String userName;
	@JsonProperty(access=Access.WRITE_ONLY)
	private char userType;
	private int mobileNo;
	private String emailId;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	
	
	public UsersDto() {
	}

	public UsersDto(int userId, String userName, char userType, int mobileNo, String emailId, String password) {
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
	
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
		this.userType = userType;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "UsersDto [userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", mobileNo="
				+ mobileNo + ", emailId=" + emailId + "]";
	}
	
}
