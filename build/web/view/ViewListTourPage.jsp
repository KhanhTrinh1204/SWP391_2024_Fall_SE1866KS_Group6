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
     <form method="GET" action="<%=request.getContextPath()%>/ViewListTourPage" class="search-form d-flex align-items-center gap-2">
                    <div class="input-group" style="width: 60%;">
                        <label for="search" style="margin-left: 30px; margin-right: 20px;" class="visually-hidden">Search by name:</label>
                        <input type="text" id="search" class="form-control" name="search" placeholder="Search by name" aria-label="Search by name" value="${param.search}">
                    </div>
                    <button  type="submit">Search</button>
                </form>
<section class="packages" id="packages">
    <div class="box-container">
    <c:if test="${tour != null}">
       
        <c:forEach var="tour" items="${tour}" >
            
             <div class="box">
            <img src="${tour.image}" alt="">
            <div class="content">
                <h3> 
                    <a href="<%=request.getContextPath()%>/CustomerViewTourDetail?id=${tour.tourId}">    ${tour.tourName}</a> </h3>
                <p>${tour.description}</p>
               
                <div class="price">${tour.price}</div>
                <a class="btn" href="<%=request.getContextPath()%>/tour/book?id=${tour.tourId}">Book</a>
            </div>
        </div>
        </c:forEach>    
        
                   
    </c:if>
    <c:if test="${empty tour}">
        <p>No tour found.</p>
    </c:if>
        </div>
</section>
 <div class="pagination">
                    
                    <c:if test="${currentPage > 1}">
                        <a href="${pageContext.request.contextPath}/ViewListTourPage?page=${currentPage - 1}&search=${param.search}" >Previous</a>
                    </c:if>
                    <c:if test="${currentPage < totalPages}">
                        <a href="${pageContext.request.contextPath}/ViewListTourPage?page=${currentPage + 1}&search=${param.search}" >Next</a>
                         </c:if>
                        
                </div>
                   
                         <c:if test="${totalPages > 0}">
    <div class="pagination-info">Showing page ${currentPage} of ${totalPages}</div>
</c:if>


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
        <style>
            /* Align the search form to the right and increase font size */
.search-form {
    display: flex;
    align-items: center;
    justify-content: flex-end; /* Aligns the form to the right */
    font-size: 1.2em; /* Increases font size */
    margin: 20px; /* Adds some margin around the form */
}

/* Styling the search button */
.search-form button {
    padding: 10px 20px;
    font-size: 1em;
    color: white;
    background-color: #007BFF; /* Blue background */
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.search-form button:hover {
    background-color: #0056b3; /* Darker blue on hover */
}

/* Pagination styling */
.pagination a {
    padding: 8px 16px;
    font-size: 1.2em; /* Larger font size */
    color: white;
    background-color: #28a745; /* Green background */
    border-radius: 4px;
    text-decoration: none;
    margin: 0 5px;
    transition: background-color 0.3s ease;
}

.pagination a:hover {
    background-color: #218838; /* Darker green on hover */
}

/* Optional: Styling the "Showing page" text */
.pagination {
    font-size: 1.2em;
    color: #333;
    margin-top: 10px;
    text-align: center;
}
/* Style for the current page info text */
.pagination-info {
    font-size: 1.5em;
    font-weight: bold;
    color: #555;
    text-align: center;
    margin-top: 10px;
}
        </style>


<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="script.js"></script>

</body>
</html>