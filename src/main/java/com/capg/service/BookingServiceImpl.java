package com.capg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.BookingNewDto;
import com.capg.entity.Booking;
import com.capg.entity.BookingNew;
import com.capg.entity.SeatType;
import com.capg.entity.SeatTypeNew;
import com.capg.entity.Shows;
import com.capg.entity.Users;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.SeatNotAvailable;
import com.capg.exception.ShowDateNotFound;
import com.capg.repository.BookingNewRepository;
import com.capg.repository.BookingRepository;
import com.capg.repository.HallRepository;
import com.capg.repository.SeatTypeNewRepository;
import com.capg.repository.SeatTypeRepository;
import com.capg.repository.ShowsRepository;
import com.capg.repository.UsersRepository;
import com.capg.utility.AppConstant;
@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository; 
	@Autowired
	private ShowsRepository showsRepository;
	
	@Autowired
	private UsersRepository usersRepository;
//	private Object shows;
	
	
	@Autowired
	private HallRepository hallRepository;
	
	@Autowired
	private SeatTypeRepository seatTypeRepository;
	
	@Autowired
	SeatTypeNewRepository seatTypeNewRepository;
	
	@Autowired
	BookingNewRepository bookingNewRepository;
	
	public List<Booking> getAllBooking() 
	{
		
		return bookingRepository.findAll();
	}
	public Booking bookingSeats(Booking booking) 
	{
 
		usersRepository.findById(booking.getUsers().getUserId()).orElseThrow(
				() -> new IdNotFoundException("USER NOT FOUND  WITH ID: " + booking.getUsers().getUserId()));
 
		Shows show = showsRepository.findById(booking.getShows().getShowId()).orElseThrow(
				() -> new IdNotFoundException("SHOW NOT FOUND WITH ID: " + booking.getShows().getShowId()));
		List<SeatType> seatTypeOptional = booking.getSeatType();
		LocalDate fromDate1 = show.getFromDate();
		LocalDate toDate1 = show.getToDate();
		SeatType seatType = null;
		if (booking.getShowDate().isBefore(booking.getBookedDate())) {
			throw new ShowDateNotFound(AppConstant.BEFORE_BOOKING_DATE_INFO);
		}
 
		else if (!booking.getShowDate().minusDays(1).isBefore(toDate1)
&& booking.getShowDate().plusDays(1).isAfter(fromDate1)) {
			throw new ShowDateNotFound(AppConstant.SHOW_NOT_IN_RANGE_INFO);
		}
 
		else {
			for (SeatType seatTemp : seatTypeOptional) {
				    seatTypeRepository.findById(seatTemp.getSeatTypeId())
						.orElseThrow(() -> new IdNotFoundException("SEAT TYPE  NOT FOUND WITH ID"));
			}
 
			for (SeatType seatTemp : seatTypeOptional) {
				seatType = seatTypeRepository.findById(seatTemp.getSeatTypeId()).get();
				int availableSeat = seatType.getRemainingSeat();
				if (availableSeat >= booking.getNoOfSeats()) {
					seatType.setRemainingSeat(availableSeat - booking.getNoOfSeats());
				} else {
					throw new SeatNotAvailable(AppConstant.SEAT_NOT_AVAILABLE_INFO);
				}
			}
			bookingRepository.save(booking);
			seatType.setBookings(booking);
			seatTypeRepository.save(seatType);
		}
		return booking;
	}
	
	@Override
	 public String deleteBookingById(int id) {
		 String msg="";
			if(bookingRepository.existsById(id))
			{
				bookingRepository.deleteById(id);
				msg="Booking successfully deleted";
			}
			
			else
			{
				throw new IdNotFoundException(AppConstant.BOOKING_ID_NOT_FOUND_INFO);
			}
			
			return msg;
		}
	 
	 @Override
		public Booking updateBooking(int id, Booking booking) {
			
		 
			
			if(bookingRepository.existsById(id))
			
			{
				booking.setBookingId(id);
			}
			 
			else
			{
				throw new IdNotFoundException(AppConstant.BOOKING_ID_NOT_FOUND_INFO);
			}
			
			return bookingRepository.save(booking);
		}

	
	public Booking getBookingById(int bookingId) {
		Optional<Booking> getBookingById=bookingRepository.findById(bookingId);
		if(getBookingById.isEmpty())
		{
			throw new IdNotFoundException(AppConstant.BOOKING_ID_NOT_FOUND_INFO);
		}
		else
		{
		return getBookingById.get();
		}
	}
	
//	public String cancelBooking(int bookingId) {
//		LocalDate currentDate = LocalDate.now();
//		Booking booking = bookingRepository.findById(bookingId).get();
//		if(currentDate.until(booking.getShowDate()).getDays() > 2) {
//			int seats = booking.getNoOfSeats();
//			booking.setNoOfSeats(0);
//			int remainingSeats=booking.getSeatTypeId().g
//			Hall hall = hallRepository.findById(booking.getShows().getHall().getHallId()).get();
//			hall.setSeatCount(remainingSeats+seats);
//			hallRepository.save(hall);
//			bookingRepository.save(booking);
//			return "Booking Cancellation Successfull";
//		}
//		else {
//			//throw cancellation exception
//			System.out.println("Exception code");
//		}
//		return null;
	//}
	
	public String cancelBooking(int bookingId) {
		return null;
	}
	
	public BookingNew createNewBooking(BookingNewDto bookingNewDto) {
		Users user = usersRepository.findById(bookingNewDto.getUserId()).orElseThrow(
				() -> new IdNotFoundException("USER NOT FOUND  WITH ID: " + bookingNewDto.getUserId()));
		
		Shows show = showsRepository.findById(bookingNewDto.getShowId()).orElseThrow(
				() -> new IdNotFoundException("SHOW NOT FOUND WITH ID: " + bookingNewDto.getShowId()));
		SeatTypeNew seatTypeNew = seatTypeNewRepository.findById(bookingNewDto.getSeatTypeId()).get();
		if(seatTypeNew == null) {
			throw new IdNotFoundException("SEAT TYPE  NOT FOUND WITH ID");
		}
		LocalDate fromDate1 = show.getFromDate();
		LocalDate toDate1 = show.getToDate();
		
		if (bookingNewDto.getShowDate().isBefore(bookingNewDto.getBookingDate())) {
			throw new ShowDateNotFound(AppConstant.BEFORE_BOOKING_DATE_INFO);
		}
 
		else if (!bookingNewDto.getShowDate().minusDays(1).isBefore(toDate1)
&& bookingNewDto.getShowDate().plusDays(1).isAfter(fromDate1)) {
			throw new ShowDateNotFound(AppConstant.SHOW_NOT_IN_RANGE_INFO);
		}
		else {
			BookingNew bookingNew = new BookingNew();
			bookingNew.setUserId(bookingNewDto.getUserId());
			bookingNew.setUserName(user.getUserName());
			bookingNew.setMovieName(show.getMovies().getMovieName());
			bookingNew.setBookedDate(LocalDate.now());
			bookingNew.setShowDate(bookingNewDto.getShowDate());
			bookingNew.setSeatDescription(seatTypeNew.getSeatTypeDescription());
			bookingNew.setSeatFare(seatTypeNew.getSeatFare());
			bookingNew.setBookingAmount(bookingNewDto.getNoOfSeats() * seatTypeNew.getSeatFare());
			return bookingNewRepository.save(bookingNew);
			
		}
//  		bookingRepository.save(booking);
	}

}