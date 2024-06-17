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

import com.example.demo.exception.MembershipNotFoundException;
import com.example.demo.model.Membership;
import com.example.demo.service.MembershipService;


@CrossOrigin("*")

@RestController
public class MembershipController {
	
	@Autowired
	private MembershipService service;
	
   //Get allMembership
	@GetMapping("/mem")
	public List<Membership> showAll() {
		
		try {
			return service.findAllMembership();
		} catch (MembershipNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	//Add Membership
	@PostMapping("/mem")
	public Membership addMembership(@RequestBody Membership mem) {
		return service.add(mem);
		
	}
	
	//Get MembershipbyId
	@GetMapping("/mem/{memId}")
	public Membership showById(@PathVariable(value="memId") int memId) {
		
		try {
			return  service.viewById(memId);
		} catch (MembershipNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	

	//UpdateMembership
    @PutMapping("/mem")
	public Membership updateMembership(@RequestBody Membership e ) {
		return service.update(e);
		
	}
    
    //Delete MembershipbyId
    @DeleteMapping("/mem/{membershipId}")
	public ResponseEntity<HttpStatus> deleteMembership(@PathVariable(value="membershipId") int id)
	{
    	try {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
		
}
	
	
	
	
	

