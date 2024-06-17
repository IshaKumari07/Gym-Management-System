package com.example.demo.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="offers",url="http://localhost:9094")
public interface OffersClient {
	
	
	@GetMapping("/off")
	public List<OffersDTO> showAll();
	
	
	//Add Offers
	@PostMapping("/off")
	public OffersDTO addOffers(@RequestBody OffersDTO off);
	
	//Get OffersbyId
	@GetMapping("/off/{offId}")
	public OffersDTO showById(@PathVariable(value="offId") int offId) ;
	

	//UpdateOffers
    @PutMapping("/off")
	public OffersDTO updateOffers(@RequestBody OffersDTO e ) ;
    
    //Delete offersbyId
    @DeleteMapping("/off/{offerId}")
	public ResponseEntity<HttpStatus> deleteOffers(@PathVariable(value="offerId") int id);
}
