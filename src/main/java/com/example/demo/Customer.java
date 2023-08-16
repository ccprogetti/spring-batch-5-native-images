package com.example.demo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Customer {

     Integer id;
     String firstName;
     String lastName;
     LocalDate birthday;
     String gender;
     boolean married;
    
    }
    
