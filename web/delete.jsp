<%-- 
    Document   : delete
    Created on : May 22, 2024, 10:18:12 PM
    Author     : Naoto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.vehicle" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete Student</h1>
        <%
            vehicle vehicle = (vehicle) request.getAttribute("studentD");
            if (vehicle != null) {
        %>
        <p>Are you sure you want to delete the following student?</p>
        <ul>
            <li>ID: <%= vehicle.getVehicleId() %></li>
            <li>Name: <%= vehicle.getVehicleName() %></li>
        </ul>
        <form action="delete" method="post">
            <input type="hidden" name="id" value="<%= vehicle.getVehicleId() %>">
            <input type="submit" value="Delete">    <a href="listVehicle.jsp"><input type="button" value="No"></a>
        </form>
        <% } else { %>
        <p>Employee not found.</p>
        <% } %>
    </body>
</html>
