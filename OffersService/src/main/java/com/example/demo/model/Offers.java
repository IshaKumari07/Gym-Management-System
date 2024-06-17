package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document

public class Offers {
	
	@Id
	private int offerId;
	private String offerName;
	private String description;
	private String registrationdeadline;
	private String status;
	private String schedule;
	private int payment;
	
	
	
	
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offers(int employeeId, String employeeName, String email, String address, String doj, String dob, int offerId, String offerName, String description, String registrationdeadline, String status, String schedule,int payment) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.description = description;
		this.registrationdeadline = registrationdeadline;
		this.status = status;
		this.schedule = schedule;
		this.payment=payment;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegistrationdeadline() {
		return registrationdeadline;
	}
	public void setRegistrationdeadline(String registrationdeadline) {
		this.registrationdeadline = registrationdeadline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Offers [offerId=" + offerId + ", offerName=" + offerName + ", description=" + description
				+ ", registrationdeadline=" + registrationdeadline + ", status=" + status + ", schedule=" + schedule
				+ "]";
	}
}
	