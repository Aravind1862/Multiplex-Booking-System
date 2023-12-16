package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Booking;
import com.capg.entity.SeatType;
import com.capg.repository.SeatTypeRepository;


@Service
public class SeatTypeServiceImpl implements SeatTypeService{

	@Autowired
	 SeatTypeRepository seatTypeRepository;
	 
	 @Override
	 public SeatType addSeatType(SeatType seatType) {
		
		 return seatTypeRepository.save(seatType);
	 }
	 
	 @Override
	 public List<SeatType> getAllSeatType(){
		 return seatTypeRepository.findAll();
	 }
	 @Override
	 public String deleteSeatTypeById(int id) {
		 String msg="";
			if(seatTypeRepository.existsById(id))
			{
				seatTypeRepository.deleteById(id);
				msg="Hall successfully deleted";
			}
			
//			else
//			{
//				throw new HallIdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
//			}
		
			return msg;
		}
	 public SeatType getSeatTypeById(int seatTypeId) {
			Optional<SeatType> getSeatTypeById=seatTypeRepository.findById(seatTypeId);
			return getSeatTypeById.get();
	 }
}
