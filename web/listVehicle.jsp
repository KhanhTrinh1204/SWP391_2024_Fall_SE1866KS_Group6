<%-- 
    Document   : Student
    Created on : 31 thg 5, 2024, 14:16:02
    Author     : use
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.vehicle" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Student</title>
    </head>
    <body>
    <center>
        <br>
        <br>
        <br/>
        <h1>List Vehicle</h1>
        <a href="add.jsp">New Vehicle</a>
        <br/>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Picture</th>
                <th>Price</th>
                <th>Detail</th>
                <th>Options</th>
            </tr>
            <c:forEach items="${sessionScope.list}" var="s">
                <tr>
                    <td>${s.getVehicleId}</td>
                    <td>${s.getVehicle}</td>
                    <td>${s.getImgURL}</td>
                    <td>${s.getPrice}</td>
                    <td><a href="detail.jsp?Id=${s.getVehicleId}">Detail</a></td>
                    <td><a href="edit.jsp?Id=${s.getVehicleId}">Edit</a><a href="delete.jsp?Id=${s.getVehicleId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
    </center>

</body>
</html>
