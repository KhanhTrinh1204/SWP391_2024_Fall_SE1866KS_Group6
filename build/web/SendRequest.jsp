
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  
    <script>
        function validateForm() {
            var title = document.getElementById("title").value;
            var description = document.getElementById("description").value;
            var isValid = true;

            // Reset error messages
            document.getElementById("titleError").innerText = "";
            document.getElementById("descriptionError").innerText = "";

            // Validate title length (5-200 characters)
            if (title.trim().length < 5 || title.trim().length > 200) {
                document.getElementById("titleError").innerText = "Title must be between 5 and 200 characters.";
                isValid = false;
            }

            // Validate description length (5-255 characters)
            if (description.trim().length < 5 || description.trim().length > 255) {
                document.getElementById("descriptionError").innerText = "Description must be between 5 and 255 characters.";
                isValid = false;
            }

            return isValid;
        }
    </script>
</head>
<body>
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
                    <a href="${pageContext.request.contextPath}/ViewBookingList" style="color: white; display: block;">My booking</a>
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

<!-- home section starts  -->

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
    <section class="packages" id="packages">
        <div class="box-container">
    <form action="createRequest" method="post" onsubmit="return validateForm()">
        <label for="title">Title(*)</label>
        <input type="text" id="title" name="title">
        <div class="error" id="titleError">
            <!-- Server-side error message for title -->
            <% String titleError = (String) request.getAttribute("titleError");
               if (titleError != null) { %>
                <%= titleError %>
            <% } %>
        </div>

        <label for="description">Description(*)</label>
        <textarea id="description" name="description"></textarea>
        <div class="error" id="descriptionError">
            <!-- Server-side error message for description -->
            <% String descriptionError = (String) request.getAttribute("descriptionError");
               if (descriptionError != null) { %>
                <%= descriptionError %>
            <% } %>
        </div>

        <button type="submit">Send</button>

        <!-- Display success message if it exists -->
        <% String successMessage = (String) request.getAttribute("successMessage");
           if (successMessage != null) { %>
            <div class="success">
                <%= successMessage %>
            </div>
        <% } %>
    </form>
    </div>
    </section>
      <style>
        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 1200px;
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        label {
            font-size: 15px;
            color: #34495e;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        textarea {
            padding: 12px;
            border: 1px solid #dcdfe3;
            border-radius: 6px;
            font-size: 14px;
            width: 100%;
            box-sizing: border-box;
            background-color: #f9f9f9;
            transition: all 0.2s ease;
        }

        input[type="text"]:focus,
        textarea:focus {
            border-color: #3498db;
            background-color: #fff;
            outline: none;
        }

        textarea {
            resize: none;
            height: 150px;
        }

        button {
            padding: 12px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #2980b9;
        }

        .error {
            color: red;
            font-size: 12px;
        }

        .success {
            color: green;
            font-size: 14px;
            margin-bottom: 15px;
            text-align: center;
        }

        /* Form responsiveness */
        @media (max-width: 600px) {
            form {
                padding: 20px;
                gap: 15px;
            }
        }
    </style>

</body>
</html>
