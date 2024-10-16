<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Xe</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Thêm stylesheet nếu cần -->
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #4CAF50;
        }
        form {
            background-color: #f2f2f2;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], input[type="number"], input[type="date"], textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }
        a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #4CAF50;
        }
    </style>
</head>
<body>
    <h2>Thêm Xe</h2>
    <form action="${pageContext.request.contextPath}/vehicle/add" method="post">
        <h3>Thông Tin Xe</h3>
        <label for="vehicleType">Loại Xe:</label>
        <input type="text" id="vehicleType" name="vehicleType" required><br>

        <label for="vehicleName">Tên Xe:</label>
        <input type="text" id="vehicleName" name="vehicleName" required><br>

        <label for="licensePlate">Biển Số Xe:</label>
        <input type="text" id="licensePlate" name="licensePlate" required><br>

        <label for="image">Hình Ảnh:</label>
        <input type="text" id="image" name="image" required><br>

        <h3>Thông Tin Chi Tiết Xe</h3>
        <label for="manufacture">Hãng Sản Xuất:</label>
        <input type="text" id="manufacture" name="manufacture" required><br>

        <label for="modelYear">Năm Sản Xuất:</label>
        <input type="number" id="modelYear" name="modelYear" required><br>

        <label for="color">Màu Xe:</label>
        <input type="text" id="color" name="color" required><br>

        <label for="mileage">Số Km:</label>
        <input type="number" id="mileage" name="mileage"  required><br>

        <label for="seatingCapacity">Sức Chứa:</label>
        <input type="number" id="seatingCapacity" name="seatingCapacity" required><br>

        <label for="registrationDate">Ngày Đăng Ký:</label>
        <input type="date" id="registrationDate" name="registrationDate" required><br>

        <label for="description">Mô Tả:</label>
        <textarea id="description" name="description" rows="4" required></textarea><br>

        <input type="submit" value="Thêm Xe">
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/vehicle/list">Quay lại danh sách xe</a>
</body>
</html>
