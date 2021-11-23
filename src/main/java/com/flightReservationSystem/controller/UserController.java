package com.flightReservationSystem.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservationSystem.entity.User;
import com.flightReservationSystem.repository.UserRepository;
import com.flightReservationSystem.services.SecurityService;

import org.slf4j.Logger;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	SecurityService security;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);

	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/showRegistration")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}

	@PostMapping("registerUser")
	public String register(@ModelAttribute("user")User user) {
		LOGGER.info("Inside  register()"+user);
		user.setPass(encoder.encode(user.getPass()));
		repository.save(user);
		return"login/login";
	}
	@RequestMapping("/showLogin")
	public String showLogninPage() {
		LOGGER.info("Inside showLogninPage()");
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email")String email,@RequestParam("pass")String pass,ModelMap modelMap) {
		LOGGER.info("Inside login() and the emial is :"+email);
		LOGGER.error("ERROR");
		LOGGER.warn("WARNING");
		LOGGER.info("INFORMATION");
		LOGGER.debug("DEBUG");
		LOGGER.trace("TRACE");
		boolean loginResponse = security.login(email, pass);
		if(loginResponse) {
			return "findFlights";
		}
		else {
			modelMap.addAttribute("msg","You Entered Wrong Username/Password.PLease Try Again");
		}	
		return "login/login";
	}
	
}
