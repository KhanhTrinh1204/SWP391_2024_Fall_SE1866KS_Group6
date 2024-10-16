<%-- 
    Document   : editStaff
    Created on : Sep 30, 2024, 11:13:39 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>Management</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <!-- Google Material Icons -->
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <!-- Sidebar -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3><img src="img/logo.png" class="img-fluid"/><span>Travel System</span></h3>
        </div>
        <ul class="list-unstyled components">
            <li class="active">
                <a href="<%=request.getContextPath()%>/staff/list" class="dashboard"><i class="material-icons">dashboard</i>
                    <span>Manage Staff</span></a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/vehicle/list"><i class="material-icons">date_range</i><span>Manage Vehicle</span></a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/restaurant/list"><i class="material-icons">library_books</i><span>Manage Restaurant</span></a>
            </li>
        </ul>
    </nav>
    <!-- Main Content -->
    <div class="container-fluid">
        <div id="content">
            <div class="top-navbar">
                <div class="xp-topbar">
                    <div class="row">
                        <div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
                            <div class="xp-menubar">
                                <span class="material-icons text-white">signal_cellular_alt</span>
                            </div>
                        </div>
                        <div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">
                            <div class="xp-profilebar text-right">
                                <nav class="navbar p-0">
                                    <ul class="nav navbar-nav flex-row ml-auto">
                                        <li class="dropdown nav-item active">
                                            <a href="#" class="nav-link" data-toggle="dropdown">
                                                <span class="material-icons">notifications</span>
                                                <span class="notification">4</span>
                                            </a>
                                            <ul class="dropdown-menu">
                                                <li><a href="#">You have 5 new messages</a></li>
                                                <li><a href="#">You're now friend with Mike</a></li>
                                                <li><a href="#">Wish Mary on her birthday!</a></li>
                                                <li><a href="#">5 warnings in Server Console</a></li>
                                            </ul>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">
                                                <span class="material-icons">question_answer</span>
                                            </a>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link" href="#" data-toggle="dropdown">
                                                <img src="img/user.jpg" style="width:40px; border-radius:50%;"/>
                                                <span class="xp-user-live"></span>
                                            </a>
                                            <ul class="dropdown-menu small-menu">
                                                <li><a href="#"><span class="material-icons">person_outline</span>Profile</a></li>
                                                <li><a href="#"><span class="material-icons">settings</span>Settings</a></li>
                                                <li><a href="#"><span class="material-icons">logout</span>Logout</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="xp-breadcrumbbar text-center">
                    <h4 class="page-title">Manage Staff</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Staff List</a></li>
                    </ol>
                </div>
            </div>
        <!-- Nội dung chính -->
        <div class="container">
            <h2>Edit Staff Information</h2>

            <c:if test="${not empty errorMessage}">
                <div class="error-message">
                    <p>${errorMessage}</p>
                </div>
            </c:if>

            <form action="${pageContext.request.contextPath}/staff/edit" method="POST">
                 <input type="hidden" name="restaurantId" value="${res.restaurantId}" />
        
        <label for="restaurantName">Tên Nhà Hàng:</label>
        <input type="text" name="restaurantName" id="restaurantName" value="${res.restaurantName}" required><br><br>

        <label for="location">Địa Chỉ:</label>
        <input type="text" name="location" id="location" value="${res.location}" required><br><br>

        <label for="description">Mô Tả:</label>
        <textarea name="description" id="description" required>${res.description}</textarea><br><br>

        <label for="phoneNumber">Số Điện Thoại:</label>
        <input type="text" name="phoneNumber" id="phoneNumber" value="${res.phoneNumber}" required><br><br>

        <label for="email">Email:</label>
        <input type="email" name="email" id="email" value="${res.email}" required><br><br>

        <label for="category">Thể Loại:</label>
        <input type="text" name="category" id="category" value="${res.category}" required><br><br>

        <label for="status">Trạng Thái:</label>
        <select name="status" id="status">
            <option value="true" <c:if test="${res.status}">selected</c:if>>Hoạt Động</option>
            <option value="false" <c:if test="${not res.status}">selected</c:if>>Ngừng Hoạt Động</option>
        </select><br><br>

        <label for="image">Hình Ảnh:</label>
        <input type="file" name="image" id="image"><br><br>
        
        <input type="hidden" name="currentImage" value="${res.image}"> <!-- Giữ tên hình ảnh hiện tại -->

        <button type="submit">Cập Nhật</button>
            </form>

            <div class="form-group">
                <a href="${pageContext.request.contextPath}/staff/list" class="btn-back">Back to Staff List</a>
            </div>
        </div>

        <script>
            function showUpdateAlert() {
                alert("Staff details updated successfully!");
            }
        </script>
    </body>
</html>