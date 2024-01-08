package com.example.module3_test_project.controller;

import com.example.module3_test_project.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditEmployeeController", urlPatterns = {"/edit"})
public class EditEmployeeController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String department = request.getParameter("department");
        EmployeeService.getInstance().editEmployee(id, name, email, address, phoneNumber, salary, department);
        response.sendRedirect("/employee");
    }

    public void destroy() {
    }
}