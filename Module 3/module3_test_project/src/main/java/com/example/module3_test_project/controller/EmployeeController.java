package com.example.module3_test_project.controller;

import com.example.module3_test_project.model.dao.DepartmentDAO;
import com.example.module3_test_project.model.dao.EmployeeDAO;
import com.example.module3_test_project.model.entity.Department;
import com.example.module3_test_project.model.entity.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Employee", urlPatterns = {"/employee"})
public class EmployeeController extends HttpServlet {
    private String message;

    public void init() {
        message = "";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = "";
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getParameter("a") != null) {
            a = request.getParameter("a");
        }
        switch (a) {
            case "":
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                List <Employee> employeeList = EmployeeDAO.getAll();
                request.setAttribute("employeeList", employeeList);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/employee_information.jsp");
                try {
                    requestDispatcher.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "add":
                List <Department> departmentList = DepartmentDAO.getAll();
                request.setAttribute("departmentList", departmentList);
                RequestDispatcher requestDispatcher1 = getServletContext().getRequestDispatcher("/WEB-INF/view/add_employee.jsp");
                try {
                    requestDispatcher1.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                List <Department> departmentList1 = DepartmentDAO.getAll();
                request.setAttribute("departmentList", departmentList1);
                Employee employee = EmployeeDAO.getById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("employee", employee);
                RequestDispatcher requestDispatcher2 = getServletContext().getRequestDispatcher("/WEB-INF/view/edit_employee.jsp");
                try {
                    requestDispatcher2.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                RequestDispatcher requestDispatcher3 = getServletContext().getRequestDispatcher("/delete");
                try {
                    requestDispatcher3.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "search":
                RequestDispatcher requestDispatcher4 = getServletContext().getRequestDispatcher("/search");
                try {
                    requestDispatcher4.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
        }

    }

    public void destroy() {
    }
}