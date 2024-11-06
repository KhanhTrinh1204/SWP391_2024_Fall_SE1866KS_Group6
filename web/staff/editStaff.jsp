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
                    <li class="breadcrumb-item"><a href="#">Staff Edit</a></li>
                </ol>
            </div>
        </div>

                <form action="${pageContext.request.contextPath}/staff/edit" method="POST">

                    <div class="form-group">
                        <label for="fullName">Full Name</label>
                        <input type="text" class="form-control" id="fullName" name="fullName" value="${staff.fullName}" required>
                    </div>
                     
                    <div class="form-group">
                        <label for="fullName">User Name</label>
                        <input type="text" class="form-control" id="username" name="username" value="${staff.userName}" required disabled="true">
                    </div>
                    
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="${staff.email}" required hidden>
                    </div>

                    <div class="form-group">
                        <label for="phoneNumber">Phone Number</label>
                        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${staff.phone}" required>
                    </div>

                    <div class="form-group">
                        <label for="address">Address</label>
                        <input type="text" class="form-control" id="address" name="address" value="${staff.address}" required>
                    </div>

                    <div class="form-group">
                        <label for="status">Status</label>
                        <select class="form-control" id="status" name="status">
                            <option value="true" <c:if test="${staff.status}">selected</c:if>>Active</option>
                            <option value="false" <c:if test="${not staff.status}">selected</c:if>>Inactive</option>
                        </select>
                    </div>
                        
           <div class="form-group">
    <label for="role">Role</label>
    <select class="form-control" id="role" name="role" required>
        <option value="1" <c:if test="${staff.roleID == 1}">selected</c:if>>Customer</option>
        <option value="2" <c:if test="${staff.roleID == 2}">selected</c:if>>Tourist</option>
        <option value="3" <c:if test="${staff.roleID == 3}">selected</c:if>>Admin</option>
    </select>
</div>
                    <button type="submit" class="btn btn-primary">Update</button>
                    <a href="${pageContext.request.contextPath}/staff/list" class="btn btn-secondary">Cancel</a>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
      <script>
                   function toggleDropdown() {
    const dropdown = document.getElementById("dropdown");
    dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
    if (!event.target.matches('.profile-button')) {
        const dropdown = document.getElementById("dropdown");
        if (dropdown.style.display === "block") {
            dropdown.style.display = "none";
        }
    }
};

        }
                </script>
</div>
</body>
</html>
