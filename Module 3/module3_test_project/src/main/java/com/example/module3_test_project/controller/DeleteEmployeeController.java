package com.example.module3_test_project.controller;

import com.example.module3_test_project.model.service.EmployeeService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEmployeeController", value = "/delete")
public class DeleteEmployeeController extends HttpServlet {
    private String message;

    public void init() {
        message = "";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeService.getInstance().deleteEmployee(id);
        response.sendRedirect("/employee");
    }

    public void destroy() {
    }
}