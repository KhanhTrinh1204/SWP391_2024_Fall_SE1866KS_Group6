<%-- 
    Document   : listStaff
    Created on : Sep 30, 2024, 7:55:21 PM
    Author     : ASUS
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Nhân viên</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
    <script type="text/javascript">
            function deleteStaff(id){
                if(confirm("ARE U SURE TO DELETE THIS STAFF"))
                window.location="delete?id="+id;
    }
        </script>
</head>
<body>

<h2>Staff List</h2>
<h3><a href="addStaff.jsp">Add Staff</a></h3>

<c:if test="${not empty staff}">
    <table>
        <thead>
            <tr>
                <th><center>Staff ID</center></th>
                <th><center>Email</center></th>
                <th><center>Status</center></th>
                <th><center>Action</center></th>
</tr>
        </thead>
        <tbody>
            <c:forEach items="${staff}" var="s">
                <tr>
                    <td>${s.staffId}</td>
                    <td>${s.email}</td>
                    <td>
                        <c:choose>
                            <c:when test="${s.active == true}">
                                Active
                            </c:when>
                            <c:otherwise>
                                De-Active
                            </c:otherwise>
                        </c:choose>
                    </td>
                     <td>
                        <a href= "<%=request.getContextPath()%>/staff/edit?id=${s.staffId}"> Update</a> &nbsp;
                        <a href="#" onclick="deleteStaff('${s.staffId}')"> Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty staff}">
    <p>There're no staff right now.</p>
</c:if>

</body>
</html>
