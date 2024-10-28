<%-- 
    Document   : tourDetail
    Created on : Oct 22, 2024, 3:53:36 PM
    Author     : ASUS
--%>

<%-- 
    Document   : tourDetail
    Created on : Oct 22, 2024, 2:21:52 AM
    Author     : ASUS
--%>

<%-- 
    Document   : tourDetail
    Created on : Oct 22, 2024, 2:21:52 AM
    Author     : ASUS
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tour Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #2c3e50;
        }
        table {
            width: 60%;
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
        .tour-image {
            max-width: 400px;
            height: auto;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <h1>Tour Details</h1>
    
    <!-- Hiển thị thông tin tour nếu tour không rỗng -->
    <c:if test="${not empty tour}">
        <!-- Hiển thị hình ảnh của tour -->
        <c:if test="${not empty tour.image}">
            <img src="${tour.image}" alt="Tour Image" class="tour-image" />
        </c:if>

        <table>
            <tr>
                <th>Tour Name</th>
                <td>${tour.tourName}</td>
            </tr>
            <tr>
                <th>Price</th>
                <td>${tour.price} USD</td>
            </tr>
            <tr>
                <th>Description</th>
                <td>${tour.description}</td>
            </tr>
            <tr>
                <th>Start Date</th>
                <td>${tour.startDate}</td>
            </tr>
            <tr>
                <th>End Date</th>
                <td>${tour.endDate}</td>
            </tr>
            <tr>
                <th>Travel Agent</th>
                <td>${tour.agent.agentName}</td>
            </tr>
        </table>

        <h2>Vehicles</h2>
        <c:if test="${not empty tour.vechicle}">
            <table>
                <thead>
                    <tr>
                        <th>Vehicle Name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="vehicle" items="${tour.vechicle}">
                        <tr>
                            <td>${vehicle.vehicleName}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty tour.vechicle}">
            <p>No vehicles available for this tour.</p>
        </c:if>

        <h2>Restaurants</h2>
        <c:if test="${not empty tour.restaurant}">
            <table>
                <thead>
                    <tr>
                        <th>Restaurant Name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="restaurant" items="${tour.restaurant}">
                        <tr>
                            <td>${restaurant.restaurantName}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty tour.restaurant}">
            <p>No restaurants available for this tour.</p>
        </c:if>

        <br>
        <a href="<%=request.getContextPath()%>/tour/list">Back to Tour List</a>
    </c:if>

    <!-- Hiển thị thông báo lỗi nếu không tìm thấy tour hoặc lỗi khác -->
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
        <br>
        <a href="tourlist.jsp">Back to Tour List</a>
    </c:if>
</body>
</html>
