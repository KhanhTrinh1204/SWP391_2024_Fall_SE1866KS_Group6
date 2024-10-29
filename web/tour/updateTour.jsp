<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Tour</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"], input[type="number"], input[type="date"], textarea, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1 style="text-align:center;">Update Tour</h1>

    <form action="${pageContext.request.contextPath}/tour/update" method="post" enctype="multipart/form-data">
        
        <!-- Nếu có lỗi cập nhật, hiển thị -->
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>

        <!-- Tên tour -->
        <label for="tourName">Tour Name:</label>
        <input type="text" id="tourName" name="tourName" value="${tour.tourName}" required>

        <!-- Giá tour -->
        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" name="price" value="${tour.price}" required>

        <!-- Mô tả tour -->
        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4">${tour.description}</textarea>

        <!-- Ngày bắt đầu -->
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" value="${tour.startDate}" required>

        <!-- Ngày kết thúc -->
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" value="${tour.endDate}" required>

        <!-- Đại lý du lịch -->
        <label for="agentId">Travel Agent:</label>
        <select id="agentId" name="agentId" required>
            <c:forEach var="agent" items="${agents}">
                <option value="${agent.agentId}" ${tour.agent.agentId == agent.agentId ? 'selected' : ''}>${agent.agentName}</option>
            </c:forEach>
        </select>

        <!-- Phương tiện -->
        <label for="vehicleId">Vehicle:</label>
        <select id="vehicleId" name="vehicleId" required>
            <c:forEach var="vehicle" items="${vehicles}">
                <option value="${vehicle.vehicleId}" ${tour.vechicle[0].vehicleId == vehicle.vehicleId ? 'selected' : ''}>${vehicle.vehicleName}</option>
            </c:forEach>
        </select>

        <!-- Nhà hàng -->
        <label for="restaurantId">Restaurant:</label>
        <select id="restaurantId" name="restaurantId" required>
            <c:forEach var="restaurant" items="${restaurants}">
                <option value="${restaurant.restaurantId}" ${tour.restaurant[0].restaurantId == restaurant.restaurantId ? 'selected' : ''}>${restaurant.restaurantName}</option>
            </c:forEach>
        </select>

        <!-- Hình ảnh -->
        <label for="image">Tour Image:</label>
        <input type="file" id="image" name="image">
        <!-- Hiển thị ảnh hiện tại -->
        <c:if test="${not empty tour.image}">
            <img src="${pageContext.request.contextPath}/img/${tour.image}" alt="Tour Image" width="100px">
            <input type="hidden" name="existingImage" value="${tour.image}">
        </c:if>

        <!-- Nút submit -->
        <input type="submit" value="Update Tour">
    </form>
</body>
</html>
