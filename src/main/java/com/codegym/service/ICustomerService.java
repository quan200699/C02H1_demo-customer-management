package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void createNewCustomer(Customer customer);

    boolean updateCustomerInfo(int id, Customer customer);

    boolean deleteById(int id);
    List<Customer> findAllCustomerByAddress(String address);
}
