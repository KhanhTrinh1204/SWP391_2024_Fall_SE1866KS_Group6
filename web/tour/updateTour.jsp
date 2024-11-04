<%-- 
    Document   : addRestaurant
    Created on : Oct 13, 2024, 12:31:54 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <span>Manage Staff</span>
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
                    <h4 class="page-title">Manage Tour</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Update tour</a></li>
                    </ol>
                </div>
            </div>
                        <br/>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" role="alert">
                ${errorMessage}
            </div>
        </c:if>
   <form action="${pageContext.request.contextPath}/tour/update" method="post" class="p-4 border rounded">

    <!-- Error message if update fails -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>

    <!-- Tour Name -->
    <div class="mb-3">
        <label for="tourName" class="form-label">Tour Name</label>
        <input type="text" class="form-control" id="tourName" name="tourName" value="${tour.tourName}" placeholder="Enter tour name" required>
        <div class="invalid-feedback">
            Please enter the tour name.
        </div>
    </div>

    <!-- Price -->
    <div class="mb-3">
        <label for="price" class="form-label">Price</label>
        <input type="number" class="form-control" step="0.01" id="price" name="price" value="${tour.price}" placeholder="Enter price" required>
        <div class="invalid-feedback">
            Please enter the price.
        </div>
    </div>

    <!-- Description -->
    <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <textarea class="form-control" id="description" name="description" rows="4" placeholder="Enter description">${tour.description}</textarea>
        <div class="invalid-feedback">
            Please enter a description.
        </div>
    </div>

    <!-- Start Date -->
    <div class="mb-3">
        <label for="startDate" class="form-label">Start Date</label>
        <input type="date" class="form-control" id="startDate" name="startDate" value="${tour.startDate}" required>
        <div class="invalid-feedback">
            Please select the start date.
        </div>
    </div>

    <!-- End Date -->
    <div class="mb-3">
        <label for="endDate" class="form-label">End Date</label>
        <input type="date" class="form-control" id="endDate" name="endDate" value="${tour.endDate}" required>
        <div class="invalid-feedback">
            Please select the end date.
        </div>
    </div>

    <!-- Travel Agent -->
    <div class="mb-3">
        <label for="agentId" class="form-label">Travel Agent</label>
        <select class="form-select" id="agentId" name="agentId" required>
            <option value="" disabled selected>Select travel agent</option>
            <c:forEach var="agent" items="${agents}">
                <option value="${agent.agentId}" ${tour.agent.agentName == agent.agentName ? 'selected' : ''}>${agent.agentName}</option>
            </c:forEach>
        </select>
        <div class="invalid-feedback">
            Please select a travel agent.
        </div>
    </div>

    <!-- Vehicle -->
       <div class="mb-3">
        <label for="vehicleId" class="form-label">Vehicle</label>
        <select class="form-select" id="vehicleId" name="vehicleId" required>
            <option value="" disabled selected>Select Vehicles</option>
            <c:forEach var="vehicle" items="${vehicles}">
                <option value="${vehicle.vehicleId}" ${tour.vechicle[0].vehicleName == vehicle.vehicleName ? 'selected' : ''}>${vehicle.vehicleName}</option>
            </c:forEach>
        </select>
        <div class="invalid-feedback">
            Please select a Vehicle.
        </div>
    </div>

    <!-- Restaurant -->
    <div class="mb-3">
        <label for="restaurantId" class="form-label">Restaurant</label>
        <select class="form-select" id="restaurantId" name="restaurantId" required>
            <option value="" disabled selected>Select restaurant</option>
            <c:forEach var="restaurant" items="${restaurants}">
                <option value="${restaurant.restaurantId}" ${tour.restaurant[0].restaurantName == restaurant.restaurantName ? 'selected' : ''}>${restaurant.restaurantName}</option>
            </c:forEach>
        </select>
        <div class="invalid-feedback">
            Please select a restaurant.
        </div>
    </div>

    
    <div class="mb-3">
                <label for="image" class="form-label">Image url(*):</label>
                  <input value="${tour.image}" type="text" class="form-control" id="image" name="image" required>

            </div>

    <!-- Submit Button -->
    <button type="submit" class="btn btn-primary w-100">Update Tour</button>
</form>

          </div>
</body>
</html>
