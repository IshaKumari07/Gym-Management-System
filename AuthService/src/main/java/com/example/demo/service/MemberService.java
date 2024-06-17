package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.repo.MemberRepo;

@Service
public class MemberService {

	@Autowired
	MemberRepo repo;
	
	public String addMember(Member m) {
		 // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		repo.save(m);
		return "Member added successfully";
	}

	public Member findByMembrEmail(String currentUserEmail) {
		// TODO Auto-generated method stub
		
		return repo.findByMemberEmail(currentUserEmail);
	}
}
