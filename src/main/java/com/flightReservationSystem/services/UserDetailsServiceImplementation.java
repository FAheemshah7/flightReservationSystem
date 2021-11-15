package com.flightReservationSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.flightReservationSystem.entity.User;
import com.flightReservationSystem.repository.UserRepository;

public class UserDetailsServiceImplementation implements UserDetailsService {

	
	@Autowired 
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if(user==null) {
		throw new UsernameNotFoundException("User not found for Email"+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPass(),user.getRoles());
		
		
		
	}

}
