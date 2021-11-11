package com.flightReservationSystem.dto;

public class ReservationRequest {

	private int flightId;
	private String pFisrtName;
	private String pLastName;
	private String pEmail;
	private String pPhone;
	private String nameOnTheCard;
	private String cardNo;
	private String expiryDate;
	private String pinCode;

	public int getFlightId() {
		return flightId;
	}

	public String getpFisrtName() {
		return pFisrtName;
	}

	public String getpLastName() {
		return pLastName;
	}

	public String getpEmail() {
		return pEmail;
	}

	public String getpPhone() {
		return pPhone;
	}

	public String getNameOnTheCard() {
		return nameOnTheCard;
	}

	public String getCardNo() {
		return cardNo;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public void setpFisrtName(String pFisrtName) {
		this.pFisrtName = pFisrtName;
	}

	public void setpLastName(String pLastName) {
		this.pLastName = pLastName;
	}

	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}

	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}

	public void setNameOnTheCard(String nameOnTheCard) {
		this.nameOnTheCard = nameOnTheCard;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
