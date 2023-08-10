package com.example.demo;

import java.time.LocalDate;

public record Customer(Integer id, String firstName, String lastName, LocalDate birthday, String gender, boolean married){}
    
