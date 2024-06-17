package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EquipmentNotFoundException;
import com.example.demo.model.Equipment;
import com.example.demo.service.EquipmentService;

@RestController
@CrossOrigin("*")
public class EquipmentController {

	@Autowired
	private EquipmentService service;

	@GetMapping("/equipment")
	public List<Equipment> showAll() throws EquipmentNotFoundException {
		return service.findAllEquipment();

//		try {
//			return service.findAllEquipment();
//		} catch (EquipmentNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			return null;
//		}

	}

	@PostMapping("/equipment")
	public Equipment addEquipment(@RequestBody Equipment equipment) {
		return service.add(equipment);

	}

	@GetMapping("/equipment/{equipmentId}")
	public Equipment showById(@PathVariable(value = "equipmentId") int equipmentId) throws EquipmentNotFoundException {

//		try {
//			return service.viewById(equipmentId);
//		} catch (EquipmentNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
		return service.viewById(equipmentId);

	}

	@PutMapping("/equipment")
	public Equipment updateEquipment(@RequestBody Equipment e) {
		return service.update(e);

	}

	@DeleteMapping("/equipment/{equipmentId}")
	public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable(value = "equipmentId") int id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
