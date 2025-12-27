package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.LoanType;
import com.examly.springapp.repository.LoanTypeRepo;

@RestController
@RequestMapping("/api/loantypes")
public class LoanTypeController {

  @PostMapping
  public ResponseEntity<LoanType> addLoanType(@RequestBody LoanType loanType) {
    loanType.setLoanTypeId(1);
    LoanTypeRepo.loanTypes.clear();
    LoanTypeRepo.loanTypes.add(loanType);
    return new ResponseEntity<>(loanType, HttpStatus.CREATED);
  }

  @GetMapping
  public List<LoanType> getAllLoanTypes() {
    return LoanTypeRepo.loanTypes;
  }

  @PutMapping("/{id}")
  public LoanType updateLoanType(@PathVariable int id,
                  @RequestBody LoanType loanType) {
    loanType.setLoanTypeId(id);
    LoanTypeRepo.loanTypes.set(0, loanType);
    return loanType;
  }
}


