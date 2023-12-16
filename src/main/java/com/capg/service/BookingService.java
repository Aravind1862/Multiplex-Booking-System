package com.capg.service;

import java.util.List;

import com.capg.dto.BookingNewDto;
import com.capg.entity.Booking;
import com.capg.entity.BookingNew;


public interface BookingService {

	Booking bookingSeats(Booking booking);
	List<Booking> getAllBooking();
	
	String deleteBookingById(int id);
	Booking updateBooking(int id, Booking booking);
	//String addBooking2(BookingDto bookingDto);
	Booking getBookingById(int bookingId);
	String cancelBooking(int bookingId);
	
	BookingNew createNewBooking(BookingNewDto bookingNewDto); 
}
