package com.example.demo.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Membership;


public interface MembershipRepo extends MongoRepository<Membership,Integer>{

	

	
}
