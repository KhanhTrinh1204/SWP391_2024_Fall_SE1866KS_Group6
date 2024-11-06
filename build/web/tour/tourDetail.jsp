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
                    <h4 class="page-title">Manage tour</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Tour List</a></li>
                    </ol>
                </div>
            </div>
    
   <c:if test="${not empty tour}">
    <!-- Tour Details Section -->
    <div class="tour-details">
        <h2>Tour Details</h2>
        
        <!-- Display tour image if available -->
        <c:if test="${not empty tour.image}">
            <img src="${tour.image}" alt="Tour Image" class="tour-image" style="margin-left: 35%; align-items: center; width: 500px;"/>
        </c:if>

        <div class="form-group">
            <label>Tour Name:</label>
            <span>${tour.tourName}</span>
        </div>
        
        <div class="form-group">
            <label>Price:</label>
            <span>${tour.price} USD</span>
        </div>
        
        <div class="form-group">
            <label>Description:</label>
            <span>${tour.description}</span>
        </div>
        
        <div class="form-group">
            <label>Start Date:</label>
            <span>${tour.startDate}</span>
        </div>
        
        <div class="form-group">
            <label>End Date:</label>
            <span>${tour.endDate}</span>
        </div>
        
        <div class="form-group">
            <label>Travel Agent:</label>
            <span>${tour.agent.agentName}</span>
        </div>
    </div>

    <!-- Vehicles Section -->
    <h2>Vehicles</h2>
    <c:if test="${not empty tour.vechicle}">
        <div class="vehicles-section">
            <c:forEach var="vehicle" items="${tour.vechicle}">
                <div class="vehicle-card">
                    <div class="form-group">
                        <label>Vehicle Name:</label>
                        <span>${vehicle.vehicleName}</span>
                    </div>
                    <div class="form-group">
                        <label>Color:</label>
                        <span>${vehicle.color}</span>
                    </div>
                    <div class="form-group">
                        <label>Engine Type:</label>
                        <span>${vehicle.engineType}</span>
                    </div>
                    <div class="form-group">
                        <label>Manufacture:</label>
                        <span>${vehicle.manufacture}</span>
                    </div>
                    <div class="form-group">
                        <label>Model Year:</label>
                        <span>${vehicle.modelYear}</span>
                    </div>
                    <div class="form-group">
                        <label>Seating Capacity:</label>
                        <span>${vehicle.seatingCapacity}</span>
                    </div>
                    <div class="form-group">
                        <label>Vehicle Image:</label>
                        <img src="${vehicle.image}" alt="Vehicle Image" class="vehicle-image" />
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
    <c:if test="${empty tour.vechicle}">
        <p>No vehicles available for this tour.</p>
    </c:if>

    <!-- Restaurants Section -->
    <h2>Restaurants</h2>
    <c:if test="${not empty tour.restaurant}">
        <div class="restaurants-section">
            <c:forEach var="restaurant" items="${tour.restaurant}">
                <div class="restaurant-card">
                    <div class="form-group">
                        <label>Restaurant Name:</label>
                        <span>${restaurant.restaurantName}</span>
                    </div>
                    <div class="form-group">
                        <label>Category:</label>
                        <span>${restaurant.category}</span>
                    </div>
                    <div class="form-group">
                        <label>Description:</label>
                        <span>${restaurant.description}</span>
                    </div>
                    <div class="form-group">
                        <label>Email:</label>
                        <span>${restaurant.email}</span>
                    </div>
                    <div class="form-group">
                        <label>Location:</label>
                        <span>${restaurant.location}</span>
                    </div>
                    <div class="form-group">
                        <label>Phone Number:</label>
                        <span>${restaurant.phoneNumber}</span>
                    </div>
                    <div class="form-group">
                        <label>Restaurant Image:</label>
                        <img src="${restaurant.image}" alt="Restaurant Image" class="restaurant-image" />
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
    <c:if test="${empty tour.restaurant}">
        <p>No restaurants available for this tour.</p>
    </c:if>

    <!-- Hotels Section -->
    <h2>Hotels</h2>
    <c:if test="${not empty tour.hotel}">
        <div class="hotels-section">
            <c:forEach var="hotel" items="${tour.hotel}">
                <div class="hotel-card">
                    <div class="form-group">
                        <label>Hotel Name:</label>
                        <span>${hotel.hotelName}</span>
                    </div>
                    <div class="form-group">
                        <label>Description:</label>
                        <span>${hotel.description}</span>
                    </div>
                    <div class="form-group">
                        <label>Price:</label>
                        <span>${hotel.price} USD</span>
                    </div>
                    <div class="form-group">
                        <label>Hotel Image:</label>
                        <img src="${hotel.imgUrl}" alt="Hotel Image" class="hotel-image" />
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
    <c:if test="${empty tour.hotel}">
        <p>No hotels available for this tour.</p>
    </c:if>

    <br>
    <a href="<%=request.getContextPath()%>/tour/list">Back to Tour List</a>
</c:if>

<!-- Display error message if tour not found or other error -->


    <style>
  .tour-details, .vehicles-section, .restaurants-section, .hotels-section {
    margin: 20px 0;
}

.form-group {
    display: flex;
    margin-bottom: 10px;
}

.form-group label {
    font-weight: bold;
    width: 150px;
}

.form-group span {
    flex: 1;
}

.vehicle-card, .restaurant-card, .hotel-card {
    padding: 10px;
    border: 1px solid #ddd;
    margin-bottom: 15px;
}

/* Center and enlarge images */
.image-container {
    display: flex;
    justify-content: center;
    margin-top: 10px;
}

.tour-image, .vehicle-image, .restaurant-image, .hotel-image {
    width: 200px; /* Adjust size as desired */
    height: auto;
    border-radius: 8px;
}

    </style>
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
