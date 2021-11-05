package com.flightReservationSystem.services;

import com.flightReservationSystem.dto.ReservationRequest;
import com.flightReservationSystem.entity.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);
	
}
