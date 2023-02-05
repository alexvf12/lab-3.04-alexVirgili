package com.ironhack.Lab34.repository;

import com.ironhack.Lab34.enums.CustomerStatus;
import com.ironhack.Lab34.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByStatus(CustomerStatus status);
}
