package com.flightReservationSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservationSystem.dto.ReservationRequest;
import com.flightReservationSystem.entity.Flight;
import com.flightReservationSystem.repository.FlightRepository;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository reposit;

	@RequestMapping("/showCompleteReservation")
	public String  showCompleteReservation(@RequestParam("flightId")int flightId,ModelMap modelMap) {
		Flight flight = reposit.findById(flightId);
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	@PostMapping("/completererservation")
	public String completeReservation(ReservationRequest request) {
		return null;
	

	}
}