package com.examly.springapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Loan;

@Repository
public class LoanRepo {

  public static final List<Loan> loans = new ArrayList<>();
}


