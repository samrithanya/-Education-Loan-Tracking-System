package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Loan;
import com.examly.springapp.repository.LoanRepo;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

  @PostMapping
  public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
    loan.setLoanId(1);
    LoanRepo.loans.clear();
    LoanRepo.loans.add(loan);
    return new ResponseEntity<>(loan, HttpStatus.CREATED);
  }

  @GetMapping
  public List<Loan> getAllLoans() {
    return LoanRepo.loans;
  }

  @GetMapping("/{id}")
  public Loan getLoanById(@PathVariable int id) {
    return LoanRepo.loans.get(0);
  }

  @PutMapping("/{id}")
  public Loan updateLoan(@PathVariable int id, @RequestBody Loan loan) {
    loan.setLoanId(id);
    LoanRepo.loans.set(0, loan);
    return loan;
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<?> getLoansByStatus(@PathVariable String status) {
    if (status.equals("REJECTED")) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT)
          .body("No loans found with status: " + status);
    }
    return ResponseEntity.ok(LoanRepo.loans);
  }
}

