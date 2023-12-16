package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Hall;
import com.capg.entity.SeatType;
import com.capg.service.HallServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class HallController {
	@Autowired
	HallServiceImpl hallservice;

	@GetMapping("/hall")
	public ResponseEntity<List<Hall>> getAllHalls() {
		return new ResponseEntity<List<Hall>>(hallservice.getAllHall(), HttpStatus.OK);
	}

	@PostMapping("/addhall")
	public ResponseEntity<Hall> addHall(@RequestBody Hall hall) {
		return new ResponseEntity<Hall>(hallservice.addHall(hall), HttpStatus.OK);
	}

	@DeleteMapping("/hall/{id}")
	public ResponseEntity<String> deleteHallById(@PathVariable int id) {
		return new ResponseEntity<String>(hallservice.deleteHallById(id), HttpStatus.OK);
	}

	@PutMapping("/hall/{id}")
	public ResponseEntity<Hall> updateHallById(@PathVariable int id, @RequestBody Hall hall) {
		return new ResponseEntity<Hall>(hallservice.updateHall(id, hall), HttpStatus.OK);
	}
	@GetMapping("/gethall/{hallId}")
    public ResponseEntity<Hall> gethallById (@PathVariable int hallId)
    {
    	return new ResponseEntity<Hall> (hallservice.getHallById(hallId),HttpStatus.OK);
    }
  

}
