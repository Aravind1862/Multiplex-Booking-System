package com.capg.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Hall {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name="hall_id")
	  private int hallId;
	  
	  @Column(name="HallDesc")
	  private String hallDesc;
	  
	  @Column(name="TotalCapacity")
	  private int totalCapacity;
	  
//	  @Column(name="SeatTypeId")
//	  private int seatTypeId;
//	  
	
	  
	  @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
	  @JsonManagedReference(value="hall_id")
	  private List<Shows> shows;
	  
	  @OneToMany(mappedBy="halls",cascade=CascadeType.ALL)
	  @JsonManagedReference(value="hall_id")
	  private List<SeatType> seatType;
	  
//	  @ManyToOne
//	  @JoinColumn(name="BookingId",referencedColumnName="bookingId")
//	  @JsonBackReference(value="bookingId")
//	  private Booking bookings;
//	  
	  
	public Hall() {
		super();
	}
	
	public Hall(int hallId, String hallDesc, int totalCapacity, List<Shows> shows, List<SeatType> seatType) {
	this.hallId = hallId;
	this.hallDesc = hallDesc;
	this.totalCapacity = totalCapacity;
	this.shows = shows;
	this.seatType = seatType;
}

	public int getHallId() {
		return hallId;
	}
	
	
	
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	
	
	
	public String getHallDesc() {
		return hallDesc;
	}
	
	
	
	public void setHallDesc(String hallDesc) {
		this.hallDesc = hallDesc;
	}
	
	
//	
//	public int getSeatTypeId() {
//		return seatTypeId;
//	}
//	
//	
//	
//	public void setSeatTypeId(int seatTypeId) {
//		this.seatTypeId = seatTypeId;
//	}
	
	
	
	
	
	
	public List<SeatType> getSeatType() {
		return seatType;
	}
	
	
	
	public void setSeatType(List<SeatType> seatType) {
		this.seatType = seatType;
	}
	
	
	
	public int getTotalCapacity() {
		return totalCapacity;
	}



	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}



	public List<Shows> getShows() {
		return shows;
	}



	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}



	@Override
	public String toString() {
		return "Hall [hallId=" + hallId + ", hallDesc=" + hallDesc + ", totalCapacity=" + totalCapacity + ", shows="
				+ shows + ", seatType=" + seatType + "]";
	}



	
	  
}
