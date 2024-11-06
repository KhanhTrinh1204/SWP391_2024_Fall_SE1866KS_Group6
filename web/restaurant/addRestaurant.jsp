<%-- 
    Document   : addRestaurant
    Created on : Oct 13, 2024, 12:31:54 AM
    Author     : ASUS
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Management restaurant</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
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
<body >
        <div class="wrapper">
     
          <nav id="sidebar">
            <div class="sidebar-header">
                <h3><img src="${pageContext.request.contextPath}/img/logo.png" class="img-fluid" alt="Logo"/><span>Travel System</span></h3>
            </div>
            <ul class="list-unstyled components">
                 <li class="active">
                    <a href="<%=request.getContextPath()%>/staff/list" class="dashboard">
                        <i class="material-icons">dashboard</i>
                        <span>Manage User</span>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/vehicle/list">
                        <i class="material-icons">date_range</i>
                        <span>Manage Vehicle</span>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/restaurant/list">
                        <i class="material-icons">library_books</i>
                        <span>Manage Restaurant</span>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/feedback/list">
                        <i class="material-icons">feedback</i>
                        <span>Manage feedback</span>
                    </a>
                </li>
                
                <li>
                    <a href="<%=request.getContextPath()%>/tour/list">
                        <i class="material-icons">tour</i>
                        <span>Manage tour</span>
                    </a>
                </li>
                 <li>
                    <a href="<%=request.getContextPath()%>/hotel/list">
                        <i class="material-icons">hotel</i>
                        <span>Manage hotel</span>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/booking/list">
                        <i class="material-icons">tour</i>
                        <span>Manage booking tour</span>
                    </a>
                </li>
            </ul>
        </nav>


            <main id="content" class="p-4">
                  <!-- Top Navbar -->
                  <div class="top-navbar" style="height: 150px;" >
                <div class="xp-topbar" style="float: right;">
    <div class="row">
        <div>
            <div class="xp-profilebar">
                <nav class="navbar p-0">
                    <ul class="nav navbar-nav" >
                        <li class="nav-item" >
                            <a class="profile-button" onclick="toggleDropdown()">
                                <img  src="${pageContext.request.contextPath}/img/user.jpg" style="width:40px; border-radius:50%;" alt="User"/>
                            </a>
                            <div class="dropdown" id="dropdown" style ="display: none;">
                              <a href="${pageContext.request.contextPath}/viewProfile" style="color: white;">View Profile</a>
                               <a href="${pageContext.request.contextPath}/LogoutControl" style="color: white;"> Logout</a>
                              </div>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
                                              
                <div class="xp-breadcrumbbar text-center">
                    <h4 class="page-title">Manage restaurant</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Restaurant List</a></li>
                    </ol>
                </div>
            </div>
                        <br/>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" role="alert">
                ${errorMessage}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/restaurant/edit" method="POST"  onsubmit="return validateForm()">
    <div class="mb-3">
        <label for="restaurantName" class="form-label">Restaurant Name(*)</label>
        <input type="text" class="form-control" id="restaurantName" name="restaurantName" placeholder="Enter restaurant name" required>
        <div class="invalid-feedback">
            Please enter the restaurant name.
        </div>
    </div>

    <div class="mb-3">
        <label for="location" class="form-label">Location(*)</label>
        <input type="text" class="form-control" id="location" name="location" placeholder="Enter location" required>
        <div class="invalid-feedback">
            Please enter the location.
        </div>
    </div>

    <div class="mb-3">
        <label for="description" class="form-label">Description(*)</label>
        <textarea class="form-control" id="description" name="description" rows="3" placeholder="Enter description" required></textarea>
        <div class="invalid-feedback">
            Please enter the description.
        </div>
    </div>

    <div class="mb-3">
        <label for="phoneNumber" class="form-label">Phone Number(*)</label>
        <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Enter phone number" required>
        <div class="invalid-feedback">
            Please enter the phone number.
        </div>
    </div>

    <div class="mb-3">
        <label for="email" class="form-label">Email(*)</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
        <div class="invalid-feedback">
            Please enter a valid email address.
        </div>
    </div>

    <div class="mb-3">
        <label for="category" class="form-label">Category(*)</label>
        <input type="text" class="form-control" id="category" name="category" placeholder="Enter category" required>
        <div class="invalid-feedback">
            Please enter the category.
        </div>
    </div>

    <div class="mb-4">
        <label for="status" class="form-label">Status(*)</label>
        <select class="form-select" id="status" name="status" required>
            <option value="" disabled selected>Select status</option>
            <option value="true">Active</option>
            <option value="false">Inactive</option>
        </select>
        <div class="invalid-feedback">
            Please select the status.
        </div>
    </div>

    <div class="mb-3">
        <label for="image" class="form-label">Image(*)</label>
        <input type="text" class="form-control" id="image" name="image" required>
        <div class="invalid-feedback">
            Please enter the image URL.
        </div>
    </div>

    <button type="submit" class="btn btn-submit w-100">Add Restaurant</button>
</form>

<script>
    function validateForm() {
        // Get all required fields
        const fields = [
            { id: "restaurantName", message: "Please enter the restaurant name." },
            { id: "location", message: "Please enter the location." },
            { id: "description", message: "Please enter the description." },
            { id: "phoneNumber", message: "Please enter the phone number." },
            { id: "email", message: "Please enter a valid email address." },
            { id: "category", message: "Please enter the category." },
            { id: "status", message: "Please select the status." },
            { id: "image", message: "Please enter the image URL." }
        ];

        // Loop through each field to check if it's empty or contains only whitespace
        for (let field of fields) {
            const element = document.getElementById(field.id);
            if (element && element.value.trim() === "") {
                alert(field.message);
                element.focus();
                return false; // Prevent form submission
            }
        }

        return true; // Allow form submission if all fields are valid
    }
</script>

        
        <!-- Thông báo thành công -->
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    <!-- Add styles for modal pop-up -->

    <!-- Custom JS for form validation -->
</body>
</html>

