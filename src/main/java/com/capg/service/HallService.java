package com.capg.service;

import java.util.List;

import com.capg.entity.Hall;

public interface HallService {

	Hall addHall(Hall hall);
	List<Hall> getAllHall();
	String deleteHallById(int id);
	Hall updateHall(int id, Hall hall);
	Hall getHallById(int id);
//	Hall update
	
}
