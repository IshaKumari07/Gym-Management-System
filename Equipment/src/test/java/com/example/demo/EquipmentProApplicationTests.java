package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.EquipmentRepo;
import com.example.demo.model.Equipment;
import com.example.demo.service.EquipmentServiceImpl;

@SpringBootTest
class EquipmentProApplicationTests {

	@Test
	void contextLoads() {
	}
	  @Mock
	    private EquipmentRepo repo;
	 
	    @InjectMocks
	    private EquipmentServiceImpl service;
	    
	    @Test
	    public void testAdd() {
	        // Mock data
	        Equipment equipment = new Equipment(1, "Treadmill", "Running","tread");
	 
	        // Mock service behavior
	        when(repo.save(equipment)).thenReturn(equipment);
	 
	        // Call service method
	        Equipment result = service.add(equipment);
	 
	        // Verify that the repository method was called
	        verify(repo).save(equipment);
	 
	        // Verify the result
	        assertEquals(equipment, result);
	    }
	    @Test
	    public void testDeleteById() {
	        doNothing().when(repo).deleteById(1);

	        assertDoesNotThrow(() -> {
	            service.deleteById(1);
	        });
	    }
}
