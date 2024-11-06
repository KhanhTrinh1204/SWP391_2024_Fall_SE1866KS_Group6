<%-- 
    Document   : vehicleDetail
    Created on : Oct 10, 2024, 2:21:52 AM
    Author     : ASUS
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Management feedback</title>
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
                    <h4 class="page-title">Manage vehicle</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Vehicle List</a></li>
                    </ol>
                </div>
            </div>
                                                
                                                
            <br>

        <!-- Nội dung chính -->
        <div class="container">
            <h2>Detail vehicle Information</h2>

            <c:if test="${not empty errorMessage}">
                <div class="error-message">
                    <p>${errorMessage}</p>
                </div>
            </c:if>

   <!-- Display vehicle information if vehicle is not empty -->
<c:if test="${not empty vehicle}">
    <form class="container mt-4">
        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Vehicle Type</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.vehicleType}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Vehicle Name</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.vehicleName}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">License Plate</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.licensePlate}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Manufacture</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.manufacture}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Model Year</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.modelYear}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Color</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.color}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Engine Type</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.engineType}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Mileage</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.mileAge}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Seating Capacity</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.seatingCapacity}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Registration Date</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.registrationDate}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Description</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.description}</p>
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-4 col-form-label fw-bold">Travel Agent</label>
            <div class="col-sm-8">
                <p class="form-control-plaintext">${vehicle.agent.agentName}</p>
            </div>
        </div>

        <div class="text-center mt-4">
            <a href="<%=request.getContextPath()%>/vehicle/list" class="btn btn-secondary">Back to Vehicles List</a>
        </div>
    </form>
</c:if>

<!-- Display error message if vehicle is not found or other error occurs -->
<c:if test="${not empty error}">
    <p class="text-danger">${error}</p>
    <div class="text-center mt-4">
        <a href="vehicleslist.jsp" class="btn btn-secondary">Back to Vehicles List</a>
    </div>
</c:if>
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
                <!-- Add styles for modal pop-up -->
<style>
    /* Dropdown Menu Styling */
.dropdown-menu {
    display: none; /* Initially hidden */
    position: absolute; /* Position it relative to its nearest positioned ancestor */
    right: 0; /* Align to the right of the profile link */
    z-index: 1000; /* Ensure it appears above other elements */
    background-color: white; /* White background */
    border: 1px solid #ccc; /* Border styling */
    border-radius: 4px; /* Rounded corners */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
    min-width: 150px; /* Minimum width */
}

/* Display the dropdown when active */
.dropdown-menu.show {
    display: block; /* Show the dropdown */
}

/* Dropdown Item Styling */
.dropdown-menu li {
    padding: 10px; /* Padding for items */
}

.dropdown-menu li a {
    text-decoration: none; /* Remove underline from links */
    color: #333; /* Text color */
    display: block; /* Make the link fill the container */
}

.dropdown-menu li a:hover {
    background-color: #f1f1f1; /* Background color on hover */
}

    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        background-color: rgba(0,0,0,0.5); /* Black background with opacity */
        overflow: auto; /* Enable scroll if needed */
    }
    .modal-content {
        background-color: #fff;
        margin: 15% auto; /* 15% from the top and centered */
        padding: 20px;
        border: 1px solid #888;
        width: 50%; /* Could be more or less, depending on screen size */
    }
    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }
    .close:hover,
    .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
    }
    
</style>
</body>
</html>

