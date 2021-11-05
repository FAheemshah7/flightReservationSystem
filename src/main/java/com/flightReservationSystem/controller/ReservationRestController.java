package com.flightReservationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightReservationSystem.dto.ReservationUpdateRequest;
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
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = repository.findById(request.getId());
		reservation.setNUMBER_OF_BAGS(request.getNumberOfBags());
		reservation.setCHECKED_IN(request.getCheckedIn());
		return repository.save(reservation);
		 
		
	}
	
}
