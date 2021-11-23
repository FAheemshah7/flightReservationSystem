package com.flightReservationSystem.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.flightReservationSystem.controller.ReservationController;
import com.flightReservationSystem.entity.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFGenerator {

	private static final Logger LOGGER=LoggerFactory.getLogger(PDFGenerator.class);
		
	public void genrateItinerary(Reservation reservation,String filePath){
		LOGGER.info("Inside genrateItinerary()");

		Document doc=new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(filePath));
		doc.open();
		doc.add(generateTable(reservation));
		doc.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("Exception Inside the genrateItinerary()"+e);
		
		} catch (DocumentException e) {
			LOGGER.error("Exception Inside the genrateItinerary()"+e);

		}
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;
		cell =new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
	
		cell =new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Operating Airline");
		table.addCell(reservation.getFlight().getOperAirline());
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getdCity());
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArCity());
		table.addCell("Flight No.");
		table.addCell(reservation.getFlight().getfNumber());
		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());
		table.addCell("Estimated Departure Time");
		table.addCell(reservation.getFlight().getEstimedDepartureTime().toString());
		
		cell =new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		

		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getF_name());
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getL_name());
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		table.addCell("Phone No.");
		table.addCell(reservation.getPassenger().getPhone());
		
	
		
		return table;
	}
}
