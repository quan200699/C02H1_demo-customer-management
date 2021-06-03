package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.customer.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewCustomerForm(request, response);
                break;
            case "edit":
                showEditCustomerForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        if (customer == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error-404.jsp");
            dispatcher.forward(request, response);
        }
        customerService.delete(id);
        response.sendRedirect("/customers");
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/edit.jsp");
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("q");
        List<Customer> customers;
        if (query == null || query.equals("")) {
            customers = customerService.findAll();
        } else {
            customers = customerService.findAllCustomerByAddress(query);
        }
        String sort = request.getParameter("sort");
        if (sort != null) {
            customers = customerService.sortAllCustomer();
        }
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
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
            case "edit":
                editCustomer(request, response);
                break;
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, address);
        customerService.update(id, customer);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/edit.jsp");
        dispatcher.forward(request, response);
    }


    private void createNewCustomerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Customer customer = new Customer(name, address);
        boolean isInserted = customerService.create(customer);
        if (!isInserted) {
            request.setAttribute("message","Xảy ra lỗi khi tạo mới!");
        }else {
            request.setAttribute("message", "Tạo thành công!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
        dispatcher.forward(request, response);
    }
}
