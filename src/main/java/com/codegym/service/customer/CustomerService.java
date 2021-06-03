package com.codegym.service.customer;

import com.codegym.dao.customer.CustomerDAO;
import com.codegym.dao.customer.ICustomerDAO;
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
    public boolean create(Customer customer) {
        return customerDAO.create(customer);
    }

    @Override
    public boolean update(int id, Customer customer) {
        return customerDAO.update(id,customer);
    }

    @Override
    public boolean delete(int id) {
        return customerDAO.delete(id);
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
