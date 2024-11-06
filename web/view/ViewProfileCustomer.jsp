<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
   
    <script>
        // Update image preview when URL changes
        function updateImagePreview() {
            const imageUrl = document.getElementById('avatarUrl').value;
            document.getElementById('profileImage').src = imageUrl;
        }

        // Validate form submission
        function validateForm() {
            let isValid = true;

            // Clear previous error messages
            document.querySelectorAll('.error').forEach(function(el) {
                el.textContent = '';
            });

            // Validate Image URL
            const imageUrl = document.getElementById('avatarUrl').value;
            if (!isValidUrl(imageUrl)) {
                document.getElementById('avatarUrlError').textContent = 'Please enter a valid image URL.';
                isValid = false;
            }

            // Validate Username (not empty)
            const username = document.getElementById('username').value;
            if (username.trim() === '') {
                document.getElementById('usernameError').textContent = 'Username is required.';
                isValid = false;
            }

            // Validate Full Name (not empty)
            const fullName = document.getElementById('fullname').value;
            if (fullName.trim() === '') {
                document.getElementById('fullNameError').textContent = 'Full name is required.';
                isValid = false;
            }

            // Validate Address (not empty and max length of 250 characters)
            const address = document.getElementById('address').value;
            if (address.trim() === '') {
                document.getElementById('addressError').textContent = 'Address is required.';
                isValid = false;
            } else if (address.length > 250) {
                document.getElementById('addressError').textContent = 'Address cannot exceed 250 characters.';
                isValid = false;
            }

            // Validate Email (valid format)
            const email = document.getElementById('email').value;
            if (!isValidEmail(email)) {
                document.getElementById('emailError').textContent = 'Please enter a valid email address.';
                isValid = false;
            }

            // Validate Phone Number (must be exactly 10 digits)
            const phone = document.getElementById('phone').value;
            if (!isValidPhone(phone)) {
                document.getElementById('phoneError').textContent = 'Phone number must be exactly 10 digits.';
                isValid = false;
            }

            // Validate Date of Birth (not empty and must be less than current date)
            const dob = document.getElementById('dob').value;
            if (!dob) {
                document.getElementById('dobError').textContent = 'Date of birth is required.';
                isValid = false;
            } else if (new Date(dob) >= new Date()) {
                document.getElementById('dobError').textContent = 'Date of birth must be before the current date.';
                isValid = false;
            }

            return isValid;
        }

        // Helper function to validate URL
        function isValidUrl(url) {
            try {
                new URL(url);
                return true;
            } catch (_) {
                return false;
            }
        }

        // Helper function to validate email
        function isValidEmail(email) {
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return emailRegex.test(email);
        }

        // Helper function to validate phone number
        function isValidPhone(phone) {
            const phoneRegex = /^[0-9]{10}$/;
            return phoneRegex.test(phone);
        }
    </script>
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
                    <a href="${pageContext.request.contextPath}/ViewProfileCustomer" style="color: white; display: block;">View Profile</a>
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
    <form action="UpdateProfileCustomer" method="post" onsubmit="return validateForm()">
        <img id="profileImage" src="${user.avatar}" alt="Profile Picture" class="profile-img">
        
        <label for="avatarUrl">Image URL(*):</label>
        <input type="text" id="avatarUrl" name="avatarUrl" value="${user.avatar}" oninput="updateImagePreview()">
        <span id="avatarUrlError" class="error"></span>

        <label for="username">Username(*):</label>
        <input type="text" id="username" name="username" value="${user.userName}">
        <span id="usernameError" class="error"></span>

        <label for="fullname">Full Name(*):</label>
        <input type="text" id="fullname" name="fullname" value="${user.fullName}">
        <span id="fullNameError" class="error"></span>

        <label for="address">Address(*):</label>
        <input type="text" id="address" name="address" value="${user.address}">
        <span id="addressError" class="error"></span>

        <label for="email">Email(*):</label>
        <input type="email" id="email" name="email" value="${user.email}" readonly>
        <span id="emailError" class="error"></span>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender">
            <option value="1" ${user.gender == true ? 'selected' : ''}>Male</option>
            <option value="0" ${user.gender == false ? 'selected' : ''}>Female</option>
        </select>

        <label for="dob">Date of Birth(*):</label>
        <input type="date" id="dob" name="dob" value="${user.DOB}">
        <span id="dobError" class="error"></span>

        <label for="phone">Phone Number(*):</label>
        <input type="text" id="phone" name="phone" value="${user.phone}">
        <span id="phoneError" class="error"></span>

        <button type="submit">Update Profile</button>

        <% String successMessage = (String) request.getAttribute("successMessage");
           if (successMessage != null) { %>
            <div class="success">
                <%= successMessage %>
            </div>
        <% } %>
    </form>
    </section>
 <style>
      
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-top: 10px;
        }
        input, select {
            padding: 8px;
            font-size: 14px;
        }
        button {
            margin-top: 20px;
            padding: 10px;
            font-size: 16px;
            cursor: pointer;
        }
        .profile-img {
            width: 100%;
            max-width: 200px;
            height: auto;
            margin: 0 auto;
            display: block;
            border-radius: 50%;
        }
        .success {
            color: green;
            font-size: 14px;
            margin-bottom: 15px;
        }
        .error {
            color: red;
            font-size: 12px;
        }
    </style>
</body>
</html>
