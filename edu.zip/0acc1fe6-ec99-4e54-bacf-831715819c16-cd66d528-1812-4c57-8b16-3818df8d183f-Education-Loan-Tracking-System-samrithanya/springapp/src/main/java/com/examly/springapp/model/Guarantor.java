package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Guarantor {
  @Id
  @GeneratedValue
  private int guarantorId;
}


