package com.codegym.dao;

import com.codegym.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    public static final String SELECT_ALL_CUSTOMER = "select * from customer";
    public static final String SELECT_CUSTOMER_BY_ID = "select * from customer where id = ?";
    public static final String INSERT_CUSTOMER = "insert into customer (name, address) VALUE (?, ?)";
    public static final String UPDATE_CUSTOMER_BY_ID = "update customer set name = ?, address = ? where id = ?";

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                customers.add(new Customer(id, name, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = new Customer();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                customer.setName(name);
                customer.setAddress(address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean createNewCustomer(Customer customer) {
        Connection connection = SQLConnection.getConnection();
        int rowInserted = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            rowInserted = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowInserted != 0;
    }

    @Override
    public boolean updateCustomerInfo(int id, Customer customer) {
        Connection connection = SQLConnection.getConnection();
        int rowUpdated = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setInt(3, id);
            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated != 0;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return false;
    }
}
