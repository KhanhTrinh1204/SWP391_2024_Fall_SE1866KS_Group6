<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thêm Tour</title>
    </head>
    <body>
        <h1>Thêm Tour Mới</h1>

        <c:if test="${not empty errorMessage}">
            <div style="color: red;">
                ${errorMessage}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/tour/add" method="post">
            <label for="tourName">Tên Tour:</label>
            <input type="text" id="tourName" name="tourName" required><br><br>

            <label for="price">Giá:</label>
            <input type="number" id="price" name="price" step="0.01" required><br><br>

            <label for="description">Mô Tả:</label>
            <textarea id="description" name="description" required></textarea><br><br>

            <label for="startDate">Ngày Bắt Đầu:</label>
            <input type="date" id="startDate" name="startDate" required><br><br>

            <label for="endDate">Ngày Kết Thúc:</label>
            <input type="date" id="endDate" name="endDate" required><br><br>

            <label for="agentId">Đại Lý:</label>
            <select id="agentId" name="agentId" required>
                <option value="">Chọn Đại Lý</option>
                <c:forEach var="agent" items="${agents}">
                    <option value="${agent.agentId}">${agent.agentName}</option>
                </c:forEach>
            </select><br><br>

            <label for="vehicleId">Phương Tiện:</label>
            <select id="vehicleId" name="vehicleId" required>
                <option value="">Chọn Phương Tiện</option>
                <c:forEach var="vehicle" items="${vehicles}">
                    <option value="${vehicle.vehicleId}">${vehicle.vehicleName}</option>
                </c:forEach>
            </select><br><br>

            <label for="restaurantId">Nhà Hàng:</label>
            <select id="restaurantId" name="restaurantId" required>
                <option value="">Chọn Nhà Hàng</option>
                <c:forEach var="restaurant" items="${restaurants}">
                    <option value="${restaurant.restaurantId}">${restaurant.restaurantName}</option>
                </c:forEach>
            </select><br><br>

            <label for="image">Hình Ảnh:</label>
            <input type="file" class="form-control" id="image" name="image" accept="image/*" required>
            <input type="submit" value="Thêm Tour">
        </form>

        <br>
        <a href="${pageContext.request.contextPath}/tour/list">Trở về danh sách Tour</a>
    </body>
</html>