package com.flightReservationSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservationSystem.entity.Flight;
import com.flightReservationSystem.repository.FlightRepository;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository reposit;

	@RequestMapping("showCompleteReservation")
	public String  showCompleteReservation(@RequestParam("id")int id,ModelMap modelMap) {
		Optional<Flight> flight = reposit.findById(id)
		modelMap.addAttribute("", flight);
		return "completeReservation";
	}
	
}
