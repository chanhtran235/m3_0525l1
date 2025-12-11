package org.example.demo_jstl.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo_jstl.dto.StudentDto;
import org.example.demo_jstl.entity.Student;
import org.example.demo_jstl.service.ClassService;
import org.example.demo_jstl.service.IClassService;
import org.example.demo_jstl.service.IStudentService;
import org.example.demo_jstl.service.StudentService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentController", value = "/students")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();
    private IClassService classService = new ClassService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
       if (action==null){
           action ="";
       }
       switch (action){
           case "add":
               // trả về trang thêm mới
               showFormAdd(req,resp);
               break;
           case "search":
               // trả về trang thêm mới
               search(req,resp);
               break;
           default:
               showList(req,resp);
               break;
       }

    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
        String searchName = req.getParameter("searchName");
        String classId = req.getParameter("classId");
        List<StudentDto> studentList =  studentService.search(searchName,classId);
        req.setAttribute("studentList", studentList);
        req.setAttribute("classList",classService.findAll());
        req.setAttribute("searchName",searchName);
        try {
            req.getRequestDispatcher("/view/student/list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // trả về danh lớp học
            req.setAttribute("classList",classService.findAll());
            req.getRequestDispatcher("/view/student/add.jsp").forward(req,resp);

        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        List<StudentDto> studentList = studentService.findAll();
        req.setAttribute("studentList", studentList);
        req.setAttribute("classList",classService.findAll());
        try {
            req.getRequestDispatcher("/view/student/list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                // lấy dữ liệu thêm và db
                save(req,resp);
                break;
            case "delete":
                // lấy dữ liệu thêm và db
                deleteById(req,resp);
                break;
            default:
        }
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        boolean isSuccess = studentService.deleteById(deleteId);
        String mess = isSuccess? "Xoá thanh cong":"Xoá that bai";
        try {
            resp.sendRedirect("/students?mess="+ mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        float score = Float.parseFloat(req.getParameter("score"));
        int classId = Integer.parseInt(req.getParameter("classId"));
        Student student = new Student(name,gender,score,classId);
        boolean isSuccess = studentService.add(student);
        String mess = isSuccess? "Them moi thanh cong":"Them moi that bai";
        try {
            resp.sendRedirect("/students?mess="+ mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
