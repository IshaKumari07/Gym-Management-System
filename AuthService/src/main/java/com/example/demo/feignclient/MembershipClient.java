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



@FeignClient(value="membership",url="http://localhost:9091")
public interface MembershipClient {
	

	@GetMapping("/mem")
	public List<MembershipDTO> showAll();
	
	//Add Membership
	@PostMapping("/mem")
	public MembershipDTO addMembership(@RequestBody MembershipDTO mem);
	
	//Get MembershipbyId
	@GetMapping("/mem/{memId}")
	public MembershipDTO showById(@PathVariable(value="memId") int memId);
	

	//UpdateMembership
    @PutMapping("/mem")
	public MembershipDTO updateMembership(@RequestBody MembershipDTO e ) ;
    
    //Delete MembershipbyId
    @DeleteMapping("/mem/{membershipId}")
	public ResponseEntity<HttpStatus> deleteMembership(@PathVariable(value="membershipId") int id);

}
