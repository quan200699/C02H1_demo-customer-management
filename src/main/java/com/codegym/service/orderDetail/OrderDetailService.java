package com.codegym.service.orderDetail;

import com.codegym.dao.orderDetail.IOrderDetailDAO;
import com.codegym.dao.orderDetail.OrderDetailDAO;
import com.codegym.model.Customer;
import com.codegym.model.OrderDetail;

import java.util.List;

public class OrderDetailService implements IOrderDetailService {
    private IOrderDetailDAO orderDetailDAO = new OrderDetailDAO();

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailDAO.findAll();
    }

    @Override
    public OrderDetail findById(int id) {
        return orderDetailDAO.findById(id);
    }


    @Override
    public boolean create(OrderDetail orderDetail) {
        return orderDetailDAO.create(orderDetail);
    }

    @Override
    public boolean update(int id, OrderDetail orderDetail) {
        return orderDetailDAO.update(id,orderDetail);
    }

    @Override
    public boolean delete(int id) {
        return orderDetailDAO.delete(id);
    }

}
