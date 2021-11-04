package com.flightReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightReservationSystem.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
