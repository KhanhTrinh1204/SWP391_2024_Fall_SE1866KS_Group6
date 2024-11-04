<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
       <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Add vehicle</title>
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

    <form action="${pageContext.request.contextPath}/vehicle/add" method="post" class="p-4 bg-light rounded shadow-sm">
        <h3 class="text-primary">Thông Tin Xe</h3>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="vehicleType">Loại Xe:</label>
                <input type="text" class="form-control" id="vehicleType" name="vehicleType" required>
            </div>
            <div class="form-group col-md-6">
                <label for="vehicleName">Tên Xe:</label>
                <input type="text" class="form-control" id="vehicleName" name="vehicleName" required>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="licensePlate">Biển Số Xe:</label>
                <input type="text" class="form-control" id="licensePlate" name="licensePlate" required>
            </div>
            <div class="form-group col-md-6">
                <label for="image">Hình Ảnh:</label>
                <input type="text" class="form-control" id="image" name="image" required>
            </div>
        </div>

        <h3 class="text-primary">Thông Tin Chi Tiết Xe</h3>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="manufacture">Hãng Sản Xuất:</label>
                <input type="text" class="form-control" id="manufacture" name="manufacture" required>
            </div>
            <div class="form-group col-md-6">
                <label for="modelYear">Năm Sản Xuất:</label>
                <input type="number" class="form-control" id="modelYear" name="modelYear" required>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="color">Màu Xe:</label>
                <input type="text" class="form-control" id="color" name="color" required>
            </div>
            <div class="form-group col-md-6">
                <label for="mileage">Số Km:</label>
                <input type="number" class="form-control" id="mileage" name="mileage" required>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="seatingCapacity">Sức Chứa:</label>
                <input type="number" class="form-control" id="seatingCapacity" name="seatingCapacity" required>
            </div>
            <div class="form-group col-md-6">
                <label for="registrationDate">Ngày Đăng Ký:</label>
                <input type="date" class="form-control" id="registrationDate" name="registrationDate" required>
            </div>
        </div>

        <div class="form-group">
            <label for="description">Mô Tả:</label>
            <textarea id="description" name="description" rows="4" class="form-control" required></textarea>
        </div>

        <button type="submit" class="btn btn-success mt-3">Thêm Xe</button>
    </form>

    <br>
     <!-- Optional JavaScript; choose one of the two! -->
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    <a href="${pageContext.request.contextPath}/vehicle/list" class="btn btn-link text-success">Quay lại danh sách xe</a>
</body>
</html>
