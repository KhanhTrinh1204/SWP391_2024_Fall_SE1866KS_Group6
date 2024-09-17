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
                <form  class="form-signup" action ="signup" method="post">
                    <h1>Create Account</h1>

                    <span>or use your email for registration</span>
                    <input type="text" placeholder="Username" name="newuser" />
                    <input type="email" placeholder="Email" name="email" />             
                    <input type="password" placeholder="Password" name="newpass"/>
                     <input type="password" placeholder="Re-Password" name="repass"/>
                     <input type="text" placeholder="Fullname" name="fullname"/>
                        <div class="radio-container">
                            <input type="radio" name="gender" value="true"/> Male
        <input type="radio" name="gender" value="false" > Female
                        </div>
                     <input type="text" value="${phone}" placeholder="Phone" name="phone" />
                       <input type="text" value="${address}" placeholder="Address" name="address" />
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