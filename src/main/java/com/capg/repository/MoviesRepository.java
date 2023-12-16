package com.capg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Movies;

public interface MoviesRepository extends JpaRepository<Movies,Integer> {

	Optional<Movies> findByMovieName(String movieName);

}
