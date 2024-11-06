<%-- 
    Document   : listTour
    Created on : Oct 20, 2024, 7:05:39 PM
    Author     : ASUS
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Management Tour</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
</head>
<body onload="showAlerts()">
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
            <li><a href="<%=request.getContextPath()%>/vehicle/list"><i class="material-icons">date_range</i><span>Manage Vehicle</span></a></li>
            <li><a href="<%=request.getContextPath()%>/restaurant/list"><i class="material-icons">library_books</i><span>Manage Restaurant</span></a></li>
            <li><a href="<%=request.getContextPath()%>/feedback/list"><i class="material-icons">feedback</i><span>Manage Feedback</span></a></li>
            <li><a href="<%=request.getContextPath()%>/tour/list"><i class="material-icons">tour</i><span>Manage Tour</span></a></li>
            <li><a href="<%=request.getContextPath()%>/hotel/list"><i class="material-icons">hotel</i><span>Manage Hotel</span></a></li>
            <li><a href="<%=request.getContextPath()%>/booking/list"><i class="material-icons">tour</i><span>Manage Booking Tour</span></a></li>
        </ul>
    </nav>

    <main id="content" class="p-4">
        <div class="top-navbar" style="height: 150px;">
            <div class="xp-topbar" style="float: right;">
                <div class="row">
                    <div>
                        <div class="xp-profilebar">
                            <nav class="navbar p-0">
                                <ul class="nav navbar-nav">
                                    <li class="nav-item">
                                        <a class="profile-button" onclick="toggleDropdown()">
                                            <img src="${pageContext.request.contextPath}/img/user.jpg" style="width:40px; border-radius:50%;" alt="User"/>
                                        </a>
                                        <div class="dropdown" id="dropdown" style="display: none;">
                                            <a href="${pageContext.request.contextPath}/viewProfile" style="color: white;">View Profile</a>
                                            <a href="${pageContext.request.contextPath}/LogoutControl" style="color: white;">Logout</a>
                                        </div>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

            <div class="xp-breadcrumbbar text-center">
                <h4 class="page-title">Manage Staff</h4>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Staff Add</a></li>
                </ol>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/staff/add" method="POST" validate onsubmit="return validateForm()">
            <div class="mb-3">
                  <label for="user" class="form-label">User Name(*)</label>
                <div class="input-group">
                    <span class="input-group-text"></span>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Enter user name" required>
                </div>
                <div class="invalid-feedback">Please enter the User name.</div>
                
                <label for="fullname" class="form-label">Full Name(*)</label>
                <div class="input-group">
                    <span class="input-group-text"></span>
                    <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Enter full name" required>
                </div>
                <div class="invalid-feedback">Please enter the full name.</div>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email(*)</label>
                <div class="input-group">
                    <span class="input-group-text"></span>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
                </div>
                <div class="invalid-feedback">Please enter a valid email address.</div>
            </div>

            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number(*)</label>
                <div class="input-group">
                    <span class="input-group-text"></span>
                    <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Enter 10-digit phone number" pattern="[0-9]{10}" required>
                </div>
                <div class="invalid-feedback">Please enter a valid 10-digit phone number.</div>
            </div>

            <div class="mb-3">
                <label for="address" class="form-label">Address(*)</label>
                <div class="input-group">
                    <span class="input-group-text"></span>
                    <input type="text" class="form-control" id="address" name="address" placeholder="Enter address" required>
                </div>
                <div class="invalid-feedback">Please enter the address.</div>
            </div>


            <div class="mb-4">
                <label for="status" class="form-label">Role</label>
                <select class="form-select" id="role" name="role" required>
                    <option value="" disabled selected>Select role</option>
                    <option value="1">Customer</option>
                    <option value="2">Tourist</option>
                     <option value="3">Admin</option>
                </select>
                <div class="invalid-feedback">Please select the role.</div>
            </div>
            
            <button type="submit" class="btn btn-submit w-100">Add User</button>
        </form>
    </main>
</div>

<script>
    function toggleDropdown() {
        const dropdown = document.getElementById("dropdown");
        dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
    }

    window.onclick = function(event) {
        if (!event.target.matches('.profile-button')) {
            const dropdown = document.getElementById("dropdown");
            if (dropdown.style.display === "block") {
                dropdown.style.display = "none";
            }
        }
    };
      function validateForm() {
        // Define required fields with their error messages
        const fields = [
            { id: "fullName", message: "Please enter the full name." },
            { id: "username", message: "Please enter the username." },
            { id: "email", message: "Please enter a valid email address." },
            { id: "phoneNumber", message: "Please enter the phone number." },
            { id: "address", message: "Please enter the address." },
            { id: "status", message: "Please select the status." },
            { id: "role", message: "Please select the role." }
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
</body>
</html>
