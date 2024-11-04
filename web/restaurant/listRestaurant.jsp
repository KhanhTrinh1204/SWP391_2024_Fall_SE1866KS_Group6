<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
 <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Management feedback</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
    </head>
    <body onload="showAlerts()">
        <div class="wrapper">
     
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
                <li>
                    <a href="<%=request.getContextPath()%>/feedback/list">
                        <i class="material-icons">feedback</i>
                        <span>Manage feedback</span>
                    </a>
                </li>
                
                <li>
                    <a href="<%=request.getContextPath()%>/tour/list">
                        <i class="material-icons">tour</i>
                        <span>Manage tour</span>
                    </a>
                </li>
                  <li>
                    <a href="<%=request.getContextPath()%>/hotel/list">
                        <i class="material-icons">hotel</i>
                        <span>Manage hotel</span>
                    </a>
                </li>
            </ul>
        </nav>


            <main id="content" class="p-4">
                  <!-- Top Navbar -->
                  <div class="top-navbar" style="height: 150px;" >
                <div class="xp-topbar" style="float: right;">
    <div class="row">
        <div>
            <div class="xp-profilebar">
                <nav class="navbar p-0">
                    <ul class="nav navbar-nav" >
                        <li class="nav-item" >
                            <a class="profile-button" onclick="toggleDropdown()">
                                <img  src="${pageContext.request.contextPath}/img/user.jpg" style="width:40px; border-radius:50%;" alt="User"/>
                            </a>
                            <div class="dropdown" id="dropdown" style ="display: none;">
                              <a href="${pageContext.request.contextPath}/viewProfile" style="color: white;">View Profile</a>
                               <a href="${pageContext.request.contextPath}/LogoutControl" style="color: white;"> Logout</a>
                              </div>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
                                              
                <div class="xp-breadcrumbbar text-center">
                    <h4 class="page-title">Manage restaurant</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Restaurant List</a></li>
                    </ol>
                </div>
            </div>
                        <br/>
            <form method="GET" action="<%=request.getContextPath()%>/restaurant/list" class="search-form d-flex align-items-center gap-2">
                    <div class="input-group" style="width: 60%;">
                        <label for="search" style="margin-left: 30px; margin-right: 20px;" class="visually-hidden">Search by name:</label>
                        <input type="text" id="search" class="form-control" name="search" placeholder="Search by name" aria-label="Search by name" value="${param.search}">
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
                                        <h2 class="ml-lg-2">Manage hotel</h2>
                                    </div>
                                    <div class="col-sm-6 p-0 d-flex justify-content-lg-end justify-content-center">
                                        <a href="<%=request.getContextPath()%>/restaurant/add" class="btn btn-success" data-toggle="modal">
                                            <i class="material-icons">&#xE147;</i> <span>Add New Hotel</span>
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
                                            <th style="width: 12%">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${res}" var="r" varStatus="status">
                                            <tr>
                                                <td>${status.index + 1}</td>
                                                <td>${r.restaurantName}</td>
                                                <td>${r.location}</td>
                                               <td><img src="${r.image}" alt="Restaurant Image" style="width: 100px; height: auto;"></td>
                                                <td>
                                                     <a href="<%=request.getContextPath()%>/restaurant/edit?id=${r.restaurantId}" ><i class="material-icons">inbox</i></a>
                                                    <a href="<%=request.getContextPath()%>/restaurant/detail?id=${r.restaurantId}" ><i class="material-icons">details</i></a>
                                                    <a href="#" onclick="deleteRestaurant('${r.restaurantId}')" ><i class="material-icons">deletes</i></a>
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
                                      <div class="pagination">
                    
                    <c:if test="${currentPage > 1}">
                        <a href="${pageContext.request.contextPath}/restaurant/list?page=${currentPage - 1}&search=${param.search}" class="btn btn-light">Previous</a>
                    </c:if>
                    <c:if test="${currentPage < totalPages}">
                        <a href="${pageContext.request.contextPath}/restaurant/list?page=${currentPage + 1}&search=${param.search}" class="btn btn-light">Next</a>
                         </c:if>
                </div>
                   
                         <c:if test="${totalPages > 0}">
        Showing page ${currentPage} of ${totalPages}
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
       

    <!-- Bootstrap JS and dependencies -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>
