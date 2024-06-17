package com.example.trainerMService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.trainerMService.models.trainerModel;

public interface trainerRepository extends MongoRepository<trainerModel, Integer>{

}
