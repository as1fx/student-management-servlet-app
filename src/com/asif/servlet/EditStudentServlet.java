package com.asif.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class EditStudentServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private StudentDao dao;

    public void init() {
        dao = new StudentDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Student s = dao.getStudent(id);
            req.setAttribute("student", s);
            req.getRequestDispatcher("edit-student.jsp").forward(req, res);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
