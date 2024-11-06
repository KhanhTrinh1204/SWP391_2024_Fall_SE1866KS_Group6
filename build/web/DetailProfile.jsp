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
                    <h4 class="page-title">View Profile</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">View Profile</a></li>
                    </ol>
                </div>
            </div>
                                                
                                                
            <br>
<form action="updateProfile" method="post">
    <!-- Profile image on the left -->
    <div class="left-section">
        <img id="profileImage" src="${user.avatar}" alt="Profile Picture" class="profile-img">
    </div>
    
    <!-- Profile information on the right -->
    <div class="right-section">
        <div class="form-row">
            <div class="form-field">
                <label>Username(*):</label>
                <span>${user.userName}</span>
            </div>
        </div>
        
        <div class="form-row">
            <div class="form-field">
                <label>Full Name(*):</label>
                <span>${user.fullName}</span>
            </div>
            <div class="form-field">
                <label>Address(*):</label>
                <span>${user.address}</span>
            </div>
        </div>
        
        <div class="form-row">
            <div class="form-field">
                <label>Email(*):</label>
                <span>${user.email}</span>
            </div>
            <div class="form-field">
                <label>Gender:</label>
                <span>${user.gender ? 'Male' : 'Female'}</span>
            </div>
        </div>
        
        <div class="form-row">
            <div class="form-field">
                <label>Date of Birth(*):</label>
                <span>${user.DOB}</span>
            </div>
            <div class="form-field">
                <label>Phone Number(*):</label>
                <span>${user.phone}</span>
            </div>
        </div>
        
           <button type="submit">Update Profile</button>

    </div>
</form>


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
   /* Main form container for side-by-side layout */
form {
    display: flex;
    margin: 0 auto;
    gap: 20px;
    align-items: flex-start;
}

/* Style for the profile image */
.left-section {
    flex: 0 0 150px;
}

.profile-img {
    width: 250px;
    height: 250px;
    object-fit: cover;
    border-radius: 50%;
}

/* Right section with form fields */
.right-section {
    flex: 1;
    display: flex;
    flex-direction: column;
    gap: 15px;
}

/* Each row contains two form fields */
.form-row {
    display: flex;
    gap: 20px;
}

/* Individual field styling */
.form-field {
    flex: 1;
    display: flex;
    flex-direction: column;
    font-size: 0.95em;
}

.form-field label {
    font-weight: 600;
    margin-bottom: 5px;
}

.form-field span {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #f9f9f9;
}

button[type="submit"] {
    padding: 10px 20px;
    margin-top: 20px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button[type="submit"]:hover {
    background-color: #0056b3;
}

.success {
    color: green;
    margin-top: 10px;
}

</style>
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


                    function openModal(feedbackID, email) {
                        document.getElementById('feedbackID').value = feedbackID;
                        document.getElementById('modalEmail').value = email;
                        document.getElementById('responseModal').style.display = 'block';
                    }

                    function closeModal() {
                        document.getElementById('responseModal').style.display = 'none';
                    }

                    function showAlerts() {
            const urlParams = new URLSearchParams(window.location.search);

            // Check for delete success/failure
            const deleteSuccess = urlParams.get('deleteSuccess');
            if (deleteSuccess === 'true') {
                alert('Feedback deleted successfully.');
            } else if (deleteSuccess === 'false') {
                alert('Failed to delete feedback.');
            }

            // Check for email success/failure
            const emailSuccess = urlParams.get('emailSuccess');
            if (emailSuccess === 'true') {
                alert('Email sent successfully.');
            } else if (emailSuccess === 'false') {
                alert('Failed to send email.');
            }
        }
                </script>
            </main>
        </div>
                            </div>
    </body>
</html>
