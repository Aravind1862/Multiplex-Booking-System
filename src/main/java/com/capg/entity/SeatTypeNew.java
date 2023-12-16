package com.capg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="seat_type_new")
public class SeatTypeNew {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seat_type_id")
	private int seatTypeId;
	
	@Column(name="seat_type_desc")
	private String seatTypeDescription;
	
	@Column(name="seat_fare")
	private double seatFare;

	public SeatTypeNew() {
	}

	public SeatTypeNew(int seatTypeId, String seatTypeDescription, double seatFare) {
		this.seatTypeId = seatTypeId;
		this.seatTypeDescription = seatTypeDescription;
		this.seatFare = seatFare;
	}

	public int getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	public String getSeatTypeDescription() {
		return seatTypeDescription;
	}

	public void setSeatTypeDescription(String seatTypeDescription) {
		this.seatTypeDescription = seatTypeDescription;
	}

	public double getSeatFare() {
		return seatFare;
	}

	public void setSeatFare(double seatFare) {
		this.seatFare = seatFare;
	}

	@Override
	public String toString() {
		return "SeatTypeNew [seatTypeId=" + seatTypeId + ", seatTypeDescription=" + seatTypeDescription + ", seatFare="
				+ seatFare + "]";
	}
		
}
