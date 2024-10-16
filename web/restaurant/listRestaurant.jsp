<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>Manage Restaurants</title>
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
                <h3><img src="${pageContext.request.contextPath}/img/logo.png" class="img-fluid" alt="Logo"/><span>Travel System</span></h3>
            </div>
            <ul class="list-unstyled components">
                <li class="active">
                    <a href="<%=request.getContextPath()%>/staff/list" class="dashboard">
                        <i class="material-icons">dashboard</i>
                        <span>Manage Staff</span>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/vehicle/list">
                        <i class="material-icons">date_range</i>
                        <span>Manage Vehicle</span>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/restaurant/list">
                        <i class="material-icons">library_books</i>
                        <span>Manage Restaurant</span>
                    </a>
                </li>
            </ul>
        </nav>

        <!-- Main Content -->
        <div id="content">
            <!-- Top Navbar -->
            <div class="top-navbar">
                <div class="xp-topbar">
                    <div class="row">
                        <div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
                            <div class="xp-menubar">
                                <span class="material-icons text-white">signal_cellular_alt</span>
                            </div>
                        </div>
                        <div class="col-md-5 col-lg-3 order-3 order-md-2"></div>
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
                                                <li><a href="#">You're now friends with Mike</a></li>
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
                                                <img src="${pageContext.request.contextPath}/img/user.jpg" style="width:40px; border-radius:50%;" alt="User"/>
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
                    <h4 class="page-title">Manage Restaurants</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Restaurant List</a></li>
                    </ol>
                </div>
            </div>
            <br>

            <!-- Search Form -->
            <form method="GET" action="<%=request.getContextPath()%>/restaurant/list" class="search-form d-flex align-items-center gap-2 mb-4">
                <div class="input-group">
                    <label for="search" class="visually-hidden">Search by name:</label>
                    <input type="text" id="search" class="form-control" name="search" placeholder="Search by name" aria-label="Search by name">
                </div>
                <div class="input-group">
                    <label for="statusFilter" class="visually-hidden">Status Filter:</label>
                    <select id="statusFilter" class="form-select" name="statusFilter">
                        <option value="">All Statuses</option>
                        <option value="true">Active</option>
                        <option value="false">De-Active</option>
                    </select>
                </div>
                <button class="btn btn-outline-secondary" type="submit">Search</button>
            </form>

            <!-- Main Table -->
            <div class="main-content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-wrapper">
                            <div class="table-title">
                                <div class="row">
                                    <div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
                                        <h2 class="ml-lg-2">Manage Restaurants</h2>
                                    </div>
                                    <div class="col-sm-6 p-0 d-flex justify-content-lg-end justify-content-center">
                                        <a href="<%=request.getContextPath()%>/restaurant/add" class="btn btn-success" data-toggle="modal">
                                            <i class="material-icons">&#xE147;</i> <span>Add New Restaurant</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <c:if test="${not empty res}">
                                <table class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Restaurant Name</th>
                                            <th>Location</th>
                                            <th>Image</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${res}" var="r" varStatus="status">
                                            <tr>
                                                <td>${status.index + 1}</td>
                                                <td>${r.restaurantName}</td>
                                                <td>${r.location}</td>
                                                <td>
                                                    <img src="${pageContext.request.contextPath}/img/${r.image}" alt="Restaurant Image" style="width: 100px; height: auto;">
                                                </td>
                                                <td>
                                                    <a href="<%=request.getContextPath()%>/restaurant/detail?id=${r.restaurantId}" class="btn btn-info btn-sm">View Details</a>
                                                    <a href="#" onclick="deleteRestaurant('${r.restaurantId}')" class="btn btn-danger btn-sm">Delete</a>
                                                    <a href="<%=request.getContextPath()%>/restaurant/edit?id=${r.restaurantId}" class="btn btn-warning btn-sm">Edit</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>

                            <c:if test="${empty res}">
                                <p>No restaurants found.</p>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>

            <script type="text/javascript">
                function deleteRestaurant(id) {
                    if (confirm("ARE YOU SURE TO DELETE THIS RESTAURANT?")) {
                        window.location = '<%=request.getContextPath()%>/restaurant/delete?id=' + id;
                    }
                }
            </script>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>
