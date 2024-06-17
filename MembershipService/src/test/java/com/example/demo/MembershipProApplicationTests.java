package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.MembershipRepo;
import com.example.demo.exception.MembershipNotFoundException;
import com.example.demo.model.Membership;
import com.example.demo.service.MembershipServiceImpl;

@SpringBootTest
class MembershipProApplicationTests {
	@Mock
    private MembershipRepo repoMock;

    @InjectMocks
    private MembershipServiceImpl service;
	

	@Test
	void contextLoads() {
		
	}
	 @Test
	    public void testAddMembership() {
	        Membership membershipToAdd = new Membership(/* provide necessary constructor parameters */);
	        when(repoMock.save(membershipToAdd)).thenReturn(membershipToAdd);

	        Membership addedMembership = service.add(membershipToAdd);

	        assertEquals(membershipToAdd, addedMembership);
	        verify(repoMock, times(1)).save(membershipToAdd);
	    }
	 @Test
	    public void testFindAllMembershipsWhenNoneFound() {
	        when(repoMock.findAll()).thenReturn(new ArrayList<>());

	        assertThrows(MembershipNotFoundException.class, () -> {
	            service.findAllMembership();
	        });
	    }
	 @Test
	    public void testDeleteMembership() {
	        int membershipId = 1;

	        assertDoesNotThrow(() -> {
	            service.deleteById(membershipId);
	        });

	        verify(repoMock, times(1)).deleteById(membershipId);
	    }

	 
	
	 
	 
}
