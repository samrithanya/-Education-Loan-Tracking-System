package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Loan {

  @Id
  @GeneratedValue
  private int loanId;

  private double loanAmount;
  private double interestRate;
  private int tenureMonths;
  private String status;

  @ManyToOne
  private Customer customer;

  @ManyToOne
  private LoanType loanType;

  public int getLoanId() { return loanId; }
  public void setLoanId(int loanId) { this.loanId = loanId; }

  public double getLoanAmount() { return loanAmount; }
  public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }

  public double getInterestRate() { return interestRate; }
  public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

  public int getTenureMonths() { return tenureMonths; }
  public void setTenureMonths(int tenureMonths) { this.tenureMonths = tenureMonths; }

  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }

  public Customer getCustomer() { return customer; }
  public void setCustomer(Customer customer) { this.customer = customer; }

  public LoanType getLoanType() { return loanType; }
  public void setLoanType(LoanType loanType) { this.loanType = loanType; }
}


