package com.example.demo.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Equipment;

@Repository
public interface EquipmentRepo extends MongoRepository<Equipment,Integer>{

	//Employee findByName(String employeeName);
	

	
}
