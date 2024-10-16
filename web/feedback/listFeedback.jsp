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
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">You have 5 new messages</a>
                                <a class="dropdown-item" href="#">You're now friends with Mike</a>
                                <a class="dropdown-item" href="#">Wish Mary on her birthday!</a>
                                <a class="dropdown-item" href="#">5 warnings in Server Console</a>
                            </div>
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
                    <li class="active">
                        <a href="<%=request.getContextPath()%>/feedback/list" class="dashboard">
                            <i class="material-icons">dashboard</i> Manage Feedback
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/tour/list">
                            <i class="material-icons">date_range</i> Manage Tour
                        </a>
                    </li>
                </ul>
            </nav>

            <main id="content" class="p-4">
                <div class="breadcrumb mb-4">
                    <h4 class="page-title">Manage Feedback</h4>
                    <ol class="breadcrumb">
                    </ol>
                </div>

                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h2>Manage Employees</h2>
                </div>

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
                                <td>
                                    <a href="${pageContext.request.contextPath}/feedback/delete?feedbackID=${feedback.feedbackId}" class="text-danger">Delete</a>
                                    <a href="#" class="text-primary" onclick="openModal('${feedback.feedbackId}', '${feedback.email}')">Response</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="pagination">
                    <c:if test="${currentPage > 1}">
                        <a href="ListFeedback?page=${currentPage - 1}&email=${param.email}&status=${param.status}" class="btn btn-light">Previous</a>
                    </c:if>
                    <c:if test="${currentPage < totalPages}">
                        <a href="ListFeedback?page=${currentPage + 1}&email=${param.email}&status=${param.status}" class="btn btn-light">Next</a>
                    </c:if>
                </div>

                <!-- Modal for response -->
                <div id="responseModal" class="modal">
                    <div class="modal-content">
                        <span class="close" onclick="closeModal()">&times;</span>
                        <form action="${pageContext.request.contextPath}/feedback/respond" method="post">
                            <input type="hidden" id="feedbackID" name="feedbackID">
                            <div class="form-group">
                                <label for="modalEmail">Email:</label>
                                <input type="text" id="modalEmail" name="email" class="form-control" readonly>
                            </div>
                            <div class="form-group">
                                <label for="responseText">Response:</label>
                                <textarea id="responseText" name="responseText" class="form-control" rows="4" required></textarea>
                            </div>
                            <input type="submit" class="btn btn-success" value="Send Response">
                        </form>
                    </div>
                </div>

                <script>
                    function openModal(feedbackID, email) {
                        document.getElementById('feedbackID').value = feedbackID;
                        document.getElementById('modalEmail').value = email;
                        document.getElementById('responseModal').style.display = 'block';
                    }

                    function closeModal() {
                        document.getElementById('responseModal').style.display = 'none';
                    }

                    function showAlerts() {
                    <c:if test="${not empty message}">
                        alert('${message}');
                    </c:if>
                    }
                </script>
            </main>
        </div>
    </body>
</html>
