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
@Table(name="hall_new")
public class HallNew {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hall_new_id")
	private int hallId;
	
	@Column(name="hall_desc")
	private String hallDescription;
	
	@Column(name="total_capacity")
	private int totalCapacity;
	
	@Column(name="remaining_seats")
	private int remaining_seats;
	
    @OneToMany(mappedBy = "hallNew", cascade = CascadeType.ALL)
    @JsonManagedReference(value="hall_new_id")
    private List<Shows> shows;

    
	public HallNew() {
	}

	public HallNew(int hallId, String hallDescription, int totalCapacity, int remaining_seats, List<Shows> shows) {
		this.hallId = hallId;
		this.hallDescription = hallDescription;
		this.totalCapacity = totalCapacity;
		this.remaining_seats = remaining_seats;
		this.shows = shows;
	}

	public int getHallId() {
		return hallId;
	}

	public void setHallId(int hallId) {
		this.hallId = hallId;
	}

	public String getHallDescription() {
		return hallDescription;
	}

	public void setHallDescription(String hallDescription) {
		this.hallDescription = hallDescription;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public int getRemaining_seats() {
		return remaining_seats;
	}

	public void setRemaining_seats(int remaining_seats) {
		this.remaining_seats = remaining_seats;
	}

	public List<Shows> getShows() {
		return shows;
	}

	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "HallNew [hallId=" + hallId + ", hallDescription=" + hallDescription + ", totalCapacity=" + totalCapacity
				+ ", remaining_seats=" + remaining_seats + ", shows=" + shows + "]";
	}
    
    
    
	
}
