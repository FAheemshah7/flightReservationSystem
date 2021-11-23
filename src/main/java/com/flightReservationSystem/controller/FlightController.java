package com.flightReservationSystem.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservationSystem.entity.Flight;
import com.flightReservationSystem.repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	FlightRepository repository;

	private static final Logger LOGGER=LoggerFactory.getLogger(FlightController.class);
	
	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("from")String from,@RequestParam("to")String to,
			@RequestParam("departureDate")@DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate,ModelMap modelMap ) {
		LOGGER.info("Inside findFlights() From:"+from+"TO: "+to+"Departure Date :"+departureDate); 

		List<Flight> flights = repository.findFlights(from,to,departureDate);
		modelMap.addAttribute("flights",flights);
		LOGGER.info("Flights Found are :"+flights);
		return "displayFlights";
	}


}
