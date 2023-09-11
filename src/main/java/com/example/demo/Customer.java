package com.example.demo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {

     @Id
     @GeneratedValue
     Integer id;

     String firstName;
     
     String lastName;
     
     LocalDate birthday;
     
     String gender;
     
     boolean married;
    
}
    
