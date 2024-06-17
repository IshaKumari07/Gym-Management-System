package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.MembershipNotFoundException;
import com.example.demo.model.Membership;

public interface MembershipService {
	
    Membership add(Membership e);
	
    List<Membership> findAllMembership() throws MembershipNotFoundException;
   
    Membership viewById(int membershipId) throws MembershipNotFoundException;
    
  
   
    Membership update(Membership e) ;
   
     void deleteById(int id);

	
     
}
