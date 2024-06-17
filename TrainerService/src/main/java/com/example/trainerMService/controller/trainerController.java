package com.example.trainerMService.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainerMService.exception.TrainerNotFoundException;
import com.example.trainerMService.models.trainerModel;
import com.example.trainerMService.service.trainerService;

@RestController
@CrossOrigin("*")
public class trainerController {
	
	@Autowired
	trainerService service;
	
	@GetMapping("/trainerDetails")
	public List<trainerModel> getTrainerDetails(){
		
		return this.service.getTrainerDetails();
	}
	
	
	//add or insert emp details
	@PostMapping("/addtrainerDetails")
	public trainerModel addTrainerDetail(@RequestBody trainerModel trainerDetail) {
		
		return this.service.addTrainerDetail(trainerDetail);
	}
	
	//update employee details
	@PutMapping("/trainerDetails/{trainerId}")
	public trainerModel updateTrainerDetail(@RequestBody trainerModel trainerDetail,@PathVariable int trainerId) throws TrainerNotFoundException {
		
		return this.service.updateTrainerDetail(trainerDetail,trainerId);
	}
	
	//delete employee details by Id
	@DeleteMapping("/trainerDetails/{trainerId}")
	public void deleteTrainerDetail(@PathVariable int trainerId) throws TrainerNotFoundException {

		     this.service.deleteTrainerDetail(trainerId);

	}

}
