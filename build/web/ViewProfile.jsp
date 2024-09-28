<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0 auto;
            padding: 20px;
            max-width: 600px;
        }
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
    </style>
      <script>
          // JavaScript function to update image preview when the URL changes
        function updateImagePreview() {
            const imageUrl = document.getElementById('avatarUrl').value;
            document.getElementById('profileImage').src = imageUrl;
        }

        // Validate function for form submission
        function validateForm() {
            let isValid = true;
            let errorMessage = '';

            // Clear any previous error messages
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
            const fullName = document.getElementById('password').value;
            if (fullName.trim() === '') {
                document.getElementById('fullNameError').textContent = 'Full name is required.';
                isValid = false;
            }

            // Validate Address (not empty)
            const address = document.getElementById('fullname').value;
            if (address.trim() === '') {
                document.getElementById('addressError').textContent = 'Address is required.';
                isValid = false;
            }

            // Validate Email
            const email = document.getElementById('address').value;
            if (!isValidEmail(email)) {
                document.getElementById('emailError').textContent = 'Please enter a valid email address.';
                isValid = false;
            }

            // Validate Phone Number
            const phone = document.getElementById('phone').value;
            if (!isValidPhone(phone)) {
                document.getElementById('phoneError').textContent = 'Please enter a valid phone number.';
                isValid = false;
            }

            // Validate Date of Birth
            const dob = document.getElementById('dob').value;
            if (!dob) {
                document.getElementById('dobError').textContent = 'Date of birth is required.';
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
            const phoneRegex = /^[0-9]{10,15}$/;
            return phoneRegex.test(phone);
        }
    </script>
</head>
<body>

    <h1>User Profile</h1>
    <!-- Image Section -->

    
    <form action="updateProfile" method="post" onsubmit="return validateForm()">
       <img id="profileImage" src="${user.avatar}" alt="Profile Picture" class="profile-img">
        <label for="avatarUrl">Image URL:</label>
       <input type="text" id="avatarUrl" name="avatarUrl" value="${user.avatar}" oninput="updateImagePreview()">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${user.userName}">
        
        <label for="password">Full Name:</label>
        <input type="text" id="fullname" name="fullname" value="${user.fullName}">
        
        <label for="fullname">Address:</label>
        <input type="text" id="address" name="address" value="${user.address}">
        
        <label for="address">Email:</label>
        <input type="text" id="email" name="email" value="${user.email}" readonly>
        
        <label for="gender">Gender:</label>
        <select id="gender" name="gender">
            <option value="true" ${user.gender == 'Male' ? 'selected' : ''}>Male</option>
            <option value="false" ${user.gender == 'Female' ? 'selected' : ''}>Female</option>
        </select>
        
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" value="${user.DOB}">
        
        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" value="${user.phone}">
        
        <button type="submit">Update Profile</button>
    </form>

</body>
</html>
