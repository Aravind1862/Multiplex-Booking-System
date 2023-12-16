package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Hall;
import com.capg.entity.SeatType;
import com.capg.exception.IdNotFoundException;
import com.capg.repository.HallRepository;
import com.capg.repository.SeatTypeRepository;
import com.capg.utility.AppConstant;


@Service
public class HallServiceImpl implements HallService{
 @Autowired
 HallRepository hallRepository;
 
 @Autowired 
 SeatTypeRepository seatTypeRepository;
 
 @Override
 public Hall addHall(Hall hall) {
	
	 return hallRepository.save(hall);
 }
 
 @Override
 public List<Hall> getAllHall(){
	 return hallRepository.findAll();
 }
 
 @Override
 public String deleteHallById(int id) {
	 String msg="";
		if(hallRepository.existsById(id))
		{
			hallRepository.deleteById(id);
			msg="Hall successfully deleted";
		}
		else
		{
			throw new IdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
		}
		
		return msg;
	}
 
 @Override
	public Hall updateHall(int id, Hall hall) {
		
	
		
		if(hallRepository.existsById(id))
		{
		   hall.setHallId(id);
		 }
		else
		{
			throw new IdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
		}
		
		return hallRepository.save(hall);
	}
 public Hall getHallById(int hallId) {
		Optional<Hall> getHallById=hallRepository.findById(hallId);
		if(getHallById.isEmpty())
		{
		        throw new IdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
		}
		else
		{
			return getHallById.get();
		}
}


 
 
 }

