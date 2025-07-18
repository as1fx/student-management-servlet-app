package com.asif.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateStudentServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private StudentDao dao;

    public void init() {
        dao = new StudentDao();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Student s = new Student(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("email"),
                req.getParameter("course"));
        try {
            dao.updateStudent(s);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        res.sendRedirect("list");
    }
}
