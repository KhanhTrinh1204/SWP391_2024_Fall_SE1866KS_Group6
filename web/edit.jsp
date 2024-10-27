<%-- 
    Document   : edit
    Created on : May 22, 2024, 10:15:47 PM
    Author     : Naoto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.vehicle" %>

<html>
    <head>
        <title>Edit Employee</title>
    </head>
    <body>
        <h1>Edit Student</h1>
        <%
            vehicle student = (vehicle) request.getAttribute("vehicleD");
            if (student != null) {
        %>
        <form action="edit" method="post">
            Vehicle ID: <input type="text" name="id" required><br/>
                Vehicle Name: <input type="text" name="name" required><br/>
                Picture: <input type="text" name="picture" required><br/>
                Price: <input type="text" name="price" required><br/>
                Start Date: <input type="text" name="start" required><br/>
                End Date: <input type="text" name="end" required><br/>
                Description: <input type="text" name="description" required><br/>
                <input type="submit" value="Save">
        </form>
        <% } else { %>
        <p>Employee not found.</p>
        <% } %>
    </body>
</html>
