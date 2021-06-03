package com.codegym.dao.customer;

import com.codegym.dao.IGeneralDAO;
import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerDAO extends IGeneralDAO<Customer> {
    List<Customer> findAllCustomerByAddress(String address);

    List<Customer> sortAllCustomer();
}
