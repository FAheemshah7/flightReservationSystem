package com.flightReservationSystem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tPassenger")
public class Passenger extends AbstractEntity{

	
	@Column(name="fName")
	private String f_name;
	@Column(name="lName")
	private String l_name;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;

	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
