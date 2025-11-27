package org.example.demo_jstl.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo_jstl.entity.Student;
import org.example.demo_jstl.service.IStudentService;
import org.example.demo_jstl.service.StudentService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "homeController", value = "/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/home.jsp").forward(req,resp);
    }

}
