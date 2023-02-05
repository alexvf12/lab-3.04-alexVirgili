package com.ironhack.Lab34.repository;

import com.ironhack.Lab34.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findByNumber(String number);
    List<Flight> findByMileageGreaterThan(Long mileage);
}
