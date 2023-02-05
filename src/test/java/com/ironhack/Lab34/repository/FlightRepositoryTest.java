package com.ironhack.Lab34.repository;

import com.ironhack.Lab34.model.Aircraft;
import com.ironhack.Lab34.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {
    @Autowired
    FlightRepository flightRepository;
    private Flight testFlight;

    @BeforeEach
    void setUp() {
        testFlight = new Flight("123", Long.valueOf(600), "Boeing-1");
        flightRepository.save(testFlight);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
    }

    @Test
    public void createFlight_validFlight_addedToDatabase(){
        Optional<Flight> foundFlight = flightRepository.findById(testFlight.getNumber());
        assertTrue(foundFlight.isPresent());
        assertEquals("123", foundFlight.get().getNumber());
    }
    @Test
    void findFlight_validNumber_flightFound() {
        List<Flight> found = flightRepository.findByNumber(testFlight.getNumber());
        assertEquals(1, found.size());
        assertEquals(testFlight, found.get(0));
    }
    @Test
    void findByMileageGreaterThan500_validMileage_flightFound() {
        List<Flight> found = flightRepository.findByMileageGreaterThan(Long.valueOf(500));
        assertEquals(1, found.size());
        assertEquals(testFlight, found.get(0));
    }
}