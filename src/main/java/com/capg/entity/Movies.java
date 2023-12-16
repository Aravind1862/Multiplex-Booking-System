package com.capg.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Movies {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="MovieId")
private int movieId;

@Column(name="MovieName")
private String movieName;
@Column(name="genre")
private String genre;


@OneToMany(mappedBy = "movies", cascade = CascadeType.ALL)
@JsonManagedReference(value="MovieId")
private List<Shows> show;


public Movies() {
	super();
}


public Movies(int movieId, String movieName, String genre, List<Shows> show) {
	super();
	this.movieId = movieId;
	this.movieName = movieName;
	this.genre = genre;
	this.show = show;
}


public int getMovieId() {
	return movieId;
}


public void setMovieId(int movieId) {
	this.movieId = movieId;
}


public String getMovieName() {
	return movieName;
}


public void setMovieName(String movieName) {
	this.movieName = movieName;
}


public String getGenre() {
	return genre;
}


public void setGenre(String genre) {
	this.genre = genre;
}


public List<Shows> getShow() {
	return show;
}


public void setShow(List<Shows> show) {
	this.show = show;
}


@Override
public String toString() {
	return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", show=" + show + "]";
}

}