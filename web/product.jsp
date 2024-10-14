<%-- 
    Document   : product
    Created on : Jan 19, 2024, 2:50:11 AM
    Author     : hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
      <script>
            // Function to show an alert when the successMessage is present
            window.onload = function() {
                var successMessage = "<%= request.getAttribute("successMessage") %>";
                if (successMessage) {
                    alert(successMessage);
                }
            }
        </script>
   
        <body>
          <a href="/SupportProject/ChangePassword.jsp">Change password</a>
             <a href="/SupportProject/viewProfile">View profile</a>
                <a href="/SupportProject/SendRequest.jsp">Send request</a>
               <a href="/SupportProject/LogoutControl">Log out</a>
    </body>
</html>
