package com.asif.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteStudentServlet extends HttpServlet {
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
            dao.deleteStudent(id);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        res.sendRedirect("list");
    }
}
