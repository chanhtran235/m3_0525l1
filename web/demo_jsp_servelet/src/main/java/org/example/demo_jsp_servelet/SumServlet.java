package org.example.demo_jsp_servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SumServlet", value = "/sum")

public class SumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          // trả ve một form
        req.getRequestDispatcher("/view/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // lấy giá trị n1 va n2
        int number1 = Integer.parseInt(req.getParameter("n1"));
        int number2 = Integer.parseInt(req.getParameter("n2"));
        req.setAttribute("sum", number1+ number2);
        req.getRequestDispatcher("/view/form.jsp").forward(req,resp);
    }
}
