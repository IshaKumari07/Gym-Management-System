package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.OffersRepo;
import com.example.demo.exception.OffersNotFoundException;
import com.example.demo.model.Offers;



@Service
public class OffersServiceImpl implements OffersService {
	
	@Autowired
	private OffersRepo repo;
	
	public OffersServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offers add(Offers e) {
		repo.save(e);
		return e;

	}
   //it is used for find all offers
   public List<Offers> findAllOffers() throws OffersNotFoundException{
	   if(repo.findAll().isEmpty()) {
		   throw new OffersNotFoundException("There are no offers");
	   }
	   else
	 return repo.findAll();
	   
   }
   //it is used for view by id
   public Offers viewById(int id) throws OffersNotFoundException {
	   Optional<Offers> e=repo.findById(id);
	   if(e.isPresent())
	 return e.get();
	   else
		   throw new OffersNotFoundException("No offer present for this id");
	   
   }
   

   //it is used for updating offers
   public Offers update(Offers off) {
	   return repo.save(off);
	      
   }
   //it is used for deleting offers
   public void deleteById(int id) {
	    repo.deleteById(id);
   }
   
   
   }
	

