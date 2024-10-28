<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Edit Staff</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
    <!-- Google Fonts -->
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
                <a href="${pageContext.request.contextPath}/staff/list" class="dashboard"><i class="material-icons">dashboard</i>
                    <span>Manage Staff</span></a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/vehicle/list"><i class="material-icons">date_range</i><span>Manage Vehicle</span></a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/restaurant/list"><i class="material-icons">library_books</i><span>Manage Restaurant</span></a>
            </li>
        </ul>
    </nav>
    <!-- Main Content -->
    <div class="container-fluid">
        <div id="content">
            <div class="top-navbar">
                <div class="xp-topbar">
                    <div class="row">
                        <div class="col-12 text-center">
                            <h4 class="page-title">Edit Staff Information</h4>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Main form for editing staff -->
            <div class="container my-4">
                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-danger">
                        ${errorMessage}
                    </div>
                </c:if>

                <form action="${pageContext.request.contextPath}/staff/edit" method="POST">
                    <input type="hidden" name="staffId" value="${staff.staffId}" />

                    <div class="form-group">
                        <label for="fullName">Full Name</label>
                        <input type="text" class="form-control" id="fullName" name="fullName" value="${staff.fullName}" required>
                    </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="${staff.email}" required>
                    </div>

                    <div class="form-group">
                        <label for="phoneNumber">Phone Number</label>
                        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${staff.phoneNumber}" required>
                    </div>

                    <div class="form-group">
                        <label for="address">Address</label>
                        <input type="text" class="form-control" id="address" name="address" value="${staff.address}" required>
                    </div>

                    <div class="form-group">
                        <label for="status">Status</label>
                        <select class="form-control" id="status" name="status">
                            <option value="true" <c:if test="${staff.status}">selected</c:if>>Active</option>
                            <option value="false" <c:if test="${not staff.status}">selected</c:if>>Inactive</option>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-primary">Update</button>
                    <a href="${pageContext.request.contextPath}/staff/list" class="btn btn-secondary">Cancel</a>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</div>
</body>
</html>
