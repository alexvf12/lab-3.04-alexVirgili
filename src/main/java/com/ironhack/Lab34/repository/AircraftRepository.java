package com.ironhack.Lab34.repository;

import com.ironhack.Lab34.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, String> {

}
