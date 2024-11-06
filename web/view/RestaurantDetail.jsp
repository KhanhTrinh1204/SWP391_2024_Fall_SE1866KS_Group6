<%-- 
    Document   : home
    Created on : Oct 14, 2024, 9:25:13 PM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Travel System</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_1.css">

</head>
<body>
    
<!-- header section starts  -->

<header>

    <div id="menu-bar" class="fas fa-bars"></div>

    <a href="#" class="logo"><span>T</span>ravel</a>

    <nav class="navbar">
        <a href="${pageContext.request.contextPath}/view/home">home</a>
        <a href="#book">book</a>
        <a href="#packages">Tourist</a>
        <a href="#services">Restaurant</a>
        <a href="#gallery">Hotel</a>
            <a href="${pageContext.request.contextPath}/SendRequest.jsp" >Send request</a>
    </nav>
   
    <div class="icons">
        <c:choose>
       <c:when test="${authcode!= null}">
                 <script>
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
    text-decoration: none; 
}

/* Display the dropdown when active */
.dropdown-menu.show {
    display: block; /* Show the dropdown */
    text-decoration: none; 
}

/* Dropdown Item Styling */
.dropdown-menu li {
    padding: 10px; /* Padding for items */
    text-decoration: none; 
}

.dropdown-menu li a {
    text-decoration: none; /* Remove underline from links */
    color: #333; /* Text color */
    display: block; /* Make the link fill the container */
}

.dropdown-menu li a:hover {
    background-color: #f1f1f1; /* Background color on hover */
}
    </script>
<div class="xp-profilebar" style="text-decoration: none;">
    <nav  style="text-decoration: none;">
        <ul  style="text-decoration: none;">
            <li class="nav-item">
                <a class="profile-button" onclick="toggleDropdown()" style="text-decoration: none;">
                    <img src="${pageContext.request.contextPath}/img/user.jpg" style="width:40px; border-radius:50%;" alt="User"/>
                </a>
                <div class="dropdown" id="dropdown" style="display: none; text-decoration: none;">
                    <a href="${pageContext.request.contextPath}/viewProfile" style="color: white; display: block;">View Profile</a>
                    <a href="${pageContext.request.contextPath}/LogoutControl" style="color: white; display: block;">Logout</a>
                    <a href="${pageContext.request.contextPath}/Booking" style="color: white; display: block;">My booking</a>
                </div>
            </li>
        </ul>
    </nav>
</div>

            </c:when>
            <c:otherwise>
                  <a href="${pageContext.request.contextPath}/login" class="btn">Login</a>
            </c:otherwise>
                  </c:choose>
    </div>

    <form action="" class="search-bar-container">
        <input type="search" id="search-bar" placeholder="search here...">
        <label for="search-bar" class="fas fa-search"></label>
    </form>

</header>

<!-- header section ends -->

<!-- login form container  -->

<div class="login-form-container">

    <i class="fas fa-times" id="form-close"></i>

    <form action="login" method="post">
        <h3>login</h3>
        <input type="email" class="box" placeholder="enter your email">
        <input type="password" class="box" placeholder="enter your password">
        <input type="submit" value="login now" class="btn">
        <input type="checkbox" id="remember">
        <label for="remember">remember me</label>
        <p>forget password? <a href="#">click here</a></p>
        <p>don't have and account? <a href="#">register now</a></p>
    </form>

</div>
<section class="home" id="home">

    <div class="content">
        <h3>adventure is worthwhile</h3>
        <p>dicover new places with us, adventure awaits</p>
        <a href="#" class="btn">discover more</a>
    </div>

    <div class="controls">
        <span class="vid-btn active" data-src="img/vid-1.mp4"></span>
        <span class="vid-btn" data-src="${pageContext.request.contextPath}/img/vid-2.mp4"></span>
        <span class="vid-btn" data-src="${pageContext.request.contextPath}/img/vid-3.mp4"></span>
        <span class="vid-btn" data-src="${pageContext.request.contextPath}/img/vid-4.mp4"></span>
        <span class="vid-btn" data-src="${pageContext.request.contextPath}/img/vid-5.mp4"></span>
    </div>

    <div class="video-container">
        <video src="${pageContext.request.contextPath}/img/vid-1.mp4" id="video-slider" loop autoplay muted></video>
    </div>

</section>
<section >
    <!-- Restaurants Section -->
<img src="${restaurant.image}" alt="Restaurant Image" class="restaurant-image" />
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
                </div>


    <!-- Hotels Section -->
</section>

 <style>
 /* Styles for Tour Details */
.tour-details, .vehicles-section, .restaurants-section, .hotels-section {
    margin: 20px auto;
    padding: 10px;
    max-width: 800px;
}

.form-group {
    display: flex;
    margin-bottom: 10px;
}

.form-group label {
    font-weight: bold;
    width: 150px;
}

.tour-image, .vehicle-image, .restaurant-image, .hotel-image {
    max-width: 100%;
    height: auto;
    border-radius: 8px;
}


    </style>
<script>
    function updateTour(id) {
        if (confirm("ARE YOU SURE TO CANCLE THIS BOOKING"))
                            window.location.href = '<%=request.getContextPath()%>/updateBooking?id=' + id;
                    }
   
</script>


<section class="footer">

    <div class="box-container">

        <div class="box">
            <h3>about us</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Assumenda quas magni pariatur est accusantium voluptas enim nemo facilis sit debitis.</p>
        </div>
        <div class="box">
            <h3>branch locations</h3>
            <a href="#">bangladesh</a>
            <a href="#">USA</a>
            <a href="#">japan</a>
            <a href="#">Turkey</a>
        </div>
        <div class="box">
            <h3>quick links</h3>
            <a href="#">home</a>
            <a href="#">book</a>
            <a href="#">packages</a>
            <a href="#">services</a>
            <a href="#">gallery</a>
            <a href="#">review</a>
            <a href="#">contact</a>
        </div>
        <div class="box">
            <h3>follow us</h3>
            <a href="https://www.facebook.com/FreeWebsiteCode/">facebook</a>
            <a href="https://twitter.com/freewebsitecode">twitter</a>
            <a href="https://www.linkedin.com/in/freewebsitecode/">linkedin</a>
            <a href="https://www.youtube.com/FreeWebsiteCode/videos">youtube</a>
        </div>

    </div>

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
                </script>
    
</section>



<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="script.js"></script>

</body>
</html>