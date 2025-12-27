package com.examly.springapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Customer;

@Repository
public class CustomerRepo {

  // Used by controllers (static to persist across requests)
  public static final List<Customer> customers = new ArrayList<>();
}


