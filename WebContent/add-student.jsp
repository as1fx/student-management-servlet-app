<%@ page contentType="text/html;charset=UTF-8" %>
    <html>

    <head>
        <title>Add Student</title>
    </head>

    <body>
        <h2>Add New Student</h2>
        <form action="insert" method="post">
            Name: <input type="text" name="name" required><br><br>
            Email: <input type="email" name="email" required><br><br>
            Course:<input type="text" name="course" required><br><br>
            <input type="submit" value="Save">
        </form><br>
        <a href="list">Back</a>
    </body>

    </html>