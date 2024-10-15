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
        <p><strong>Description:</strong> ${tour.description}</p>
        <p><strong>Start Date:</strong> ${tour.startDate}</p>
        <p><strong>End Date:</strong> ${tour.endDate}</p>
        <p><strong>Price:</strong> ${tour.price}</p>
        <p><strong>Category:</strong> ${tour.categoryTour.categoryName}</p>
        <p><strong>Vehicle:</strong> ${tour.vehicle.vehicleName}</p>
        <p><strong>Restaurant:</strong> ${tour.restaurant.restaurantName}</p>
        <p><strong>Status:</strong> <c:choose>
                <c:when test="${tour.active}">Active</c:when>
                <c:otherwise>Inactive</c:otherwise>
            </c:choose>
        </p>
    </c:if>
    <c:if test="${empty tour}">
        <p>No tour details found.</p>
    </c:if>
        <a href="update?id=${tour.tourId}"> Update Tour</a> &nbsp;&nbsp;
<a href="list">Back To Tour List</a>
</body>
</html>


