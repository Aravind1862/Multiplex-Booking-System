package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.ShowDto;
import com.capg.entity.Booking;
import com.capg.entity.Hall;
import com.capg.entity.Movies;
import com.capg.entity.Shows;
import com.capg.exception.IdNotFoundException;
import com.capg.repository.HallRepository;
import com.capg.repository.MoviesRepository;
import com.capg.repository.ShowsRepository;
import com.capg.utility.AppConstant;

@Service
public class ShowsServiceImpl implements ShowsService{

	@Autowired
	private ShowsRepository showsRepository; 
	
	@Autowired
	private MoviesRepository moviesRepository;
	
	@Autowired
	private HallRepository hallRepository;
	
	
	public List<Shows> getListOfShows() 
	{
		return showsRepository.findAll();
	}
	
	public Shows addShows(Shows show) {
		showsRepository.save(show);
		return show;
	}
	
	@Override
	 public String deleteShowsById(int id) {
		 String msg="";
			if(showsRepository.existsById(id))
			{
				showsRepository.deleteById(id);
				msg="Shows successfully deleted";
			}
			else
			{
				throw new IdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
			}
			
			return msg;
		}
	 
	 @Override
		public Shows updateShows(int id, Shows shows) {
			
			
			if(showsRepository.existsById(id))
			{
			 shows.setShowId(id);
			}
			else
			{
				throw new IdNotFoundException(AppConstant.SHOW_ID_NOT_FOUND_INFO);
			}
			
			return shows;
		}
//	@Override
//	public Shows addShows(Shows show) {
//		
//		Shows shows = new Shows();
//		
//		Movies movies = moviesRepository.findById(show.getMovieId()).get();
//        Hall hall = hallRepository.findById(show.getHallId()).get();		
//		
//        shows.setFromDate(showDto.getFromDate());
//        shows.setSlotNo(showDto.getSlotNo());
//        shows.setToDate(showDto.getToDate());
//        shows.setMovies(movies);
//        shows.setHall(hall);
//		
//        
//        
//		return showsRepository.save(shows);
//	}


	
	public Shows getShowById(int showId) {
		Optional<Shows> showById=showsRepository.findById(showId);
		return showById.get();
	}
}
