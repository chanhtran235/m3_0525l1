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

@WebServlet(name = "studentController", value = "/students")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
       if (action==null){
           action ="";
       }
       switch (action){
           case "add":
               // trả về trang thêm mới
               req.getRequestDispatcher("/view/student/add.jsp").forward(req,resp);
               break;
           default:
               List<Student> studentList = studentService.findAll();
               req.setAttribute("studentList", studentList);
               req.getRequestDispatcher("/view/student/list.jsp").forward(req,resp);
               break;


       }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
