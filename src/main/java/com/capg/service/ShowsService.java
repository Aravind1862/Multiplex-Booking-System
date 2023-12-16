package com.capg.service;

import java.util.List;

import com.capg.dto.ShowDto;
import com.capg.entity.Shows;

public interface ShowsService {

	//Shows addShows(Shows shows);
	List<Shows> getListOfShows();
	String deleteShowsById(int id);
	Shows updateShows(int id, Shows shows);
	
	public Shows addShows(Shows show);
	Shows getShowById(int showId);
}
