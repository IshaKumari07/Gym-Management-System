package com.example.trainerMService.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.trainerMService.exception.TrainerNotFoundException;
import com.example.trainerMService.models.trainerModel;

public interface trainerService {
	
	public List<trainerModel> getTrainerDetails();
	public trainerModel addTrainerDetail(trainerModel trainerDetail);
	public trainerModel updateTrainerDetail(trainerModel trainerDetail,int trainerId) throws TrainerNotFoundException;
	public void deleteTrainerDetail(int trainerId) throws TrainerNotFoundException;

}
