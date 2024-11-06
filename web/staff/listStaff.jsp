<%-- 
    Document   : listTour
    Created on : Oct 20, 2024, 7:05:39 PM
    Author     : ASUS
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
      <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Management tour</title>
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
                        <span>Manage User</span>
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
                <li>
                    <a href="<%=request.getContextPath()%>/booking/list">
                        <i class="material-icons">tour</i>
                        <span>Manage booking tour</span>
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
                    <h4 class="page-title">Manage staff</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Staff List</a></li>
                    </ol>
                </div>
            </div>
                                                
                                                
            <br>
             <form action="${pageContext.request.contextPath}/staff/list" method="get" class="mb-4">
                    <div class="form-row align-items-end">
                        <div class="col-md-4">
                            <label for="email">Email:</label>
                            <input type="text" class="form-control" id="email" name="email" placeholder="Enter email" value="${param.email}">
                        </div>
                        <div class="col-md-4">
                            <label for="status">Status:</label>
                            <select id="status" name="status" class="form-control">
                                <option value="">All</option>
                                <option value="1" ${param.status == 1 ? 'selected' : ''}>Active</option>
                                <option value="0" ${param.status == 0 ? 'selected' : ''}>No active</option>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <input type="submit" class="btn btn-primary mt-4" value="Search">
                        </div>
                    </div>
                </form>
 <div class="main-content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-wrapper">
                                <div class="table-title">
                                    <div class="row">
                                        <div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
                                            <h2 class="ml-lg-2">Manage Tour</h2>
                                        </div>
                                          <div class="col-sm-6 p-0 d-flex justify-content-lg-end justify-content-center">
                                            <a href="<%=request.getContextPath()%>/staff/add" class="btn btn-success" data-toggle="modal">
                                                <i class="material-icons">&#xE147;</i> <span>Add New Account</span></a>
                                        </div>
                                    </div>
                                </div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Email</th>
                            <th>UserName</th>
                            <th>FullName</th>
                            <th>Address</th>
                            <th>Role</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="account" items="${accounts}">
                            <tr>
                
                                <td>${account.email}</td> 
                                <td>${account.userName}</td> 
                                <td>${account.fullName}</td>   
                                <td>${account.address}</td> 
                                 <td>
                                    <c:choose>
                                        <c:when test="${account.roleID == '1'}">Customer</c:when>
                                        <c:otherwise>Admin</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${account.status == '1'}">Active</c:when>
                                        <c:otherwise>In Active</c:otherwise>
                                    </c:choose>
                                </td>
                                <td style="display: flex; gap: 10px; font-size: 15px;">
                                  
                                   <a href="<%=request.getContextPath()%>/staff/edit?email=${account.email}"><i class="material-icons">inbox</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="pagination">
                    
                    <c:if test="${currentPage > 1}">
                        <a href="${pageContext.request.contextPath}/staff/list?page=${currentPage - 1}&email=${param.email}&status=${param.status}" class="btn btn-light">Previous</a>
                    </c:if>
                    <c:if test="${currentPage < totalPages}">
                        <a href="${pageContext.request.contextPath}/staff/list?page=${currentPage + 1}&email=${param.email}&status=${param.status}" class="btn btn-light">Next</a>
                         </c:if>
                </div>
                   
                         <c:if test="${totalPages > 0}">
        Showing page ${currentPage} of ${totalPages}
    </c:if>
                                    </div>
                    </div>
                </div>
                <script type="text/javascript">
                    function deleteStaff(id) {
                        if (confirm("ARE YOU SURE TO DELETE THIS STAFF"))
                            window.location.href = '<%=request.getContextPath()%>/staff/delete?id=' + id;
                    }
                </script>
        <script>
                   function toggleDropdown() {
    const dropdown = document.getElementById("dropdown");
    dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
    if (!event.target.matches('.profile-button')) {
        const dropdown = document.getElementById("dropdown");
        if (dropdown.style.display === "block") {
            dropdown.style.display = "none";
        }
    }
};

        }
                </script>
    </body>
</html>
