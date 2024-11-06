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
        <title>Management tour</title>
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
                    <h4 class="page-title">Manage booking tour</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Tour List</a></li>
                    </ol>
                </div>
            </div>
                                                
                                                
            <br>
                  <form action="${pageContext.request.contextPath}/booking/list" method="get" class="mb-4">
                    <div class="form-row align-items-end">
                        <div class="col-md-4">
                            <label for="email">Search Customer Name</label>
                            <input type="text" class="form-control" id="search" name="search" placeholder="Enter account name" value="${param.search}">
                        </div>
                        <div class="col-md-4">
                            <label for="status">Status:</label>
                            <select id="status" name="status" class="form-control">
                                <option value="">All</option>
                                <option value="1" ${param.status == 1 ? 'selected' : ''}>Booking</option>
                                <option value="2" ${param.status == 2 ? 'selected' : ''}>Confirm Booking</option>
                                <option value="3" ${param.status == 3 ? 'selected' : ''}>Cancel</option>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <input type="submit" class="btn btn-primary mt-4" value="Search">
                        </div>
                    </div>
                </form>
                <div class="main-content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-wrapper">
                                <div class="table-title">
                                    <div class="row">
                                        <div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
                                            <h2 class="ml-lg-2">Manage Booking Tour</h2>
                                        </div>
                                      
                                    </div>
                                </div>
                           <c:if test="${not empty tour}"> 
                <!-- Bảng hiển thị danh sách tour -->
                    <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Full Name</th>
                             <th>Email</th>
                            <th>Tour Name</th>
                            <th>Price</th>    
                            <th>Image</th>
                             <th>Booking Date</th>
                              <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tour" items="${tour}">
                            <tr>
                                 <td>${tour.account[0].fullName}</td> 
                                  <td>${tour.account[0].email}</td> 
                                <td>
                                    <a href="${pageContext.request.contextPath}/tour/detail?id=${tour.tourId}">
                                        ${tour.tourName}
                                    </a>
                                </td> 
                                <td>${tour.price}</td> 
                                <td>
                                   <img src="${tour.image}" alt="Vehicle Image" style="width: 100px; height: auto;">
                                </td>
                                <td>
                                  <div>${tour.userBooking[0].timebooking}</div>
                                  </td>
                                  <td>
                                 <div style="color: ${tour.userBooking[0].status == 1 ? 'blue' : tour.userBooking[0].status == 2 ? 'green' : tour.userBooking[0].status == 3 ? 'red' : 'black'};">
                                       ${tour.userBooking[0].status == 1 ? 'Booking' : 
                                       tour.userBooking[0].status == 2 ? 'Confirm Booking' : 
                                tour.userBooking[0].status == 3 ? 'Cancel' : 
      'Unknown Status'}
</div>
                                  </td>
                                <td>
                                    <c:if test="${tour.userBooking[0].status == 1}">
                                        <a href="#" onclick="deleteStaff('${tour.userBooking[0].id}')">   <i class="material-icons">deletes </i></a> 
                                                    <a href="#" onclick="confirmTour('${tour.userBooking[0].id}')">   <i class="material-icons">check</i></a>         
                                                 
                                    </c:if>
                                                
                                                       
                                </td>
                            </tr>
                        </c:forEach>
                            </c:if>
                    </tbody>
                </table>
                <c:if test="${empty tour}">
                                <p>No tour found.</p>
                            </c:if>
                                  </div>
                                      <div class="pagination">
                    
                    <c:if test="${currentPage > 1}">
                        <a href="${pageContext.request.contextPath}/booking/list?page=${currentPage - 1}&search=${param.search}&status=${param.status}" class="btn btn-light">Previous</a>
                    </c:if>
                    <c:if test="${currentPage < totalPages}">
                        <a href="${pageContext.request.contextPath}/booking/list?page=${currentPage + 1}&search=${param.search}&status=${param.status}" class="btn btn-light">Next</a>
                         </c:if>
                </div>
                   
                         <c:if test="${totalPages > 0}">
        Showing page ${currentPage} of ${totalPages}
    </c:if>     
                                    </div>
                    </div>
                </div>
                <script type="text/javascript">
                    function deleteStaff(id) {
                        if (confirm("ARE YOU SURE TO CANCLE THIS BOOKING"))
                            window.location.href = '<%=request.getContextPath()%>/AdminDeleteBooking?id=' + id;
                    }
                      function confirmTour(id) {
                        if (confirm("ARE YOU SURE TO CONFIRM THIS BOOKING"))
                            window.location.href = '<%=request.getContextPath()%>/UpdateConfirmTour?id=' + id;
                    }
                </script>
            </div>
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
