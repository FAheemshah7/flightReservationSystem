package com.flightReservationSystem.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservationSystem.dto.ReservationRequest;
import com.flightReservationSystem.entity.Flight;
import com.flightReservationSystem.entity.Reservation;
import com.flightReservationSystem.repository.FlightRepository;
import com.flightReservationSystem.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository reposit;
	
	@Autowired
	ReservationService reservationService;

	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationController.class);

	
	@RequestMapping("/showCompleteReservation")
	public String  showCompleteReservation(@RequestParam("flightId")int flightId,ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation() with the flight id :"+flightId);
		Flight flight = reposit.findById(flightId);
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight is :"+flight);
		return "completeReservation";
	}
	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation Successfull and The Reservation id is :"+reservation.getId());
		
		return "reservationConfirmation";
	

	}
} 