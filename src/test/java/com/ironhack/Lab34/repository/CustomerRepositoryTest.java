package com.ironhack.Lab34.repository;

import com.ironhack.Lab34.enums.CustomerStatus;
import com.ironhack.Lab34.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    private Customer testCustomer;
    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        testCustomer = new Customer("David", CustomerStatus.SILVER);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteById(testCustomer.getId());
    }
    @Test
    public void createCustomer_validCustomer_addedToDatabase(){
        customerRepository.save(testCustomer);

        Optional<Customer> foundCustomer = customerRepository.findById(testCustomer.getId());
        assertTrue(foundCustomer.isPresent());
        assertEquals("David", foundCustomer.get().getName());
    }
}