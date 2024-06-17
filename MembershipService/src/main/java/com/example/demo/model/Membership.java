package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
public class Membership {
	
	@Id
	private int membershipId;
	private String memberName;
	private boolean active;

	private String desc;
	private int payment;
	
	
	
	
	public Membership() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Membership(int membershipId, String memberName, boolean active, 
			String desc, int payment) {
		super();
		this.membershipId = membershipId;
		this.memberName = memberName;
		this.active = active;
	
		this.desc = desc;
		this.payment = payment;
	}




	public int getMembershipId() {
		return membershipId;
	}




	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}




	public String getMemberName() {
		return memberName;
	}




	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}




	public boolean isActive() {
		return active;
	}




	public void setActive(boolean active) {
		this.active = active;
	}


	public String getDesc() {
		return desc;
	}




	public void setDesc(String desc) {
		this.desc = desc;
	}




	public int getPayment() {
		return payment;
	}




	public void setPayment(int payment) {
		this.payment = payment;
	}
	
}
	