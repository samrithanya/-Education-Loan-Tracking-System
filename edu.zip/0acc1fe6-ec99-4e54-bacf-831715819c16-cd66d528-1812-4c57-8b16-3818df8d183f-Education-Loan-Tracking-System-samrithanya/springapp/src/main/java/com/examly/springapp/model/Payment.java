package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Payment {
  @Id
  @GeneratedValue
  private int paymentId;
}


