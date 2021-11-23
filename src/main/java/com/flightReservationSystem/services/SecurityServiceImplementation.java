package com.flightReservationSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImplementation implements SecurityService {

	
	@Autowired
	UserDetailsService userDetail;

	@Autowired
	AuthenticationManager authorizationManager;
	
	@Override
	public boolean login(String username, String pass) {
		UserDetails userDetails = userDetail.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(userDetails,pass,userDetails.getAuthorities());
		authorizationManager.authenticate(token);
		boolean results = token.isAuthenticated();
		if(results) {
			SecurityContextHolder.getContext().setAuthentication(token);		
			}
		return results;
	}

}
