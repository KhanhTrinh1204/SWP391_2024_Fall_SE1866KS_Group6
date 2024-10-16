<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Staff</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        .form-control:focus {
            box-shadow: none;
            border-color: #4CAF50;
        }
        .btn-submit {
            background-color: #4CAF50;
            border: none;
            transition: background-color 0.3s;
        }
        .btn-submit:hover {
            background-color: #45a049;
        }
        .error-message {
            color: #dc3545;
            margin-top: 10px;
        }
        .success-message {
            color: #28a745;
            margin-top: 10px;
        }
        .input-group-text {
            background-color: #e9ecef;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center mb-4">Add New Staff</h2>
        
        <!-- Thông báo lỗi -->
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" role="alert">
                ${errorMessage}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/staff/add" method="POST" novalidate>
            <div class="mb-3">
                <label for="fullname" class="form-label">Full Name</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                    <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Enter full name" required>
                </div>
                <div class="invalid-feedback">
                    Please enter the full name.
                </div>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
                </div>
                <div class="invalid-feedback">
                    Please enter a valid email address. 
                </div>
            </div>

            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-phone"></i></span>
                    <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Enter 10-digit phone number" pattern="[0-9]{10}" required>
                </div>
                <div class="invalid-feedback">
                    Please enter a valid 10-digit phone number.
                </div>
            </div>

            <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-home"></i></span>
                    <input type="text" class="form-control" id="address" name="address" placeholder="Enter address" required>
                </div>
                <div class="invalid-feedback">
                    Please enter the address.
                </div>
            </div>

            <div class="mb-4">
                <label for="status" class="form-label">Status</label>
                <select class="form-select" id="status" name="status" required>
                    <option value="" disabled selected>Select status</option>
                    <option value="true">Active</option>
                    <option value="false">Inactive</option>
                </select>
                <div class="invalid-feedback">
                    Please select the status.
                </div>
            </div>

            <button type="submit" class="btn btn-submit w-100">Add Staff</button>
        </form>
        
        <!-- Thông báo thành công -->
      
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    <!-- Custom JS for form validation -->
    
</body>
</html>
