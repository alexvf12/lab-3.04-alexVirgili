package com.ironhack.Lab34.repository;

import com.ironhack.Lab34.enums.CustomerStatus;
import com.ironhack.Lab34.model.Aircraft;
import com.ironhack.Lab34.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AircraftRepositoryTest {
    @Autowired
    AircraftRepository aircraftRepository;
    private Aircraft testAircraft;

    @BeforeEach
    void setUp() {
        testAircraft = new Aircraft("Boeing-1", 300);
        aircraftRepository.save(testAircraft);
    }

    @AfterEach
    void tearDown() {
        aircraftRepository.deleteAll();
    }

    @Test
    public void createAircraft_validAircraft_addedToDatabase(){
        Optional<Aircraft> foundAircraft = aircraftRepository.findById(testAircraft.getModel());
        assertTrue(foundAircraft.isPresent());
        assertEquals("Boeing-1", foundAircraft.get().getModel());
    }
    @Test
    void findAircraft_BoeingName_AircraftFound() {
        assertEquals(1, aircraftRepository.findByModelContaining("Boeing").size());
        assertEquals(testAircraft, aircraftRepository.findByModelContaining("Boeing").get(0));
    }
}