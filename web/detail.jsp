<%-- 
    Document   : detail
    Created on : May 26, 2024, 10:30:18 PM
    Author     : Admin
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
        <h1>Detail vehicle</h1>
        <%
            vehicle vehicle = (vehicle) request.getAttribute("studentD");
            if (vehicle != null) {
        %>
            RollNo: <%= vehicle.getRollNo() %><br/>
            Name: <%= vehicle.getName() %><br/>
            Mark: <%= vehicle.getMark() %><br/>
            <% } else { %>
        <p>Employee not found.</p>
        <% } %>
    </body>
</html>
