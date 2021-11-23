package com.flightReservationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservationSystem.entity.User;
import com.flightReservationSystem.repository.UserRepository;
import com.flightReservationSystem.services.SecurityService;

@Controller
public class UserController {
	@Autowired
	private UserRepository repository;

	@Autowired
	SecurityService security;
	
	@RequestMapping("/showRegistration")
	public String showRegistrationPage() {
		return "login/registerUser";
	}

	@PostMapping("registerUser")
	public String register(@ModelAttribute("user")User user) {
		repository.save(user);
		return"login/login";
	}
	@RequestMapping("/showLogin")
	public String showLogninPage() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email")String email,@RequestParam("pass")String pass,ModelMap modelMap) {
		
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
