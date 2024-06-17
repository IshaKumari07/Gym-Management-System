package com.example.demo.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@FeignClient(value="trainer",url="http://localhost:9092")
public interface TrainerClient {

	@GetMapping("/trainerDetails")
	public List<TrainerDTO> getTrainerDetails();
	
	
	@PostMapping("/addtrainerDetails")
	public TrainerDTO addTrainerDetail( TrainerDTO trainerDetail);

	
	@PutMapping("/trainerDetails/{trainerId}")
	public TrainerDTO updateTrainerDetail(TrainerDTO trainerDetail,@PathVariable int trainerId);


	@DeleteMapping("/trainerDetails/{trainerId}")
	public void deleteTrainerDetail(@PathVariable int trainerId);

}