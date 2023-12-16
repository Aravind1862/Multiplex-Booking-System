package com.capg.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Users {

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId")
    private int userId;
	
	@Column(name="UserName")
	private String userName;
	
	@Column(name="UserType")
	private char userType = 'u';
	
	@Column(name="MobileNo")
	private int mobileNo;
	
	@Column(name="EmailId")
	private String emailId;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="users",cascade=CascadeType.ALL)
	private List<Booking> booking;
	
	
	public Users(int userId, String userName, char userType, int mobileNo, String emailId, String password) {
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

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	
	
	
	
}
