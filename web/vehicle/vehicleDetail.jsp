<%-- 
    Document   : vehicleDetail
    Created on : Oct 10, 2024, 2:21:52 AM
    Author     : ASUS
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Vehicle Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #2c3e50;
        }
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px 0;
            font-size: 18px;
            text-align: left;
        }
        table, th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            text-decoration: none;
            color: #3498db;
        }
        a:hover {
            text-decoration: underline;
        }
        .error {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Vehicle Details</h1>
    
    <!-- Hiển thị thông tin phương tiện nếu vehicle không rỗng -->
    <c:if test="${not empty vehicle}">
        <table>           
            <tr>
                <th>Vehicle Type</th>
                <td>${vehicle.vehicleType}</td>
            </tr>
            <tr>
                <th>Vehicle Name</th>
                <td>${vehicle.vehicleName}</td>
            </tr>
            <tr>
                <th>License Plate</th>
                <td>${vehicle.licensePlate}</td>
            </tr>
            <tr>
                <th>Manufacture</th>
                <td>${vehicle.manufacture}</td>
            </tr>
            <tr>
                <th>Model Year</th>
                <td>${vehicle.modelYear}</td>
            </tr>
            <tr>
                <th>Color</th>
                <td>${vehicle.color}</td>
            </tr>
            <tr>
                <th>Engine Type</th>
                <td>${vehicle.engineType}</td>
            </tr>
            <tr>
                <th>Mileage</th>
                <td>${vehicle.mileAge}</td>
            </tr>
            <tr>
                <th>Seating Capacity</th>
                <td>${vehicle.seatingCapacity}</td>
            </tr>
            <tr>
                <th>Registration Date</th>
                <td>${vehicle.registrationDate}</td>
            </tr>
            <tr>
                <th>Description</th>
                <td>${vehicle.description}</td>
            </tr>
            <tr>
                <th>Travel Agent</th>
                <td>${vehicle.agent.agentName}</td>
            </tr>
        </table>
        <br>
        <a href="<%=request.getContextPath()%>/vehicle/list">Back to Vehicles List</a>
    </c:if>

    <!-- Hiển thị thông báo lỗi nếu không tìm thấy phương tiện hoặc lỗi khác -->
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
        <br>
        <a href="vehicleslist.jsp">Back to Vehicles List</a>
    </c:if>
</body>
</html>

