package com.example.module3_test_project.controller;

import com.example.module3_test_project.model.entity.Employee;
import com.example.module3_test_project.model.service.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchEmployeeController", value = "/search")
public class SearchEmployeeController extends HttpServlet {
    private String message;

    public void init() {
        message = "";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        List <Employee> employeeList = EmployeeService.getInstance().searchByName(name);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/employee_information.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}