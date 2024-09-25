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
                <th>Action</th>
            </tr>
             <c:forEach items="${hotel}" var="h">
                <tr>
                    <td>${h.hotelId}</td>
                    <td>${h.hotelName}</td>
                    <td>${h.hotelDescription}</td>
                    <td>
                        <a href="detail?id=${h.hoteld}"> View Details</a> &nbsp;
                        <a href="#" onclick="deleteHotel('${h.hotelId}')"> Delete</a>
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
