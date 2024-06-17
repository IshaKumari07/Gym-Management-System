package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.OffersRepo;
import com.example.demo.exception.OffersNotFoundException;
import com.example.demo.model.Offers;
import com.example.demo.service.OffersServiceImpl;

@SpringBootTest
class OffersProApplicationTests {
	@Mock
    private OffersRepo repoMock;

    @InjectMocks
    private OffersServiceImpl service;

	@Test
	void contextLoads() {
		
	}
	 @Test
	    public void testAddOffer() {
	        Offers offerToAdd = new Offers(/* provide necessary constructor parameters */);
	        when(repoMock.save(offerToAdd)).thenReturn(offerToAdd);

	        Offers addedOffer = service.add(offerToAdd);

	        assertEquals(offerToAdd, addedOffer);
	        verify(repoMock, times(1)).save(offerToAdd);
	    }
	 @Test
	    public void testFindAllOffersWhenNoneFound() {
	        when(repoMock.findAll()).thenReturn(new ArrayList<>());

	        assertThrows(OffersNotFoundException.class, () -> {
	            service.findAllOffers();
	        });

	        verify(repoMock, times(1)).findAll();
	    }
	 @Test
	    public void testViewByIdWhenOfferNotFound() {
	        int offerId = 1;
	        when(repoMock.findById(offerId)).thenReturn(Optional.empty());

	        assertThrows(OffersNotFoundException.class, () -> {
	            service.viewById(offerId);
	        });

	        verify(repoMock, times(1)).findById(offerId);
	    }
	 
}
