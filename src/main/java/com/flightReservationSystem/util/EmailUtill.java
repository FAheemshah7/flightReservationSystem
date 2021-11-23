package com.flightReservationSystem.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.flightReservationSystem.controller.ReservationController;

@Component
public class EmailUtill {

	private static final Logger LOGGER=LoggerFactory.getLogger(EmailUtill.class);
	
	@Autowired
	private JavaMailSender sender;
	
	
	
	public void sendItinerary(String toAddress,String filePath) {
	
		LOGGER.info("Inside sendItinerary()");
		
		MimeMessage message = sender.createMimeMessage();
	try {
		MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
		messageHelper.setTo(toAddress);
		messageHelper.setSubject("Itinerary For Your Flight");
		messageHelper.setText("Please find your Itinerary Attached");
		messageHelper.addAttachment("Itinerary", new File(filePath));;
		sender.send(message);
	} catch (MessagingException e) {
		LOGGER.error("Exception imnside the sendItenerary"+e.getStackTrace());
	}	
	}
	
}
