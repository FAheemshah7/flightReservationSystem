package com.flightReservationSystem.services;

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
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		int flightId = request.getFlightId();
		Flight flight = repository.findById(flightId);
		System.out.println("FLight id is :"+flightId);
		
		Passenger passenger=new Passenger();
		passenger.setF_name(request.getpFisrtName());
		passenger.setL_name(request.getpLastName());
		passenger.setEmail(request.getpEmail());
		passenger.setPhone(request.getpPhone());
		
		Passenger savepassenger = pRepository.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savepassenger);
		reservation.setCHECKED_IN(false);

		Reservation saveReservation = reservationRepository.save(reservation);		

		String filepath = "C://Users//Shan Bhutta/Documents/reservation/reservation"+saveReservation.getId()+".pdf";
		pdf.genrateItinerary(saveReservation,filepath);
		email.sendItinerary(passenger.getEmail(), filepath);
		
		return saveReservation;

	
	
	}
	

}
