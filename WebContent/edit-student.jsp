<%@ page import="com.asif.servlet.Student" %>
    <%@ page contentType="text/html;charset=UTF-8" %>
        <% Student s=(Student) request.getAttribute("student"); %>
            <html>

            <head>
                <title>Edit Student</title>
            </head>

            <body>
                <h2>Edit Student</h2>
                <form action="update" method="post">
                    <input type="hidden" name="id" value="<%= s.getId() %>">
                    Name: <input type="text" name="name" value="<%= s.getName()  %>" required><br><br>
                    Email: <input type="email" name="email" value="<%= s.getEmail() %>" required><br><br>
                    Course:<input type="text" name="course" value="<%= s.getCourse()%>" required><br><br>
                    <input type="submit" value="Update">
                </form><br>
                <a href="list">Back</a>
            </body>

            </html>