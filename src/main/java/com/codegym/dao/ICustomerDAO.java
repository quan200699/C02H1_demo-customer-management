package com.codegym.dao;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAll();

    Customer findById(int id);

    boolean createNewCustomer(Customer customer);

    boolean updateCustomerInfo(int id, Customer customer);

    boolean deleteCustomer(int id);
}
