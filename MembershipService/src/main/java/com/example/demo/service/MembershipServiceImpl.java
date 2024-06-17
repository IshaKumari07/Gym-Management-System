package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MembershipRepo;
import com.example.demo.exception.MembershipNotFoundException;
import com.example.demo.model.Membership;



@Service
public class MembershipServiceImpl implements MembershipService {
	
	@Autowired
	private MembershipRepo repo;
	
	public MembershipServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Membership add(Membership e) {
		repo.save(e);
		return e;

	}
   //it is used for find all membership
   public List<Membership> findAllMembership() throws MembershipNotFoundException{
	   if(repo.findAll().isEmpty()) {
		   throw new MembershipNotFoundException("There are no membership");
	   }
	   else
	 return repo.findAll();
	   
   }
   //it is used for view by id
   public Membership viewById(int id) throws MembershipNotFoundException {
	   Optional<Membership> e=repo.findById(id);
	   if(e.isPresent())
	 return e.get();
	   else
		   throw new MembershipNotFoundException("No membership present for this id");
	   
   }
   

   //it is used for updating membership
   public Membership update(Membership mem) {
	   return repo.save(mem);
	      
   }
   //it is used for deleting membership
   public void deleteById(int id) {
	    repo.deleteById(id);
   }


   
   
   }
	

