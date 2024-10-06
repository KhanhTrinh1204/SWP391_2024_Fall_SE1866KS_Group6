<%-- 
    Document   : verify
    Created on : Jan 18, 2024, 11:42:30 PM
    Author     : hoang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Forgot Password page</title>
        <link rel="stylesheet" href="css/verify.css">
        <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
    </head>
    <body>
        <div class="container" id="container">
            <div class="form-container sign-in-container">
                <form action="ChangePasswordControl" method="post">
                    <h1>Change password</h1>
                    <input type="password"  name="oldpass" placeholder="Old-Password"></input>
                    <input type="password" id="confirm"  name="confirm" placeholder="New-Password"></input>
                    <input type="password"  id="reconfirm" name="reconfirm" placeholder="ReNew-Password"></input>
                    <% String errorMessage = (String)request.getAttribute("errorMessage");
      if (errorMessage != null && !errorMessage.isEmpty()) {
                    %>
                     <h6 style="color: red;"><%= errorMessage %></h6>
                    <% } %>
                    <button type="submit" >Submit</button>
                </form>
            </div>
        </div>
                       <script>
            function validateFormPasswordReset() {
// Verification code validation (not empty)
                const authcode = document.getElementById("authcode").value.trim();
                if (authcode === "") {
                    alert("Verification code cannot be empty.");
                    return false;
                }

// New password validation: at least 8 characters, 1 uppercase letter, 1 number, 1 special character
                const newPassword = document.getElementById("confirm").value.trim();
                if (newPassword === "") {
                    alert("New password cannot be empty.");
                    return false;
                }
                const passwordPattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
                if (!passwordPattern.test(newPassword)) {
                    alert("New password must be at least 8 characters long, include 1 uppercase letter, 1 number, and 1 special character.");
                    return false;
                }

// Confirm password validation
                const rePassword = document.getElementById("reconfirm").value.trim();
                if (rePassword === "") {
                    alert("Please confirm your new password.");
                    return false;
                }
                if (newPassword !== rePassword) {
                    alert("Passwords do not match.");
                    return false;
                }

// If all validations pass, the form can be submitted
                return true;
            }


        </script>
    </body>
</html>
