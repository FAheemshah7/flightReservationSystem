package com.flightReservationSystem.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tFlight")
public class Flight  extends AbstractEntity{
	
	@Column(name="f_number")
	private String fNumber;
	
	@Column(name="opr_airline")
	private String operAirline;
	
	@Column(name="departure_city")
	private String dCity;
	
	@Column(name="arrival_city")
	private String arCity;
	
	@Column(name="date_of_departure")
	private Date dateOfDeparture;
	
	@Column(name="es_departure_time")
	private Timestamp estimedDepartureTime;
	
	public String getfNumber() {
		return fNumber;
	}
	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}
	public String getOperAirline() {
		return operAirline;
	}
	public void setOperAirline(String operAirline) {
		this.operAirline = operAirline;
	}
	public String getdCity() {
		return dCity;
	}
	public void setdCity(String dCity) {
		this.dCity = dCity;
	}
	public String getArCity() {
		return arCity;
	}
	
	public void setArCity(String arCity) {
		this.arCity = arCity;
	}
	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}
	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	public Timestamp getEstimedDepartureTime() {
		return estimedDepartureTime;
	}
	public void setEstimedDepartureTime(Timestamp estimedDepartureTime) {
		this.estimedDepartureTime = estimedDepartureTime;
	}
	@Override
	public String toString() {
		return "Flight [fNumber=" + fNumber + ", operAirline=" + operAirline + ", dCity=" + dCity + ", arCity=" + arCity
				+ ", dateOfDeparture=" + dateOfDeparture + ", estimedDepartureTime=" + estimedDepartureTime + "]";
	}


}
