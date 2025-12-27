package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class LoanType {

  @Id
  @GeneratedValue
  private int loanTypeId;

  private String typeName;
  private String description;
  private double interestRate;

  public int getLoanTypeId() { return loanTypeId; }
  public void setLoanTypeId(int loanTypeId) { this.loanTypeId = loanTypeId; }

  public String getTypeName() { return typeName; }
  public void setTypeName(String typeName) { this.typeName = typeName; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public double getInterestRate() { return interestRate; }
  public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
}


