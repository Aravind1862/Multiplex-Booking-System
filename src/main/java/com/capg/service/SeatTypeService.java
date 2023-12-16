package com.capg.service;

import java.util.List;


import com.capg.entity.SeatType;

public interface SeatTypeService {

	SeatType addSeatType(SeatType seatType);
	List<SeatType> getAllSeatType();
	String deleteSeatTypeById(int id);
}
