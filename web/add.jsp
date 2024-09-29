<%-- 
    Document: add
    Created on: May 22, 2024, 8:58:06 PM
    Author: Naoto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, java.util.ArrayList, model.vehicle"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Student</title>
    </head>
    <body>
    <center>
        <h1>Add New Student</h1>
        <div>
            <form action="add" method="post">
                Vehicle ID: <input type="text" name="id" required><br/>
                Vehicle Name: <input type="text" name="name" required><br/>
                Picture: <input type="text" name="picture" required><br/>
                Price: <input type="text" name="price" required><br/>
                Start Date: <input type="text" name="start" required><br/>
                End Date: <input type="text" name="end" required><br/>
                Description: <input type="text" name="description" required><br/>
                <input type="submit" value="Add Vehicle">
            </form>
            <% String message = (String) request.getAttribute("message"); %>
            <% if (message != null) { %>
            <p style="color: red;"><%= message %></p>
            <% } %>
        </div>
    </center>
</body>
</html>
