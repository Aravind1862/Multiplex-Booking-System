package com.capg.service;

import java.util.List;

import com.capg.entity.Movies;
import com.capg.entity.Shows;

public interface MoviesService {

	Movies addMovie(Movies movies);
	List<Movies> getAllMovies();
	String  deleteMovieById(int id);
	Movies getMovieById(int movieId);
	public Movies getMovieByName(String movieName);
}
