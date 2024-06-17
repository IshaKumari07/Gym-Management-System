package com.example.demo.feignclient;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class MembershipDTO {
	@Id
	private int membershipId;
	private String memberName;
	private boolean active;
	private LocalDate startDate;
	private LocalDate endDate;
	private String desc;
	private int payment;
	
	
	
	
	public MembershipDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public MembershipDTO(int membershipId, String memberName, boolean active, LocalDate startDate, LocalDate endDate,
			String desc, int payment) {
		super();
		this.membershipId = membershipId;
		this.memberName = memberName;
		this.active = active;
		this.startDate = startDate;
		this.endDate = endDate;
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




	public LocalDate getStartDate() {
		return startDate;
	}




	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}




	public LocalDate getEndDate() {
		return endDate;
	}




	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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
