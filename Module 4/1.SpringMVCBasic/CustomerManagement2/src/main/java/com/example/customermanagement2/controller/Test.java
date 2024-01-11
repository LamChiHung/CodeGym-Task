package com.example.customermanagement2.controller;

import com.example.customermanagement2.entity.Customer;
import com.example.customermanagement2.entity.CustomerList;

public class Test {
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            Customer customer = new Customer();
            customer.setName("A" + i);
            customer.setEmail("A" + i);
            customer.setAddress("A" + i);
            CustomerList.customers.add(customer);
        }

    }
}
