package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import lombok.NonNull;

@Component
public class CustomerItemProcessor implements ItemProcessor<Customer, Customer> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerItemProcessor.class);

    @Override
    public Customer process(Customer customer) throws Exception {

        LOG.trace("Customer received:" + customer.getFirstName() + " " + customer.getLastName());

        return customer;
    }
}
