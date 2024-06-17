package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feignclient.EquipmentClient;
import com.example.demo.feignclient.EquipmentDTO;
import com.example.demo.feignclient.MembershipClient;
import com.example.demo.feignclient.MembershipDTO;
import com.example.demo.feignclient.OffersClient;
import com.example.demo.feignclient.OffersDTO;
import com.example.demo.feignclient.TrainerClient;
import com.example.demo.feignclient.TrainerDTO;
import com.example.demo.model.Member;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.MemberService;

@CrossOrigin("*")
@RestController
public class AdminUsers {
	

	@Autowired
	private TrainerClient client;
	
	@Autowired
	private EquipmentClient client2;
	
	@Autowired
	private MembershipClient memClient;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OffersClient offersClient;
	
	@Autowired
	UserRepo UserRepo;

    @GetMapping("/user/alone")
    public ResponseEntity<Object> userAlone(){
        return ResponseEntity.ok("USers alone can access this ApI only");
    }

    @GetMapping("/adminuser/both")
    public ResponseEntity<Object> bothAdminaAndUsersApi(){
        return ResponseEntity.ok("Both Admin and Users Can  access the api");
    }

    /** You can use this to get the details(name,email,role,ip, e.t.c) of user accessing the service*/
    @GetMapping("/public/email")
    public String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication); //get all details(name,email,password,roles e.t.c) of the user
        System.out.println(authentication.getDetails()); // get remote ip
        System.out.println(authentication.getName()); //returns the email because the email is the unique identifier
        System.out.println(authentication.getAuthorities());
        return authentication.getName(); // returns the email
    }
    
//    @GetMapping("/public/{email}")
//    public String getRole(@PathVariable String email) {
//    	String role="role";
//    	Optional<User> users=UserRepo.findByEmail(email) ;	
//    			if(getCurrentUserEmail().equals(email)) {
//    			
//    		       role=users.get().getRole();
//    	}
//    			return role;
//    }
  //Trainer
    @GetMapping("/adminuser/trainerDetails")
	public List<TrainerDTO> getTrainerDetails(){
		
		return client.getTrainerDetails();
	}
	
	
    @PostMapping("/admin/addtrainerDetails")
	public TrainerDTO addTrainerDetail(@RequestBody TrainerDTO trainerDetail) {
		
		return client.addTrainerDetail(trainerDetail);
	}
	
	@PutMapping("/admin/trainerDetails/{trainerId}")
	public TrainerDTO updateTrainerDetail(@RequestBody TrainerDTO trainerDetail,@PathVariable int trainerId) {
		
		return client.updateTrainerDetail(trainerDetail, trainerId);
	}
	
	@DeleteMapping("/admin/trainerDetails/{trainerId}")
	public void deleteTrainerDetail(@PathVariable int trainerId){

		     client.deleteTrainerDetail(trainerId);

	}
	
	//equipment
		@GetMapping("/adminuser/equipment")
		public List<EquipmentDTO> showAllEquipment(){
			return client2.showAll();
		}
		
		@PostMapping("/admin/equipment")
		public EquipmentDTO addEquipment(EquipmentDTO equipment) {
			return client2.addEquipment(equipment);
		}
		
		
		@GetMapping("/adminuser/equipment/{equipmentId}")
		public EquipmentDTO showById(@PathVariable(value="equipmentId") int equipmentId) {
			return client2.showById(equipmentId);
		}
		
		
	    @PutMapping("/admin/equipment")
		public EquipmentDTO updateEquipment(@RequestBody EquipmentDTO e ) {
	    	return client2.updateEquipment(e);
	    }
		
	    
	    @DeleteMapping("/admin/equipment/{equipmentId}")
		public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable(value="equipmentId") int id){
	    	return client2.deleteEquipment(id);
	    }
	    
	    
	    //Membership
	    
		@GetMapping("/adminuser/mem")
		public List<MembershipDTO> showAll(){
			return memClient.showAll();
		}
		
		//Add Membership
		@PostMapping("/admin/mem")
		public MembershipDTO addMembership(@RequestBody MembershipDTO mem) {
			return memClient.addMembership(mem);
		}
		
		//Get MembershipbyId
		@GetMapping("/adminuser/mem/{memId}")
		public MembershipDTO showByMembrshipId(@PathVariable(value="memId") int memId) {
			return memClient.showById(memId);
		}
		

		//UpdateMembership
	    @PutMapping("/admin/mem")
		public MembershipDTO updateMembership(@RequestBody MembershipDTO e ) {
	    	return memClient.updateMembership(e);
	    }
	    
	    //Delete MembershipbyId
	    
	    @DeleteMapping("/admin/mem/{membershipId}")
		public ResponseEntity<HttpStatus> deleteMembership(@PathVariable(value="membershipId") int id){
	    	return memClient.deleteMembership(id);
	    }
	    
	    //member details
	    @PostMapping("/user/addMember")
	    public String addMember(@RequestBody Member m) {
	    	return memberService.addMember(m);
	    }
      
//	    public MembershipDTO getMembershipForMember() {
//	    	
//	    }
	   
	    @GetMapping("/adminuser/off")
		public List<OffersDTO> showAllOffers() {
			return offersClient.showAll();
			
			
		}
		//Add Offers
		@PostMapping("/admin/off")
		public OffersDTO addOffers(@RequestBody OffersDTO off) {
			return offersClient.addOffers(off);
			
		}
		
		//Get OffersbyId
		@GetMapping("/adminuser/off/{offId}")
		public OffersDTO showByOffersId(@PathVariable(value="offId") int offId) {
			
			return offersClient.showById(offId);
			
		}
		
		//UpdateOffers
	    @PutMapping("/admin/off")
		public OffersDTO updateOffers(@RequestBody OffersDTO e ) {
			return offersClient.updateOffers(e);
		}
	    
	    //Delete offersbyId
	    @DeleteMapping("/admin/off/{offerId}")
		public ResponseEntity<HttpStatus> deleteOffers(@PathVariable(value="offerId") int id)
		{
	    	return offersClient.deleteOffers(id);
		}
	    
	    
	    
}