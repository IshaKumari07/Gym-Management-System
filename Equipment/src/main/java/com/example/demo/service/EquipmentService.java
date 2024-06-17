package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.EquipmentNotFoundException;
import com.example.demo.model.Equipment;

public interface EquipmentService {
	
    Equipment add(Equipment e);
	
    List<Equipment> findAllEquipment() throws EquipmentNotFoundException;
   
    Equipment viewById(int equipmentId) throws EquipmentNotFoundException;
   
    Equipment update(Equipment e) ;
   
     void deleteById(int id);
      
     
}
