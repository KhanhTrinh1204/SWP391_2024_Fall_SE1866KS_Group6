<%-- 
    Document   : updateHotel
    Created on : Sep 25, 2024, 12:36:31 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Update</h1>
         <c:if test="${not empty hotel}">
        <form action="update" method="POST">
            <input type="hidden" name="hotelId" value="${hotel.hotelId}">

            <label for="hotelName">Hotel Name:</label>
            <input type="text" id="hotelName" name="hotelName" value="${hotel.hotelName}" required><br><br>
            
            <label for="imgUrl">Image URL:</label>
            <input type="text" id="imgUrl" name="imgUrl" value="${hotel.imgUrl}" required><br><br>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description" required>${hotel.description}</textarea><br><br>
            
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" value="${hotel.startDate}" required><br><br>
            
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" value="${hotel.endDate}" required><br><br>
            
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${hotel.price}" required><br><br>

            <input type="submit" value="Update Hotel">
        </form>
    </c:if>

    <a href="list">Back to Hotel List</a>
    </body>
</html>
