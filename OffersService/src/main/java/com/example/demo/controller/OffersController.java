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

import com.example.demo.exception.OffersNotFoundException;
import com.example.demo.model.Offers;
import com.example.demo.service.OffersService;


@CrossOrigin("*")

@RestController
public class OffersController {
	
	@Autowired
	private OffersService service;
	
   //Get allOffers
	@GetMapping("/off")
	public List<Offers> showAll() {
		
		try {
			return service.findAllOffers();
		} catch (OffersNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	//Add Offers
	@PostMapping("/off")
	public Offers addOffers(@RequestBody Offers off) {
		return service.add(off);
		
	}
	
	//Get OffersbyId
	@GetMapping("/off/{offId}")
	public Offers showById(@PathVariable(value="offId") int offId) {
		
		try {
			return  service.viewById(offId);
		} catch (OffersNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	

	//UpdateOffers
    @PutMapping("/off")
	public Offers updateOffers(@RequestBody Offers e ) {
		return service.update(e);
		
	}
    //Delete offersbyId
    @DeleteMapping("/off/{offerId}")
	public ResponseEntity<HttpStatus> deleteOffers(@PathVariable(value="offerId") int id)
	{
    	try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
		
}
	
	
	
	
	

