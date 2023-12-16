package com.capg.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Booking {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int bookingId;
	
	 @Column(name="BookedDate")
	 private LocalDate bookedDate;
	 
	 @Column(name="ShowDate")
	 private LocalDate showDate;
	 
	 private int noOfSeats;
	
	 
	// private float price;
	// @ManyToOne
	// @JoinColumn(name="ShowId")
	// private Shows shows;
	// 
	// @ManyToOne
	// @JoinColumn(name="UserId")
	// private Users users;
	 
	
	 @ManyToOne
	 @JoinColumn(name="ShowId",referencedColumnName="ShowId")
	 @JsonBackReference(value="showId")
	 private Shows shows;
	 
	 @ManyToOne
	 @JoinColumn(name="UserId",referencedColumnName="UserId")
	 @JsonBackReference(value="userId")
	 private Users users;
	
	@OneToMany(mappedBy="bookings")
	private List<SeatType> seatType;
		
		
		
	//	@ManyToOne
	//	@JoinColumn(name="NoofSeats")
	//	private int noofSeats;
		
		
	
	
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Booking(int bookingId, LocalDate bookedDate, LocalDate showDate,  Shows shows, Users users,
			List<SeatType> seatType) {
		this.bookingId = bookingId;
		this.bookedDate = bookedDate;
		this.showDate = showDate;
		//this.noOfSeats = noOfSeats;
		this.shows = shows;
		this.users = users;
		this.seatType = seatType;
	}

	public int getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	
	//public int getShowId() {
	//	return showId;
	//}
	//
	//public void setShowId(int showId) {
	//	this.showId = showId;
	//}
	
	//public int getUserId() {
	//	return userId;
	//}
	//
	//public void setUserId(int userId) {
	//	this.userId = userId;
	//}
	
	public int getNoOfSeats() {
		return noOfSeats;
	}
	
	

//	public float getPrice() {
//		return price;
//	}
//
//	public void setPrice(float price) {
//		this.price = price;
//	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public LocalDate getBookedDate() {
		return bookedDate;
	}
	
	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}
	
	public LocalDate getShowDate() {
		return showDate;
	}
	
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	
	public Shows getShows() {
		return shows;
	}
	
	public void setShows(Shows shows) {
		this.shows = shows;
	}
	
	public Users getUsers() {
		return users;
	}
	
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public List<SeatType> getSeatType() {
		return seatType;
	}
	
	public void setSeatType(List<SeatType> seatType) {
		this.seatType = seatType;
	}
	 
	

	

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookedDate=" + bookedDate + ", showDate=" + showDate
				+ ", shows=" + shows.getShowId() + ", users=" + users.getUserId() + 	"]";
	}
	
}
