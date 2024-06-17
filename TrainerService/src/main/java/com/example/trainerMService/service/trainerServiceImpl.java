package com.example.trainerMService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainerMService.exception.TrainerNotFoundException;
import com.example.trainerMService.models.trainerModel;
import com.example.trainerMService.repo.trainerRepository;

@Service
public class trainerServiceImpl implements trainerService{
	
	@Autowired
	trainerRepository trainerRepo;

	@Override
	public List<trainerModel> getTrainerDetails() {
		
		return trainerRepo.findAll();
	}

	@Override
	public trainerModel addTrainerDetail(trainerModel trainerDetail) {
		trainerRepo.save(trainerDetail);
		return trainerDetail;
	}

	@Override
	public trainerModel updateTrainerDetail(trainerModel trainerDetail, int trainerId) throws TrainerNotFoundException{
	
		trainerModel t=trainerRepo.findById(trainerId).get();
		if(t==null) {
			throw new TrainerNotFoundException("User not found for this particular Id");
		}
		t.setTrainerName(trainerDetail.getTrainerName());
		t.setTrainerEmail(trainerDetail.getTrainerEmail());
		t.setTrainerPhoneNumber(trainerDetail.getTrainerPhoneNumber());
		t.setTrainerSpecification(trainerDetail.getTrainerSpecification());
		t.setImageUrl(trainerDetail.getImageUrl());
		return trainerRepo.save(t);
	}

	@Override
	public void deleteTrainerDetail(int trainerId) throws TrainerNotFoundException{
		trainerModel t=trainerRepo.findById(trainerId).get();
		if(t==null) {
			throw new TrainerNotFoundException("User not found for this particular Id");
		}
		trainerRepo.deleteById(trainerId);
		
	}

}
