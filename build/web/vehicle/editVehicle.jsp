<%-- 
    Document   : editVehicle
    Created on : Oct 10, 2024, 3:20:09 AM
    Author     : ASUS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>Management</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <!-- Google Material Icons -->
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <!-- Sidebar -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3><img src="img/logo.png" class="img-fluid"/><span>Travel System</span></h3>
        </div>
        <ul class="list-unstyled components">
            <li class="active">
                <a href="<%=request.getContextPath()%>/staff/list" class="dashboard"><i class="material-icons">dashboard</i>
                    <span>Manage Staff</span></a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/vehicle/list"><i class="material-icons">date_range</i><span>Manage Vehicle</span></a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/restaurant/list"><i class="material-icons">library_books</i><span>Manage Restaurant</span></a>
            </li>
        </ul>
    </nav>
    <!-- Main Content -->
    <div class="container-fluid">
        <div id="content">
            <div class="top-navbar">
                <div class="xp-topbar">
                    <div class="row">
                        <div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
                            <div class="xp-menubar">
                                <span class="material-icons text-white">signal_cellular_alt</span>
                            </div>
                        </div>
                        <div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">
                            <div class="xp-profilebar text-right">
                                <nav class="navbar p-0">
                                    <ul class="nav navbar-nav flex-row ml-auto">
                                        <li class="dropdown nav-item active">
                                            <a href="#" class="nav-link" data-toggle="dropdown">
                                                <span class="material-icons">notifications</span>
                                                <span class="notification">4</span>
                                            </a>
                                            <ul class="dropdown-menu">
                                                <li><a href="#">You have 5 new messages</a></li>
                                                <li><a href="#">You're now friend with Mike</a></li>
                                                <li><a href="#">Wish Mary on her birthday!</a></li>
                                                <li><a href="#">5 warnings in Server Console</a></li>
                                            </ul>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">
                                                <span class="material-icons">question_answer</span>
                                            </a>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link" href="#" data-toggle="dropdown">
                                                <img src="img/user.jpg" style="width:40px; border-radius:50%;"/>
                                                <span class="xp-user-live"></span>
                                            </a>
                                            <ul class="dropdown-menu small-menu">
                                                <li><a href="#"><span class="material-icons">person_outline</span>Profile</a></li>
                                                <li><a href="#"><span class="material-icons">settings</span>Settings</a></li>
                                                <li><a href="#"><span class="material-icons">logout</span>Logout</a></li>
                                            </ul>
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
                        <li class="breadcrumb-item"><a href="#">Staff List</a></li>
                    </ol>
                </div>
            </div>


        <!-- Nội dung chính -->
        <div class="container">
            <h2>Edit Staff Information</h2>

            <c:if test="${not empty errorMessage}">
                <div class="error-message">
                    <p>${errorMessage}</p>
                </div>
            </c:if>

            <form action="${pageContext.request.contextPath}/vehicle/edit" method="POST">
                <input type="hidden" name="vehicleId" value="${vehicle.vehicleId}" />

                <div class="form-group">
                    <label for="vehicleType">Vehicle Type</label>
                    <input type="text" name="vehicleType" id="vehicleType" value="${vehicle.vehicleType}" required />
                </div>

                <div class="form-group">
                    <label for="vehicleName">Vehicle Name</label>
                    <input type="text" name="vehicleName" id="vehicleName" value="${vehicle.vehicleName}" required />
                </div>

                <div class="form-group">
                    <label for="licensePlate">License Plate</label>
                    <input type="text" name="licensePlate" id="licensePlate" value="${vehicle.licensePlate}" required />
                </div>

                <div class="form-group">
                    <label for="image">Image URL</label>
                    <input type="text" name="image" id="image" value="${vehicle.image}" />
                </div>

                <div class="form-group">
                    <label for="manufacture">Manufacture</label>
                    <input type="text" name="manufacture" id="manufacture" value="${vehicle.manufacture}" required />
                </div>

                <div class="form-group">
                    <label for="modelYear">Model Year</label>
                    <input type="number" name="modelYear" id="modelYear" value="${vehicle.modelYear}" required />
                </div>

                <div class="form-group">
                    <label for="color">Color</label>
                    <input type="text" name="color" id="color" value="${vehicle.color}" required />
                </div>

                <div class="form-group">
                    <label for="engineType">Engine Type</label>
                    <input type="text" name="engineType" id="engineType" value="${vehicle.engineType}" required />
                </div>

                <div class="form-group">
                    <label for="mileage">Mileage</label>
                    <input type="number" name="mileage" id="mileage" value="${vehicle.mileAge}" required />
                </div>

                <div class="form-group">
                    <label for="seatingCapacity">Seating Capacity</label>
                    <input type="number" name="seatingCapacity" id="seatingCapacity" value="${vehicle.seatingCapacity}" required />
                </div>

                <div class="form-group">
                    <label for="registrationDate">Registration Date</label>
                    <input type="date" name="registrationDate" id="registrationDate" value="${vehicle.registrationDate}" required />
                </div>

                <div class="form-group">
                    <label for="description">Description</label>
                    <textarea name="description" id="description" rows="4">${vehicle.description}</textarea>
                </div>

                <div class="form-group">
                    <input type="hidden" name="agentId" id="agentId" value="${vehicle.agent.agentId}" required />
                </div>

                <div class="form-group" style="text-align: center;">
                    <button type="submit" class="btn-submit">Update Vehicle</button>
                    <a href="${pageContext.request.contextPath}/vehicle/list" class="btn-back">Back</a>
                </div>
            </form>
        </div>
    </body>
</html>
