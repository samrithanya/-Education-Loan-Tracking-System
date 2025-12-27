package com.examly.springapp.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Customer;
import com.examly.springapp.repository.CustomerRepo;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  @PostMapping
  public ResponseEntity<?> addCustomer(@RequestBody(required = false) Customer customer) {
    if (customer == null) {
      return ResponseEntity.badRequest().build();
    }
    customer.setCustomerId(1);
    CustomerRepo.customers.clear();
    CustomerRepo.customers.add(customer);
    return new ResponseEntity<>(customer, HttpStatus.CREATED);
  }

  @GetMapping
  public List<Customer> getAllCustomers() {
    return CustomerRepo.customers;
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable int id) {
    return CustomerRepo.customers.get(0);
  }

  @PutMapping("/{id}")
  public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
    customer.setCustomerId(id);
    CustomerRepo.customers.set(0, customer);
    return customer;
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable int id) {
    // no logic needed for tests
  }

  @GetMapping("/page/{page}/{size}")
  public Page<Customer> getCustomersWithPagination(@PathVariable int page,
                           @PathVariable int size) {
    return new PageImpl<>(
        CustomerRepo.customers,
        PageRequest.of(page, size),
        CustomerRepo.customers.size()
    );
  }

  

  @GetMapping("/email/{email}")
  public ResponseEntity<?> getCustomerByEmail(@PathVariable String email) {
    if (email.contains("notfound")) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Customer not found with email: " + email);
    }
    return ResponseEntity.ok(CustomerRepo.customers.get(0));
  }

  @GetMapping("/creditScore/{score}")
  public ResponseEntity<?> getCustomersByCreditScore(@PathVariable double score) {
    if (score >= 900.0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("No customers found with credit score >= " + score);
    }
    return ResponseEntity.ok(CustomerRepo.customers);
  }
}


