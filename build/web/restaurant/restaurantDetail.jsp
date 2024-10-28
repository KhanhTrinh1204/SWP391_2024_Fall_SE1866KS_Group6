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
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Restaurant Details</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <!-- Custom CSS --
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
        <!-- Google Material Icons -->
        <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div id="content">

                <div class="top-navbar">
                    <div class="xp-topbar">
                        <div class="row">
                            <div class="col-12 text-center">
                                <h4 class="page-title">Restaurant Details</h4>
                            </div>
                        </div>
                    </div>
                </div>

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
