<%-- 
    Document   : listTour
    Created on : Oct 20, 2024, 7:05:39 PM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Management</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
    </head>
    <body onload="showAlerts()">
        <div class="container-fluid">
            <header class="d-flex justify-content-between align-items-center py-3">
                <img src="img/logo.png" class="img-fluid" alt="Logo"/>
                <h1>Travel System</h1>
                <nav class="navbar navbar-expand">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="material-icons">notifications</span>
                                <span class="notification">4</span>
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <img src="img/user.jpg" style="width:40px; border-radius:50%;" alt="User"/>
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#"><span class="material-icons">person_outline</span>Profile</a>
                                <a class="dropdown-item" href="#"><span class="material-icons">settings</span>Settings</a>
                                <a class="dropdown-item" href="#"><span class="material-icons">logout</span>Logout</a>
                            </div>
                        </li>
                    </ul>
                </nav>
            </header>

            <nav id="sidebar" class="bg-light">
                <ul class="list-unstyled components">
                    <li>
                        <a href="<%=request.getContextPath()%>/feedback/list" class="dashboard">
                            <i class="material-icons">dashboard</i> Manage Feedback
                        </a>
                    </li>
                    <li class="active">
                        <a href="<%=request.getContextPath()%>/tour/list">
                            <i class="material-icons">date_range</i> Manage Tour
                        </a>
                    </li>
                </ul>
            </nav>

            <main id="content" class="p-4">
                <div class="breadcrumb mb-4">
                    <h4 class="page-title">Manage Tour</h4>
                </div>

                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h2>Manage Tours</h2>
                    <a href="${pageContext.request.contextPath}/tour/add" class="btn btn-success">Add Tour</a>
                </div>
                
                <!-- Form tìm kiếm -->
                <form  action="${pageContext.request.contextPath}/tour/list" method="GET"class="mb-4 d-flex align-items-center gap-2">
                    <input type="text" name="tourName" class="form-control" placeholder="Search by tour name" 
                           value="${param.tourName}" aria-label="Search by tour name">
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
                
                <!-- Bảng hiển thị danh sách tour -->
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Tour Name</th>
                            <th>Price</th>    
                            <th>Image</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tour" items="${tour}" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/tour/detail?id=${tour.tourId}">
                                        ${tour.tourName}
                                    </a>
                                </td> 
                                <td><fmt:formatNumber value="${tour.price}" type="currency" currencySymbol="$"/></td> 
                                <td>
                                    <c:if test="${not empty tour.image}">
                                        <img src="${pageContext.request.contextPath}/img/${tour.image}" alt="Tour Image" style="width: 100px; height: auto;">
                                    </c:if>
                                    <c:if test="${empty tour.image}">
                                        No Image
                                    </c:if>
                                </td>
                                <td>
                                    <a href="#" onclick="deleteTour('${tour.tourId}')" class="text-danger">Delete</a>
                                    <a href="${pageContext.request.contextPath}/tour/update?id=${tour.tourId}" class="text-danger">Update</a>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </main>
        </div>
    </body>
</html>
