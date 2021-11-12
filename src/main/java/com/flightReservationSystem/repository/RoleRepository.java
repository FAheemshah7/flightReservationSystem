package com.flightReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightReservationSystem.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{

}
