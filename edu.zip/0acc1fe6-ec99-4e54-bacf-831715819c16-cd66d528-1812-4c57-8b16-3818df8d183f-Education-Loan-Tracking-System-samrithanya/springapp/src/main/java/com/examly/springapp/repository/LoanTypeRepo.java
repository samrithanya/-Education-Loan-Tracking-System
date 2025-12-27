package com.examly.springapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.examly.springapp.model.LoanType;

@Repository
public class LoanTypeRepo {

  public static final List<LoanType> loanTypes = new ArrayList<>();
}


