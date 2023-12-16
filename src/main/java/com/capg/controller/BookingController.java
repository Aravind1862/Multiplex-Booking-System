package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.BookingNewDto;
import com.capg.entity.Booking;
import com.capg.entity.BookingNew;
import com.capg.service.BookingServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

	@Autowired
	BookingServiceImpl bookingService;
	  
	  @GetMapping("/bookinglist")
	  public ResponseEntity<List<Booking>> getAllBooking()
	  {
		  return new ResponseEntity<List<Booking>>(bookingService.getAllBooking(),HttpStatus.OK);
	  }
	  
	  @PostMapping("/addbooking")
	  public ResponseEntity<Booking> addBooking(@RequestBody Booking booking){
		  return new ResponseEntity<Booking>(bookingService.bookingSeats(booking),HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/booking/{id}")
		public ResponseEntity<String> deleteBookingById(@PathVariable int id)
		{
			return new ResponseEntity<String>(bookingService.deleteBookingById(id), HttpStatus.OK);
		}
	  
	  @PutMapping("/booking/{id}")
		public ResponseEntity<Booking> updateBookingById(@PathVariable int id,@RequestBody Booking booking)
		{
			return new ResponseEntity<Booking>(bookingService.updateBooking(id, booking), HttpStatus.OK);
		}
	  
	  @GetMapping("/getBooking/{bookingId}")
	    public ResponseEntity<Booking> getBookingById (@PathVariable int bookingId)
	    {
	    	return new ResponseEntity<Booking> (bookingService.getBookingById(bookingId),HttpStatus.OK);
	    }
	
	  @GetMapping("/cancelBooking/{bookingId}")
	  public ResponseEntity<String> cancelBookingById(@PathVariable("bookingId") int bookingId){
		  return new ResponseEntity<String>(bookingService.cancelBooking(bookingId),HttpStatus.OK);
	  }
	  
	  @PostMapping("/booking/new")
	  public ResponseEntity<BookingNew> addNewBooking(@RequestBody BookingNewDto bookingNewDto){
		  return new ResponseEntity<BookingNew>(bookingService.createNewBooking(bookingNewDto),HttpStatus.OK);
	  }
}
