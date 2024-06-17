package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Member;

public interface MemberRepo extends JpaRepository<Member,Integer>{

	Member findByMemberEmail(String memberEmail);
   
}
