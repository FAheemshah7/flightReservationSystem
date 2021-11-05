package com.flightReservationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightReservationSystem.entity.Reservation;
import com.flightReservationSystem.repository.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	ReservationRepository repository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id")int id) {
		return repository.findById(id);
		
	}
	
}
