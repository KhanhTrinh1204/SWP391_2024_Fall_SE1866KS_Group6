<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
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
</head>
<body>

    <h1>Update Profile</h1>
    
    <form action="updateProfile" method="post" onsubmit="return validateForm()">
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

</body>
</html>
