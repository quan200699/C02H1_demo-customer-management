package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.OrderDetail;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.orderDetail.IOrderDetailService;
import com.codegym.service.orderDetail.OrderDetailService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderDetailServlet", value = "/order-details")
public class OrderDetailServlet extends HttpServlet {
    private IOrderDetailService orderDetailService = new OrderDetailService();
    private ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewForm(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderDetail> orderDetails = orderDetailService.findAll();
        request.setAttribute("orderDetails", orderDetails);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/orderDetail/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewCustomer(request, response);
                break;
        }
    }

    private void createNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/orderDetail/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        float price = Float.parseFloat(request.getParameter("price"));
        OrderDetail orderDetail = new OrderDetail(customerId, amount, price);
        boolean isInserted = orderDetailService.create(orderDetail);
        if (!isInserted) {
            request.setAttribute("message", "Xảy ra lỗi khi tạo mới!");
        } else {
            request.setAttribute("message", "Tạo thành công!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/orderDetail/create.jsp");
        dispatcher.forward(request, response);
    }
}
