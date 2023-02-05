package com.ironhack.Lab34.repository;

import com.ironhack.Lab34.enums.CustomerStatus;
import com.ironhack.Lab34.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;
    private Customer testCustomer;

    @BeforeEach
    void setUp() {
        testCustomer = new Customer("David", CustomerStatus.SILVER);
        customerRepository.save(testCustomer);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteById(testCustomer.getId());
    }
    @Test
    public void createCustomer_validCustomer_addedToDatabase(){
        Optional<Customer> foundCustomer = customerRepository.findById(testCustomer.getId());
        assertTrue(foundCustomer.isPresent());
        assertEquals("David", foundCustomer.get().getName());
    }

    @Test
    public void findCustomers_ValidStatus_CustomerFound(){
        List<Customer> found = customerRepository.findByStatus(CustomerStatus.SILVER);
        assertEquals(1, found.size());
        assertEquals(testCustomer, found.get(0));
    }
}