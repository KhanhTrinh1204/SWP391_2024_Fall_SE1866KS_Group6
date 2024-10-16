<%-- 
    Document   : Login
    Created on : Feb 7, 2022, 10:43:59 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/login.css">
        <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
    </head>

    <body>
        <%-- Retrieve the alert message from the request attribute --%>



        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form  class="form-signup" action ="signup" method="post" onsubmit="return validateFormSignUp()">
                    <h1>Create Account</h1>

                    <span>or use your email for registration</span>
                    <input id="username" type="text" placeholder="Username" name="newuser" />
                    <input  id="email" type="email" placeholder="Email" name="email" />             
                    <input id="password" type="password" placeholder="Password" name="newpass"/>
                    <input id="repassword" type="password" placeholder="Re-Password" name="repass"/>
                    <input id="fullname" type="text" placeholder="Fullname" name="fullname"/>
                    <div class="radio-container">
                        <input type="radio" name="gender" value="1"/> Male
                        <input type="radio" name="gender" value="0" > Female
                    </div>
                    <input id="phone" type="text" value="${phone}" placeholder="Phone" name="phone" />
                    <input id="address" type="text" value="${address}" placeholder="Address" name="address" />
                    <button type="submit">Sign Up</button>
                    <% String alertMessage = (String)request.getAttribute("alertMessage");
    if (alertMessage != null && !alertMessage.isEmpty()) {
                    %>
                    <script>
                        alert('<%= alertMessage %>');
                    </script>
                    <% } %>

                </form>

            </div>
            <div class="form-container sign-in-container">
                <form class="form-signup" action ="login" method="post">
                    <h1>Sign in</h1>

                    <span>or use your account</span>
                    <input type="email"  value="${username}" placeholder="Enter email" name="user"/>
                    <input type="password" value="${password}" placeholder="Password" name="pass" />

                    <% String errorMessage = (String)request.getAttribute("errorMessage");
     if (errorMessage != null && !errorMessage.isEmpty()) {
                    %>
                    <h6 style="color: red;"><%= errorMessage %></h6>
                    <% } %>
                    <button type="submit">Sign In</button>
                    <a href="/SupportProject/EnterEmail.jsp">Forgot your password?</a>
                </form>

            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p>To keep connected with us please login with your personal details</p>
                        <button class="ghost" id="signIn">Sign In</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hi There!</h1>
                        <p>Enter your personal details to open an account with us</p>
                        <button class="ghost" id="signUp">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function validateFormSignUp() {
                // Username validation: max 20 characters
                const username = document.getElementById("username").value;
                if (username.length > 20) {
                    alert("Username must be 20 characters or fewer.");
                    return false;
                }

                // Email validation (simple pattern)
                const email = document.getElementById("email").value;
                const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!emailPattern.test(email)) {
                    alert("Please enter a valid email address.");
                    return false;
                }

                // Password validation: at least 8 characters, 1 uppercase letter, 1 number, 1 special character
                const password = document.getElementById("password").value;
                const passwordPattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
                if (!passwordPattern.test(password)) {
                    alert("Password must be at least 8 characters long, include 1 uppercase letter, 1 number, and 1 special character.");
                    return false;
                }

                // Confirm password validation
                const repassword = document.getElementById("repassword").value;
                if (password !== repassword) {
                    alert("Passwords do not match.");
                    return false;
                }

                // Phone number validation (example: only digits, 10-15 characters long)
                const phone = document.getElementById("phone").value;
                const phonePattern = /^\d{10,15}$/;
                if (!phonePattern.test(phone)) {
                    alert("Please enter a valid phone number (10-15 digits).");
                    return false;
                }

                // If all validations pass, the form can be submitted
                return true;
            }

        </script>
        <script charset="utf-8">

            const signUpButton = document.getElementById('signUp');
            const signInButton = document.getElementById('signIn');
            const container = document.getElementById('container');

            signUpButton.addEventListener('click', () => {
                container.classList.add("right-panel-active");
            });

            signInButton.addEventListener('click', () => {
                container.classList.remove("right-panel-active");
            });

        </script>
    </body>

</html>