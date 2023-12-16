package com.capg;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.entity.Movies;
import com.capg.repository.MoviesRepository;
import com.capg.service.MoviesServiceImpl;

@SpringBootTest
public class MovieServiceTests {
	@Mock
	MoviesRepository moviesRepository;
	@InjectMocks
	MoviesServiceImpl moviesServiceImpl;
 
	@Test
	public void addMovieTest()
	{
		Movies movies = new Movies(1,"pathan","action");
		when(moviesRepository.save(movies)).thenReturn(movies);
		assertEquals(movies, moviesServiceImpl.addMovie(movies));
		
	}
	
	@Test
	public void getAllUserTest()
	{
		ArrayList<Movies> movies = new ArrayList<>();
		
		movies.add(new Movies(1,"Home","Family"));
		movies.add(new Movies(2,"20-20","Action"));
		movies.add(new Movies(3,"Ishq","Love"));
		when(moviesRepository.findAll()).thenReturn(movies);
		assertEquals(3, moviesServiceImpl.getAllMovies().size());

	}
}