<%-- 
    Document   : hotelDetail
    Created on : Sep 25, 2024, 12:36:17 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Detail</title>
    </head>
    <body>
        <h1>Hotel Detail</h1>
        <c:if test="${not empty hotel}">
    <p><strong>Hotel Name:</strong> ${hotel.hotelName}</p>
    <p><strong>Image URL:</strong> <img src="${hotel.imgUrl}" alt="${hotel.hotelName}" /></p>
    <p><strong>Start Day:</strong> ${hotel.startDate}</p>
    <p><strong>End Day:</strong> ${hotel.endDate}</p>
    <p><strong>Description:</strong> ${hotel.description}</p>
    <p><strong>Price:</strong> ${hotel.price}</p>
</c:if>
    <a href="update?id=${hotel.hotelId}"> Update Hotel</a>
<a href="list">Back To Hotel List</a>
    </body>
</html>
