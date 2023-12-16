package com.capg.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Shows {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShowId")
	private int showId;

	@Column(name = "SlotNo")
	private int slotNo;

	@Column(name = "FromDate")
	private LocalDate fromDate;

	@Column(name = "ToDate")
	private LocalDate toDate;

	@ManyToOne
	@JoinColumn(name = "MovieId", referencedColumnName = "MovieId")
	@JsonBackReference(value = "MovieId")
	private Movies movies;

//	@ManyToOne
//	@JoinColumn(name = "hall_id", referencedColumnName = "hall_id")
//	@JsonBackReference(value = "hall_id")
//	private Hall hall;

	@ManyToOne
	@JoinColumn(name="hall_new_id",referencedColumnName = "hall_new_id")
	@JsonBackReference(value="hall_new_id")
	private HallNew hallNew;
	
	@OneToMany(mappedBy = "shows", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "showId")
	private List<Booking> book;

	public Shows() {
		super();
	}

	
	public Shows(int showId, int slotNo, LocalDate fromDate, LocalDate toDate, Movies movies, HallNew hallNew,
			List<Booking> book) {
		this.showId = showId;
		this.slotNo = slotNo;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.movies = movies;
		this.hallNew = hallNew;
		this.book = book;
	}


//	public Shows(int showId, int slotNo, LocalDate fromDate, LocalDate toDate, Movies movies, Hall hall,
//			List<Booking> book) {
//		super();
//		this.showId = showId;
//		this.slotNo = slotNo;
//		this.fromDate = fromDate;
//		this.toDate = toDate;
//		this.movies = movies;
//		this.hall = hall;
//		this.book = book;
//	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

//	public Hall getHall() {
//		return hall;
//	}
//
//	public void setHall(Hall hall) {
//		this.hall = hall;
//	}

	 
	public List<Booking> getBook() {
		return book;
	}

	public void setBook(List<Booking> book) {
		this.book = book;
	}
	
	public HallNew getHallNew() {
		return hallNew;
	}


	public void setHallNew(HallNew hallNew) {
		this.hallNew = hallNew;
	}


	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", slotNo=" + slotNo + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", movies=" + movies + ", hallNew=" + hallNew + ", book=" + book + "]";
	}


//	@Override
//	public String toString() {
//		return "Shows [showId=" + showId + ", slotNo=" + slotNo + ", fromDate=" + fromDate + ", toDate=" + toDate
//				+ ", movies=" + movies + ", hall=" + hall + ", book=" + book + "]";
//	}
	
	

}