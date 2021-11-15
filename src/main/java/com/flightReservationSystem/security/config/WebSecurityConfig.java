package com.flightReservationSystem.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/showRegistration","/","/index.html","registerUser","/login","/showLogin","/login/*").permitAll()
		 .antMatchers("/admin/showAddFlights").hasAnyAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable();
		
	}

}
