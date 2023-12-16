package com.capg.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="booking_new")
public class BookingNew {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_new_id")
	private int bookingId;
	
	@Column(name="user_name")
	private String userName;
	
    @Column(name="movie_name")
    private String movieName;
    
    @Column(name="user_id")
    @JsonProperty(access=Access.WRITE_ONLY)
    private int userId;
    
    @Column(name="booked_date")
    private LocalDate bookedDate;
    
    @Column(name="show_date")
    private LocalDate showDate;
    
    @Column(name="seat_description")
    private String seatDescription;
    
    @Column(name="no_of_seats")
    private int noOfSeats;
    
    @Column(name="seat_fare")
    private double seatFare;
    
    @Column(name="booking_amount")
    private double bookingAmount;
    
    @Column(name="booking_order_status")
    private String bookingOrderStatus="Confirm";

	public BookingNew() {
	}

	public BookingNew(int bookingId, String userName, String movieName, int userId, LocalDate bookedDate,
			LocalDate showDate, String seatDescription, int noOfSeats, double seatFare, double bookingAmount,
			String bookingOrderStatus) {
		this.bookingId = bookingId;
		this.userName = userName;
		this.movieName = movieName;
		this.userId = userId;
		this.bookedDate = bookedDate;
		this.showDate = showDate;
		this.seatDescription = seatDescription;
		this.noOfSeats = noOfSeats;
		this.seatFare = seatFare;
		this.bookingAmount = bookingAmount;
		this.bookingOrderStatus = bookingOrderStatus;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getSeatDescription() {
		return seatDescription;
	}

	public void setSeatDescription(String seatDescription) {
		this.seatDescription = seatDescription;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public double getSeatFare() {
		return seatFare;
	}

	public void setSeatFare(double seatFare) {
		this.seatFare = seatFare;
	}

	public double getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(double bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public String getBookingOrderStatus() {
		return bookingOrderStatus;
	}

	public void setBookingOrderStatus(String bookingOrderStatus) {
		this.bookingOrderStatus = bookingOrderStatus;
	}

	@Override
	public String toString() {
		return "BookingNew [bookingId=" + bookingId + ", userName=" + userName + ", movieName=" + movieName
				+ ", userId=" + userId + ", bookedDate=" + bookedDate + ", showDate=" + showDate + ", seatDescription="
				+ seatDescription + ", noOfSeats=" + noOfSeats + ", seatFare=" + seatFare + ", bookingAmount="
				+ bookingAmount + ", bookingOrderStatus=" + bookingOrderStatus + "]";
	}
    
    
    
    
}
