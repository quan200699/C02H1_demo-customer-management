package com.codegym.service;

import com.codegym.dao.CustomerDAO;
import com.codegym.dao.ICustomerDAO;
import com.codegym.model.Customer;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerDAO customerDAO = new CustomerDAO();

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerDAO.findById(id);
    }


    @Override
    public void createNewCustomer(Customer customer) {
        customerDAO.createNewCustomer(customer);
    }

    @Override
    public boolean updateCustomerInfo(int id, Customer customer) {
        return customerDAO.updateCustomerInfo(id,customer);
    }

    @Override
    public boolean deleteById(int id) {
        return customerDAO.deleteCustomer(id);
    }

    @Override
    public List<Customer> findAllCustomerByAddress(String address) {
        return customerDAO.findAllCustomerByAddress(address);
    }

    @Override
    public List<Customer> sortAllCustomer() {
        return customerDAO.sortAllCustomer();
    }
}
