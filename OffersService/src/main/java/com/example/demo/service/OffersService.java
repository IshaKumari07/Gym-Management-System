package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.OffersNotFoundException;
import com.example.demo.model.Offers;

public interface OffersService {
	
    Offers add(Offers e);
	
    List<Offers> findAllOffers() throws OffersNotFoundException;
   
    Offers viewById(int offerId) throws OffersNotFoundException;
    
  
   
    Offers update(Offers e) ;
   
     void deleteById(int id);
      
     
}
