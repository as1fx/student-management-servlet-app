package com.asif.servlet;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;

    public Student() {
    }

    public Student(int id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String c) {
        this.course = c;
    }
}
