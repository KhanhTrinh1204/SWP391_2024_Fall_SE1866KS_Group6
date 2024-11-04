<%-- 
    Document   : listFeedback
    Created on : Oct 15, 2024, 4:58:29 PM
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
                    <h4 class="page-title">Manage Feedback</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Feedback List</a></li>
                    </ol>
                </div>
            </div>
                                                
                                                
            <br>


                <form action="${pageContext.request.contextPath}/feedback/list" method="get" class="mb-4">
                    <div class="form-row align-items-end">
                        <div class="col-md-4">
                            <label for="email">Email:</label>
                            <input type="text" class="form-control" id="email" name="email" placeholder="Enter email" value="${param.email}">
                        </div>
                        <div class="col-md-4">
                            <label for="status">Status:</label>
                            <select id="status" name="status" class="form-control">
                                <option value="">All</option>
                                <option value="1" ${param.status == 1 ? 'selected' : ''}>Responding</option>
                                <option value="0" ${param.status == 0 ? 'selected' : ''}>No response</option>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <input type="submit" class="btn btn-primary mt-4" value="Search">
                        </div>
                    </div>
                </form>

                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Email</th>
                            <th>Title</th>
                            <th>Date</th>
                            <th>Description</th>
                            <th>Response</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="feedback" items="${feedbacks}">
                            <tr>
                
                                <td>${feedback.email}</td> 
                                <td>${feedback.title}</td> 
                                <td>${feedback.date}</td>   
                                <td>${feedback.description}</td> 
                                <td>${feedback.response}</td> 
                                <td>
                                    <c:choose>
                                        <c:when test="${feedback.status}">Responding</c:when>
                                        <c:otherwise>No response</c:otherwise>
                                    </c:choose>
                                </td>
                                <td style="display: flex; gap: 10px; font-size: 15px;">
                                    <a href="${pageContext.request.contextPath}/feedback/delete?feedbackID=${feedback.feedbackId}">   <i class="material-icons">deletes </i></a> 
                                    <a href="#" onclick="openModal('${feedback.feedbackId}', '${feedback.email}')"><i class="material-icons">inbox</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="pagination">
                    
                    <c:if test="${currentPage > 1}">
                        <a href="${pageContext.request.contextPath}/feedback/list?page=${currentPage - 1}&email=${param.email}&status=${param.status}" class="btn btn-light">Previous</a>
                    </c:if>
                    <c:if test="${currentPage < totalPages}">
                        <a href="${pageContext.request.contextPath}/feedback/list?page=${currentPage + 1}&email=${param.email}&status=${param.status}" class="btn btn-light">Next</a>
                         </c:if>
                </div>
                   
                         <c:if test="${totalPages > 0}">
        Showing page ${currentPage} of ${totalPages}
    </c:if>
<!-- Add styles for modal pop-up -->
<style>
    /* Dropdown Menu Styling */
.dropdown-menu {
    display: none; /* Initially hidden */
    position: absolute; /* Position it relative to its nearest positioned ancestor */
    right: 0; /* Align to the right of the profile link */
    z-index: 1000; /* Ensure it appears above other elements */
    background-color: white; /* White background */
    border: 1px solid #ccc; /* Border styling */
    border-radius: 4px; /* Rounded corners */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
    min-width: 150px; /* Minimum width */
}

/* Display the dropdown when active */
.dropdown-menu.show {
    display: block; /* Show the dropdown */
}

/* Dropdown Item Styling */
.dropdown-menu li {
    padding: 10px; /* Padding for items */
}

.dropdown-menu li a {
    text-decoration: none; /* Remove underline from links */
    color: #333; /* Text color */
    display: block; /* Make the link fill the container */
}

.dropdown-menu li a:hover {
    background-color: #f1f1f1; /* Background color on hover */
}

    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        background-color: rgba(0,0,0,0.5); /* Black background with opacity */
        overflow: auto; /* Enable scroll if needed */
    }
    .modal-content {
        background-color: #fff;
        margin: 15% auto; /* 15% from the top and centered */
        padding: 20px;
        border: 1px solid #888;
        width: 50%; /* Could be more or less, depending on screen size */
    }
    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }
    .close:hover,
    .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
    }
    
</style>

                <!-- Modal for response -->
                <div id="responseModal" class="modal">
                    <div class="modal-content">
                        <span class="close" onclick="closeModal()">&times;</span>
                        <form action="${pageContext.request.contextPath}/ResponseControl" method="post">
                            <input type="hidden" id="feedbackID" name="feedbackID">
                            <div class="form-group">
                                <label for="modalEmail">Email:</label>
                                <input type="text" id="modalEmail" name="email" class="form-control" readonly>
                            </div>
                            <div class="form-group">
                                <label for="responseText">Response:</label>
                                <textarea id="response" name="response" class="form-control" rows="4" required></textarea>
                            </div>
                            <input type="submit" class="btn btn-success" value="Send Response">
                        </form>
                    </div>
                </div>

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


                    function openModal(feedbackID, email) {
                        document.getElementById('feedbackID').value = feedbackID;
                        document.getElementById('modalEmail').value = email;
                        document.getElementById('responseModal').style.display = 'block';
                    }

                    function closeModal() {
                        document.getElementById('responseModal').style.display = 'none';
                    }

                    function showAlerts() {
            const urlParams = new URLSearchParams(window.location.search);

            // Check for delete success/failure
            const deleteSuccess = urlParams.get('deleteSuccess');
            if (deleteSuccess === 'true') {
                alert('Feedback deleted successfully.');
            } else if (deleteSuccess === 'false') {
                alert('Failed to delete feedback.');
            }

            // Check for email success/failure
            const emailSuccess = urlParams.get('emailSuccess');
            if (emailSuccess === 'true') {
                alert('Email sent successfully.');
            } else if (emailSuccess === 'false') {
                alert('Failed to send email.');
            }
        }
                </script>
            </main>
        </div>
                            </div>
    </body>
</html>
