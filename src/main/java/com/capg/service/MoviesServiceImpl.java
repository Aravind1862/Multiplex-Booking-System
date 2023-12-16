package com.capg.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.entity.Movies;
import com.capg.entity.Shows;
import com.capg.exception.IdNotFoundException;
import com.capg.repository.MoviesRepository;
import com.capg.utility.AppConstant;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	MoviesRepository moviesRepository;

	@Override
	public Movies addMovie(Movies movies) {

		movies.setMovieName(movies.getMovieName().toLowerCase());
		movies.setGenre(movies.getGenre().toLowerCase());
		return moviesRepository.save(movies);
	}

	@Override
	public List<Movies> getAllMovies() {
		return moviesRepository.findAll();
	}

	@Override
	public String deleteMovieById(int id) {

		String msg;
		if (moviesRepository.existsById(id)) {
			moviesRepository.deleteById(id);
			msg = "movie successfully deleted";
		} else {
			throw new IdNotFoundException(AppConstant.MOVIE_ID_NOT_FOUND_INFO);
		}

		return msg;
	}

	public Movies getMovieById(int movieId) {
		Optional<Movies> movieById = moviesRepository.findById(movieId);
		return movieById.get();
	}

	public Movies getMovieByName(String movieName) {
		Optional<Movies> movieByName = moviesRepository.findByMovieName(movieName);
		return movieByName.get();
	}
}
