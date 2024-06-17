package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EquipmentRepo;
import com.example.demo.exception.EquipmentNotFoundException;
import com.example.demo.model.Equipment;



@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private EquipmentRepo repo;
	
	public EquipmentServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipment add(Equipment e) {
		repo.save(e);
		return e;

	}
	
   public List<Equipment> findAllEquipment() throws EquipmentNotFoundException{
	   if(repo.findAll().isEmpty()) {
		   throw new EquipmentNotFoundException("There are no employees");
	   }
	   else
	 return repo.findAll();
	   
   }
   
   public Equipment viewById(int id) throws EquipmentNotFoundException {
	   Optional<Equipment> e=repo.findById(id);
	   if(e.isPresent())
	 return e.get();
	   else
		   throw new EquipmentNotFoundException("No employee present for this id");
	   
   }
   
   
   public Equipment update(Equipment emp) {
	   return repo.save(emp);
	      
   }
   
   public void deleteById(int id) {
	    repo.deleteById(id);
   }
}
	

