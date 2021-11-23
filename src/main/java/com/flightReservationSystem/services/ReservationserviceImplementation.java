package com.flightReservationSystem.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.flightReservationSystem.dto.ReservationRequest;
import com.flightReservationSystem.entity.Flight;
import com.flightReservationSystem.entity.Passenger;
import com.flightReservationSystem.entity.Reservation;
import com.flightReservationSystem.repository.FlightRepository;
import com.flightReservationSystem.repository.PassengerRepository;
import com.flightReservationSystem.repository.ReservationRepository;
import com.flightReservationSystem.util.EmailUtill;
import com.flightReservationSystem.util.PDFGenerator;

@Service
@Transactional
public class ReservationserviceImplementation implements ReservationService {

	@Autowired
	FlightRepository repository;
	
	@Autowired
	PassengerRepository pRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	 
	@Autowired
	PDFGenerator pdf;
	
	@Autowired
	EmailUtill email;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationserviceImplementation.class);

	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		 
		
		LOGGER.info("INside bookFlight()");
		int flightId = request.getFlightId();
		LOGGER.info("Fetching Flight for FLight Id:"+flightId);
		Flight flight = repository.findById(flightId);
		Passenger passenger=new Passenger();
		passenger.setF_name(request.getpFisrtName());
		passenger.setL_name(request.getpLastName());
		passenger.setEmail(request.getpEmail());
		passenger.setPhone(request.getpPhone());
		LOGGER.info("Saving the Passenger "+passenger);
		
		Passenger savepassenger = pRepository.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savepassenger);
		reservation.setCHECKED_IN(false);

		LOGGER.info("Saving the Reservation To Database :"+reservation);

		Reservation saveReservation = reservationRepository.save(reservation);		

		String filepath = "C://Users//Shan Bhutta/Documents/reservation/reservation"+saveReservation.getId()+".pdf";
		LOGGER.info("Genereating the itinerary:");
		pdf.genrateItinerary(saveReservation,filepath);
		LOGGER.info("Emailing the itinerary:");
		email.sendItinerary(passenger.getEmail(), filepath);
		return saveReservation;

	
	
	}
	

}
