package com.flightReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightReservationSystem.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
