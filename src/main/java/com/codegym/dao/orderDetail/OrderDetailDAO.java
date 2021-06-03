package com.codegym.dao.orderDetail;

import com.codegym.dao.SQLConnection;
import com.codegym.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO implements IOderDetailDAO {
    public static final String SELECT_ALL_ORDER_DETAILS = "select * from order_details";
    public static final String SELECT_CUSTOMER_BY_ID = "select * from order_details where id = ?";
    public static final String INSERT_ORDER_DETAILS = "insert into order_details (customerId, amount, price) VALUE (?, ?, ?)";

    @Override
    public List<OrderDetail> findAll() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER_DETAILS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customerId");
                int amount = resultSet.getInt("amount");
                float price = resultSet.getFloat("price");
                orderDetails.add(new OrderDetail(id, customerId,amount, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    @Override
    public OrderDetail findById(int id) {
        return null;
    }

    @Override
    public boolean create(OrderDetail orderDetail) {
        Connection connection = SQLConnection.getConnection();
        int rowInserted = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_DETAILS);
            preparedStatement.setInt(1, orderDetail.getCustomerId());
            preparedStatement.setInt(2, orderDetail.getAmount());
            preparedStatement.setFloat(3, orderDetail.getPrice());
            rowInserted = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowInserted != 0;
    }

    @Override
    public boolean update(int id, OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
