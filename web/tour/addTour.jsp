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
                        <li class="breadcrumb-item"><a href="#">Add tour</a></li>
                    </ol>
                </div>
            </div>
                                                
                                                
            <br>

      <form action="${pageContext.request.contextPath}/tour/add" method="post" class="p-4 bg-light rounded shadow-sm">
    <h3 class="text-primary">Thông Tin Tour</h3>
    
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="tourName">Tên Tour(*):</label>
            <input type="text" class="form-control" id="tourName" name="tourName" required>
        </div>
        <div class="form-group col-md-6">
            <label for="price">Giá(*):</label>
            <input type="number" class="form-control" id="price" name="price" step="0.01" required>
        </div>
    </div>

    <div class="form-group">
        <label for="description">Mô Tả(*):</label>
        <textarea id="description" name="description" rows="4" class="form-control" required></textarea>
    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="startDate">Ngày Bắt Đầu(*):</label>
            <input type="date" class="form-control" id="startDate" name="startDate" required>
        </div>
        <div class="form-group col-md-6">
            <label for="endDate">Ngày Kết Thúc(*):</label>
            <input type="date" class="form-control" id="endDate" name="endDate" required>
        </div>
    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="agentId">Đại Lý(*):</label>
            <select id="agentId" name="agentId" class="form-control" required>
                <option value="">Chọn Đại Lý</option>
                <c:forEach var="agent" items="${agents}">
                    <option value="${agent.agentId}">${agent.agentName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-6">
            <label for="vehicleId">Phương Tiện(*):</label>
            <select id="vehicleId" name="vehicleId" class="form-control" required>
                <option value="">Chọn Phương Tiện</option>
                <c:forEach var="vehicle" items="${vehicles}">
                    <option value="${vehicle.vehicleId}">${vehicle.vehicleName}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label for="restaurantId">Nhà Hàng(*):</label>
        <select id="restaurantId" name="restaurantId" class="form-control" required>
            <option value="">Chọn Nhà Hàng</option>
            <c:forEach var="restaurant" items="${restaurants}">
                <option value="${restaurant.restaurantId}">${restaurant.restaurantName}</option>
            </c:forEach>
        </select>
    </div>

     <div class="form-group">
        <label for="hotelId">Khách Sạn(*):</label>
        <select id="hotelId" name="hotelId" class="form-control" required>
            <option value="">Chọn Khách Sạn</option>
            <c:forEach var="hotel" items="${hotels}">
                <option value="${hotel.hotelId}">${hotel.hotelName}</option>
            </c:forEach>
        </select>
    </div>
    
    
    <div class="form-group">
        <label for="image" class="form-label">Image URL (*):</label>
        <input type="text" class="form-control" id="image" name="image" required>
    </div>

    <button type="submit" class="btn btn-success mt-3">Thêm Tour</button>
</form>


        <br>
        <a href="${pageContext.request.contextPath}/tour/list">Trở về danh sách Tour</a>
    </body>
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
</html>