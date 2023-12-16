package com.capg.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.entity.Movies;
import com.capg.entity.Shows;
import com.capg.service.MoviesServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class MoviesController {

	@Autowired
	MoviesServiceImpl moviesService;

	@PostMapping("/addmovies")
	public ResponseEntity<Movies> addMovie(@RequestBody Movies movies) {
		return new ResponseEntity<Movies>(moviesService.addMovie(movies), HttpStatus.OK);
	}

	@GetMapping("/movies")
	public ResponseEntity<List<Movies>> getAllMovies() {
		return new ResponseEntity<List<Movies>>(moviesService.getAllMovies(), HttpStatus.OK);
	}

	@GetMapping("/getMovie/{movieId}")
	public ResponseEntity<Movies> getMovieById(@PathVariable int movieId) {
		return new ResponseEntity<Movies>(moviesService.getMovieById(movieId), HttpStatus.OK);
	}

	@GetMapping("/movie/{movieName}")
	public ResponseEntity<Movies> getMovieByName(@PathVariable String movieName) {
		return new ResponseEntity<Movies>(moviesService.getMovieByName(movieName), HttpStatus.OK);
	}

	@DeleteMapping("/movie/{id}")
	public ResponseEntity<String> deleteMovieById(@PathVariable int id) {
		return new ResponseEntity<String>(moviesService.deleteMovieById(id), HttpStatus.OK);
	}

}
