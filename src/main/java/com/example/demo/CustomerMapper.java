package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class CustomerMapper implements FieldSetMapper<Customer> {
 
    public Customer mapFieldSet(FieldSet fieldSet)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Customer customer = new Customer();
        customer.setFirstName(fieldSet.readString("firstName"));
        customer.setLastName(fieldSet.readString("lastName"));
        String dateString = fieldSet.readString("birthday");
        customer.setBirthday(LocalDate.parse(dateString, formatter));
        customer.setGender(fieldSet.readString("gender").equals("male") ? "m" : "f");
        customer.setMarried(Boolean.parseBoolean(fieldSet.readString("married")));
        return customer;
    }
}
