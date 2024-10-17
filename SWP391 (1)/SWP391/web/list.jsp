<%-- 
    Document   : list
    Created on : Sep 24, 2024, 10:49:48 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>List of Hotel</h1>
        <h3><a href="add">Add Hotel</a></h3>
        <table border="1px" width 40%>
            <tr>
                <th>Hotel ID</th>
                <th>Hotel Name</th>
                <th>Hotel Description</th>
                <th>Action</th>
            </tr>
             <c:forEach items="${data}" var="h">
                <tr>
                    <td>${h.hotelId}</td>
                    <td>${h.hotelName}</td>
                    <td>${h.description}</td>
                    <td>
                        <a href="detail?id=${h.hotelId}"> View Details</a> &nbsp;
                        <a href="del?id=${h.hotelId}"> Delete</a>
                        <a href="update?id=${h.hotelId}"> Update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
  
            <c:if test="${empty hotel}">
                     <p>No hotel available.</p>
            </c:if> 
    </center>
    </body>
</html>
