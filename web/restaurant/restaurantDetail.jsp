<%-- 
    Document   : restaurantDetail
    Created on : Oct 13, 2024, 3:35:08 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Restaurant Detail</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div class="container">
            <h1>Restaurant Details</h1>

            <c:if test="${not empty restaurant}">
                <div class="restaurant-detail">
                    <h2>${restaurant.restaurantName}</h2>
                    <p><strong>Location:</strong> ${restaurant.location}</p>
                    <p><strong>Description:</strong> ${restaurant.description}</p>
                    <p><strong>Phone Number:</strong> ${restaurant.phoneNumber}</p>
                    <p><strong>Email:</strong> ${restaurant.email}</p>
                    <p><strong>Category:</strong> ${restaurant.category}</p>
                    <p><strong>Status:</strong> <c:choose>
                        <c:when test="${restaurant.status}">
                            Open
                        </c:when>
                        <c:otherwise>
                            Closed
                        </c:otherwise>
                    </c:choose></p>

                    <!-- Hiển thị hình ảnh nhà hàng -->
                    <c:if test="${not empty restaurant.image}">
                        <div class="restaurant-image">
                            <img src="${pageContext.request.contextPath}/img/${restaurant.image}" alt="Restaurant Image" style="width: 100px; height: auto;">
                        </div>
                    </c:if>
                </div>
            </c:if>

            <c:if test="${empty restaurant}">
                <p>Restaurant not found.</p>
            </c:if>

            <div class="back-btn">
                <a href="${pageContext.request.contextPath}/restaurant/list">Back to Restaurant List</a>
            </div>
        </div>
    </body>
</html>
