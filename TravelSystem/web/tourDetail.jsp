<%-- 
    Document   : tourDetail
    Created on : Sep 21, 2024, 9:33:36 PM
    Author     : ASUS
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tour Details</title>
</head>
<body>
<h2>Tour Details</h2>

<c:if test="${not empty tour}">
    <p><strong>Tour Name:</strong> ${tour.tourName}</p>
    <p><strong>Image URL:</strong> <img src="${tour.imgUrl}" alt="${tour.tourName}" /></p>
    <p><strong>Start Day:</strong> ${tour.startDate}</p>
    <p><strong>End Day:</strong> ${tour.endDate}</p>
    <p><strong>Description:</strong> ${tour.description}</p>
    <p><strong>Price:</strong> ${tour.price}</p>
</c:if>
    <a href="update?id=${tour.tourId}"> Update Tour</a>
<a href="list">Back To Tour List</a>
</body>
</html>


