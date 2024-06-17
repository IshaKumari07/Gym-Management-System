package com.example.trainerMService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class trainerModel {
	@Id
	private int trainerId;
    private String trainerName;
    private String trainerEmail;
    private long trainerPhoneNumber;
    private String trainerSpecification;
    private String imageUrl;
    
    
    
	public trainerModel(int trainerId, String trainerName, String trainerEmail, long trainerPhoneNumber,
			String trainerSpecification,String imageUrl) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerEmail = trainerEmail;
		this.trainerPhoneNumber = trainerPhoneNumber;
		this.trainerSpecification = trainerSpecification;
		this.imageUrl=imageUrl;
	}
	public trainerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getTrainerEmail() {
		return trainerEmail;
	}
	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}
	public long getTrainerPhoneNumber() {
		return trainerPhoneNumber;
	}
	public void setTrainerPhoneNumber(long trainerPhoneNumber) {
		this.trainerPhoneNumber = trainerPhoneNumber;
	}
	public String getTrainerSpecification() {
		return trainerSpecification;
	}
	public void setTrainerSpecification(String trainerSpecification) {
		this.trainerSpecification = trainerSpecification;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return "trainerModel [trainerId=" + trainerId + ", trainerName=" + trainerName + ", trainerEmail="
				+ trainerEmail + ", trainerPhoneNumber=" + trainerPhoneNumber + ", trainerSpecification="
				+ trainerSpecification + "]";
	}
    
    

}
