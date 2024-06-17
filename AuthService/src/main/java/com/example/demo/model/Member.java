package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int memberId;
	private String memberFirstName;
	private String memberLastName;
	private String memberEmail;
	private String membershipName;
	private Long mobile;
	private String gender;
	
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Member(int memberId, String memberFirstName, String memberLastName, String memberEmail,
			String membershipName, Long mobile, String gender) {
		super();
		this.memberId = memberId;
		this.memberFirstName = memberFirstName;
		this.memberLastName = memberLastName;
		this.memberEmail = memberEmail;
		this.membershipName = membershipName;
		this.mobile = mobile;
		this.gender = gender;
	}



	public int getMemberId() {
		return memberId;
	}



	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}



	public String getMemberFirstName() {
		return memberFirstName;
	}



	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}



	public String getMemberLastName() {
		return memberLastName;
	}



	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}



	public String getMemberEmail() {
		return memberEmail;
	}



	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}



	public String getMembershipName() {
		return membershipName;
	}



	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}



	public Long getMobile() {
		return mobile;
	}



	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
}
