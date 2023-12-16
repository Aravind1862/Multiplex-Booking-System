package com.capg.dto;

import java.time.LocalDate;

public class BookingNewDto {
	private int bookingId;
	private int userId;
	private int showId;
	private int seatTypeId;
	private LocalDate bookingDate;
	private LocalDate showDate;
	private int noOfSeats;
	
	public BookingNewDto() {
	}

	public BookingNewDto(int bookingId, int userId, int showId, int seatTypeId, LocalDate bookingDate,
			LocalDate showDate, int noOfSeats) {
		this.bookingId = bookingId;
		this.userId = userId;
		this.showId = showId;
		this.seatTypeId = seatTypeId;
		this.bookingDate = bookingDate;
		this.showDate = showDate;
		this.noOfSeats = noOfSeats;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	@Override
	public String toString() {
		return "BookingNewDto [bookingId=" + bookingId + ", userId=" + userId + ", showId=" + showId + ", seatTypeId="
				+ seatTypeId + ", bookingDate=" + bookingDate + ", showDate=" + showDate + ", noOfSeats=" + noOfSeats
				+ "]";
	}
		
}
