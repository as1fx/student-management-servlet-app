package com.asif.servlet;

import java.sql.*;
import java.util.*;

public class StudentDao {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/studentdb";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "root";

    private static final String INSERT = "INSERT INTO students (name,email,course) VALUES (?,?,?)";
    private static final String SELECT_ALL = "SELECT * FROM students";
    private static final String SELECT_BYID = "SELECT * FROM students WHERE id=?";
    private static final String UPDATE_SQL = "UPDATE students SET name=?,email=?,course=? WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM students WHERE id=?";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertStudent(Student s) throws SQLException {
        try (Connection c = getConnection(); PreparedStatement st = c.prepareStatement(INSERT)) {
            st.setString(1, s.getName());
            st.setString(2, s.getEmail());
            st.setString(3, s.getCourse());
            st.executeUpdate();
        }
    }

    public List<Student> listAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        try (Connection c = getConnection();
                PreparedStatement st = c.prepareStatement(SELECT_ALL);
                ResultSet rs = st.executeQuery()) {
            while (rs.next())
                list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                        rs.getString("course")));
        }
        return list;
    }

    public Student getStudent(int id) throws SQLException {
        Student s = null;
        try (Connection c = getConnection(); PreparedStatement st = c.prepareStatement(SELECT_BYID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next())
                s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("course"));
        }
        return s;
    }

    public void updateStudent(Student s) throws SQLException {
        try (Connection c = getConnection(); PreparedStatement st = c.prepareStatement(UPDATE_SQL)) {
            st.setString(1, s.getName());
            st.setString(2, s.getEmail());
            st.setString(3, s.getCourse());
            st.setInt(4, s.getId());
            st.executeUpdate();
        }
    }

    public void deleteStudent(int id) throws SQLException {
        try (Connection c = getConnection(); PreparedStatement st = c.prepareStatement(DELETE_SQL)) {
            st.setInt(1, id);
            st.executeUpdate();
        }
    }
}
