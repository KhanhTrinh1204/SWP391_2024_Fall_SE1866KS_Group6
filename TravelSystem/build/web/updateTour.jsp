<%-- 
    Document   : updateTour
    Created on : Sep 21, 2024, 11:10:02 PM
    Author     : ASUS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Tour</title>
</head>
<body>
    <h1>Update Tour</h1>
    
    <c:if test="${not empty tour}">
        <form action="update" method="POST">
            <input type="hidden" name="tourId" value="${tour.tourId}">

            <label for="tourName">Tour Name:</label>
            <input type="text" id="tourName" name="tourName" value="${tour.tourName}" required><br><br>
            
            <label for="imgUrl">Image URL:</label>
            <input type="text" id="imgUrl" name="imgUrl" value="${tour.imgUrl}" required><br><br>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description" required>${tour.description}</textarea><br><br>
            
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" value="${tour.startDate}" required><br><br>
            
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" value="${tour.endDate}" required><br><br>
            
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${tour.price}" required><br><br>

            <input type="submit" value="Update Tour">
        </form>
    </c:if>

    <a href="list">Back to Tour List</a>
</body>
</html>


