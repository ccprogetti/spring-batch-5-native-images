package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerItemProcessor implements ItemProcessor<Customer, Customer> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerItemProcessor.class);

    @Override
    public Customer process(final Customer customer) throws Exception {

        LOG.info("Customer received:" + customer.getFirstName() + " " + customer.getLastName());

        return customer;
    }
}
