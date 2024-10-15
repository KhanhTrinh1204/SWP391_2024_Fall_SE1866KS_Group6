<%-- 
    Document   : editStaff
    Created on : Sep 30, 2024, 11:13:39 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Staff</title>
</head>
<body>
    <h2>Update Staff Information</h2>

    <c:if test="${not empty errorMessage}">
        <p style="color:red">${errorMessage}</p>
    </c:if>
    
    <form action="${pageContext.request.contextPath}/staff/edit" method="post">
        <input type="hidden" name="staffId" value="${staff.staffId}" />
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${staff.email}" required />
        <br/>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="${staff.password}" required />
        <br/>
        
        <label for="active">Active:</label>
        <input type="checkbox" id="active" name="active" <c:if test="${staff.active}">checked</c:if> />
        <br/>
        
        <label for="roleId">Role:</label>
        <select id="roleId" name="roleId">
            <option value="4" ${staff.role.roleId == 4 ? "selected" : ""}>Staff</option>
        </select>
        <br/>
        
        <input type="submit" value="Update Staff" />
    </form>
    
    <a href="${pageContext.request.contextPath}/staff/list">Back to Staff List</a>
</body>
</html>




