package com.example.trainerMService;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
 
import com.example.trainerMService.exception.TrainerNotFoundException;
import com.example.trainerMService.models.trainerModel;
import com.example.trainerMService.repo.trainerRepository;
import com.example.trainerMService.service.trainerServiceImpl;
 
 
@SpringBootTest
class TrainerMServiceApplicationTests {
 
	@Test
	void contextLoads() {
	}
	@Mock
    private trainerRepository trainerRepo;
 
    @InjectMocks
    private trainerServiceImpl trainerService;
    @Test
    void testAddTrainerDetail() {
        // Arrange
        trainerModel trainerDetailToAdd = new trainerModel(1, "John", "john@example.com", 1234567890, "Fitness","fitness");
        when(trainerRepo.save(trainerDetailToAdd)).thenReturn(trainerDetailToAdd);
 
        // Act
        trainerModel addedTrainerDetail = trainerService.addTrainerDetail(trainerDetailToAdd);
 
        // Assert
        assertEquals(trainerDetailToAdd, addedTrainerDetail);
    }
    @Test
    void testDeleteTrainerDetail_TrainerExists() throws TrainerNotFoundException {
        // Arrange
        int trainerId = 1;
        trainerModel existingTrainer = new trainerModel(1, "John", "john@example.com", 123456789, "Fitness","fitness");
        when(trainerRepo.findById(trainerId)).thenReturn(Optional.of(existingTrainer));
 
        // Act
        trainerService.deleteTrainerDetail(trainerId);
 
        // Assert
        verify(trainerRepo).deleteById(trainerId);
    }
}