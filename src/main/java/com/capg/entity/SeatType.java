package com.capg.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class SeatType {
  public SeatType() {
		super();
		// TODO Auto-generated constructor stub
	}

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="SeatTypeId")
  private int seatTypeId;
  
  @Column(name="SeatTypeDesc")
  private String seatTypeDesc;
  
  @Column(name="SeatFare")
  private float seatFare;
  
  
  @ManyToOne
  @JoinColumn(name="BookingId",referencedColumnName="bookingId")
  @JsonBackReference(value="bookingId")
  private Booking bookings;
  
  @ManyToOne
  @JoinColumn(name="hall_id",referencedColumnName="hall_id")
  @JsonBackReference(value="hall_id")
  private Hall halls;
  
  private int remainingSeat;



public SeatType(int seatTypeId, String seatTypeDesc, float seatFare) {
	super();
	this.seatTypeId = seatTypeId;
	this.seatTypeDesc = seatTypeDesc;
	this.seatFare = seatFare;
}

public int getSeatTypeId() {
	return seatTypeId;
}

public Booking getBookings() {
	return bookings;
}

public void setBookings(Booking bookings) {
	this.bookings = bookings;
}

public Hall getHalls() {
	return halls;
}

public void setHalls(Hall halls) {
	this.halls = halls;
}

public void setSeatTypeId(int seatTypeId) {
	this.seatTypeId = seatTypeId;
}

public String getSeatTypeDesc() {
	return seatTypeDesc;
}

public void setSeatTypeDesc(String seatTypeDesc) {
	this.seatTypeDesc = seatTypeDesc;
}

public float getSeatFare() {
	return seatFare;
}

public void setSeatFare(float seatFare) {
	this.seatFare = seatFare;
}

public int getRemainingSeat() {
	return remainingSeat;
}

public void setRemainingSeat(int remainingSeat) {
	this.remainingSeat = remainingSeat;
}

@Override
public String toString() {
	return "SeatType [seatTypeId=" + seatTypeId + ", seatTypeDesc=" + seatTypeDesc + ", seatFare=" + seatFare
			+ ", bookings=" + bookings + ", halls=" + halls + ", remainingSeat=" + remainingSeat + "]";
}
  



  
}
