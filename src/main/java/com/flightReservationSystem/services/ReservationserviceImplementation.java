package com.flightReservationSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightReservationSystem.dto.ReservationRequest;
import com.flightReservationSystem.entity.Flight;
import com.flightReservationSystem.entity.Passenger;
import com.flightReservationSystem.entity.Reservation;
import com.flightReservationSystem.repository.FlightRepository;
import com.flightReservationSystem.repository.PassengerRepository;
import com.flightReservationSystem.repository.ReservationRepository;

@Service
public class ReservationserviceImplementation implements ReservationService {

	@Autowired
	FlightRepository repository;
	
	@Autowired
	PassengerRepository pRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
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
		return saveReservation;
	}
	

}
