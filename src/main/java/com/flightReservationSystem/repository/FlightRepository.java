package com.flightReservationSystem.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightReservationSystem.entity.Flight;

public interface FlightRepository  extends JpaRepository<Flight, Integer>{

	@Query(value="select * FROM t_flight t WHERE t.departure_city =:dCity and t.arrival_city =:arCity and t.date_of_departure =:dateOfDeparture",nativeQuery=true)
	List<Flight> findFlights(@Param("dCity")String from,@Param("arCity") String to,@Param("dateOfDeparture")Date departureDate);

	Flight findById(int flightId);

}
