package com.asif.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ListStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao dao;

    public void init() {
        dao = new StudentDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            List<Student> list = dao.listAllStudents();
            req.setAttribute("students", list);
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
