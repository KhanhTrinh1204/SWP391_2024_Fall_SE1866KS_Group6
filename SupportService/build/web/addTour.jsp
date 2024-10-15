<%-- 
    Document   : addTour
    Created on : Sep 21, 2024, 7:33:28 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add New Tour</h1>
       <form action="add" method="POST">
            <label for="tourName">Tour Name:</label>
            <input type="text" id="tourName" name="tourName" required><br><br>
            
            <label for="imgUrl">Image URL:</label>
            <input type="text" id="imgUrl" name="imgUrl" required><br><br>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description" required></textarea><br><br>
            
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" required><br><br>
            
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" required><br><br>
            
            <label for="travelAgentId">Travel Agent ID:</label>
            <input type="number" id="travelAgentId" name="travelAgentId" required><br><br>
            
            <label for="categoryId">Category ID:</label>
            <input type="number" id="categoryId" name="categoryId" required><br><br>
            
            <label for="active">Active:</label>
            <input type="checkbox" id="active" name="active"><br><br>
            
            <label for="price">Price:</label>
            <input type="number" step="0.01" id="price" name="price" required><br><br>

            <input type="submit" value="Add Tour">
        </form>
    </body>
</html>
