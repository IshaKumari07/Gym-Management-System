package com.example.demo.feignclient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDTO {
	private int trainerId;
    private String trainerName;
    private String trainerEmail;
    private long trainerPhoneNumber;
    private String trainerSpecification;
    private String imageUrl;
    
    public TrainerDTO(int trainerId, String trainerName, String trainerEmail, long trainerPhoneNumber,
			String trainerSpecification,String imageUrl) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerEmail = trainerEmail;
		this.trainerPhoneNumber = trainerPhoneNumber;
		this.trainerSpecification = trainerSpecification;
		this.imageUrl=imageUrl;
	}
	public TrainerDTO() {
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
    
}
