package com.flightReservationSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightReservationSystem.dto.ReservationUpdateRequest;
import com.flightReservationSystem.entity.Reservation;
import com.flightReservationSystem.repository.ReservationRepository;
import com.flightReservationSystem.util.PDFGenerator;

@RestController
public class ReservationRestController {
	
	@Autowired
	ReservationRepository repository;
	private static final Logger LOGGER=LoggerFactory.getLogger(PDFGenerator.class);

	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id")int id) {
		LOGGER.info("Inside the findReservation() for id :"+id);
		return repository.findById(id);
		
	}
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside the updateReservation() for : "+request);		
		Reservation reservation = repository.findById(request.getId());
		reservation.setNUMBER_OF_BAGS(request.getNumberOfBags());
		reservation.setCHECKED_IN(request.getCheckedIn());
		LOGGER.info("Saving Reservation");		
		return repository.save(reservation);
		 
		
	}
	
}
