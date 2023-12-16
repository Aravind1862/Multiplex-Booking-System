package com.capg.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.capg.entity.SeatType;


public class BookingDto {
	
	private int bookingId;
	 private LocalDate bookedDate;
	 
	 private LocalDate showDate;
	 private int showId;
	 
	 private int noOfSeats;
	 
	 private int userId;

	private List<SeatType> seatTypeId ;

	public BookingDto(int bookingId, LocalDate bookedDate, LocalDate showDate, int showId, int userId, List<SeatType>seatTypeId,int noOfSeats) {
		super();
		this.bookingId = bookingId;
		this.bookedDate = bookedDate;
		this.showDate = showDate;
		this.showId = showId;
		this.userId = userId;
		this.seatTypeId = seatTypeId;
		this.noOfSeats=noOfSeats;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<SeatType> getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(List<SeatType> seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
	

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	@Override
	public String toString() {
		return "BookingDto [bookingId=" + bookingId + ", bookedDate=" + bookedDate + ", showDate=" + showDate
				+ ", showId=" + showId + ", noOfSeats=" + noOfSeats + ", userId=" + userId + ", seatTypeId="
				+ seatTypeId + "]";
	}

	public BookingDto getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}