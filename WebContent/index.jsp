<%@ page import="java.util.List, com.asif.servlet.Student" %>
    <%@ page contentType="text/html;charset=UTF-8" %>
        <html>

        <head>
            <title>Student List</title>
        </head>

        <body>
            <h2>Student List</h2>
            <a href="add-student.jsp">Add New</a>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Course</th>
                    <th>Actions</th>
                </tr>
                <% @SuppressWarnings("unchecked") List<Student> list = (List<Student>) request.getAttribute("students");
                        if (list != null && !list.isEmpty()) {
                        for (Student s : list) {
                        %>
                        <tr>
                            <td>
                                <%=s.getId()%>
                            </td>
                            <td>
                                <%=s.getName()%>
                            </td>
                            <td>
                                <%=s.getEmail()%>
                            </td>
                            <td>
                                <%=s.getCourse()%>
                            </td>
                            <td>
                                <a href="edit?id=<%=s.getId()%>">Edit</a> |
                                <a href="delete?id=<%=s.getId()%>">Delete</a>
                            </td>
                        </tr>
                        <% } } else { %>
                            <tr>
                                <td colspan="5">No students found.</td>
                            </tr>
                            <% } %>
            </table>
        </body>

        </html>