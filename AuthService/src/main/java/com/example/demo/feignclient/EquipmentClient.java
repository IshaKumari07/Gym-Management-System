package com.example.demo.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@FeignClient(value="equipment",url="http://localhost:9093")
public interface EquipmentClient {
	@GetMapping("/equipment")
	public List<EquipmentDTO> showAll();
	
	@PostMapping("/equipment")
	public EquipmentDTO addEquipment(EquipmentDTO equipment);
	
	
	@GetMapping("/equipment/{equipmentId}")
	public EquipmentDTO showById(@PathVariable(value="equipmentId") int equipmentId);
	
	
    @PutMapping("/equipment")
	public EquipmentDTO updateEquipment( EquipmentDTO e );
	
    
    @DeleteMapping("/equipment/{equipmentId}")
	public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable(value="equipmentId") int id);
	
}