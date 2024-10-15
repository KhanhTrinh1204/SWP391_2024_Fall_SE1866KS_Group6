<%-- 
    Document   : list
    Created on : Sep 21, 2024, 1:53:00 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Tours</title>
        <style>
            table {
                width: 50%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
                padding: 10px;
                text-align: center;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
        <script type="text/javascript">
            function deleteTour(id){
                if(confirm("ARE U SURE TO DELETE THIS TOUR"))
                window.location="delete?id="+id;
    }
        </script>
    </head>
    <body>
        <h1>List of Tours</h1>
        <h3><a href="addTour.jsp">Add Tour</a></h3>
        <table>
            <tr>
                <th>Tour ID</th>
                <th>Tour Name</th>
                <th> Action</th>
            </tr>
            <!-- Use JSTL to loop through the list of tours -->
            <c:forEach items="${tour}" var="tourItem">
                <tr>
                    <td>${tourItem.tourId}</td>
                    <td>${tourItem.tourName}</td>
                    <td>
                        <a href="detail?id=${tourItem.tourId}"> View Details</a> &nbsp;
                        <a href="#" onclick="deleteTour('${tourItem.tourId}')"> Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <!-- Handling case where the list is empty -->
        <c:if test="${empty tour}">
            <p>No tours available.</p>
        </c:if>
    </body>
</html>

