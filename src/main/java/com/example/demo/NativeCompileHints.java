package com.example.demo;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class NativeCompileHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
      
        // Register CSV file
        hints.resources().registerPattern("data.csv");

        // add lombok generated methods for Customer type
        hints.reflection().registerType(Customer.class, MemberCategory.values());
        
    }

}