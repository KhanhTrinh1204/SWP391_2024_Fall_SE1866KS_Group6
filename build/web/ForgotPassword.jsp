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
                <form action="ConfirmPassWord" method="post">
                    <h1>Verification</h1>
                    <input type="text" name="authcode" placeholder="Verification"></input>
                    <input type="text" name="confirm" placeholder="New-Password"></input>
                    <input type="text" name="reconfirm" placeholder="ReNew-Password"></input>
                    <% String errorMessage = (String)request.getAttribute("errorMessage");
      if (errorMessage != null && !errorMessage.isEmpty()) {
                    %>
                     <h6 style="color: red;"><%= errorMessage %></h6>
                    <% } %>
                    <button type="submit" >Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
