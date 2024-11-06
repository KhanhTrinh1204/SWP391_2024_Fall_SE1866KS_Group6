<%-- 
    Document   : AddHotel
    Created on : Sep 24, 2024, 10:48:06 PM
    Author     : ACER
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <title>Management Restaurant</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
   <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
   <style>
       body {
           background-color: #f8f9fa;
           font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
       }
       .container {
           max-width: 600px;
           margin-top: 50px;
           padding: 30px;
           background-color: #ffffff;
           border-radius: 10px;
           box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
       }
       .form-control:focus {
           box-shadow: none;
           border-color: #4CAF50;
       }
       .btn-submit {
           background-color: #4CAF50;
           border: none;
           transition: background-color 0.3s;
       }
       .btn-submit:hover {
           background-color: #45a049;
       }
       .error-message {
           color: #dc3545;
           margin-top: 10px;
       }
       .success-message {
           color: #28a745;
           margin-top: 10px;
       }
       .input-group-text {
           background-color: #e9ecef;
       }
   </style>
</head>
<body>
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
                  <span>Manage Feedback</span>
               </a>
            </li>
            <li>
               <a href="<%=request.getContextPath()%>/tour/list">
                  <i class="material-icons">tour</i>
                  <span>Manage Tour</span>
               </a>
            </li>
            <li>
               <a href="<%=request.getContextPath()%>/hotel/list">
                  <i class="material-icons">hotel</i>
                  <span>Manage Hotel</span>
               </a>
            </li>
            <li>
               <a href="<%=request.getContextPath()%>/booking/list">
                  <i class="material-icons">tour</i>
                  <span>Manage Booking Tour</span>
               </a>
            </li>
         </ul>
      </nav>

      <main id="content" class="p-4">
         <div class="top-navbar" style="height: 150px;">
            <div class="xp-topbar" style="float: right;">
               <div class="row">
                  <div>
                     <div class="xp-profilebar">
                        <nav class="navbar p-0">
                           <ul class="nav navbar-nav">
                              <li class="nav-item">
                                 <a class="profile-button" onclick="toggleDropdown()">
                                    <img src="${pageContext.request.contextPath}/img/user.jpg" style="width:40px; border-radius:50%;" alt="User"/>
                                 </a>
                                 <div class="dropdown" id="dropdown" style="display: none;">
                                    <a href="${pageContext.request.contextPath}/viewProfile" style="color: white;">View Profile</a>
                                    <a href="${pageContext.request.contextPath}/LogoutControl" style="color: white;">Logout</a>
                                 </div>
                              </li>
                           </ul>
                        </nav>
                     </div>
                  </div>
               </div>
            </div>
            <div class="xp-breadcrumbbar text-center">
               <h4 class="page-title">Manage Restaurant</h4>
               <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Restaurant List</a></li>
               </ol>
            </div>
         </div>

         <form action="<%=request.getContextPath()%>/hotel/add" method="POST" onsubmit="return validateForm()">
            <div class="mb-3">
               <label for="hotelName" class="form-label">Hotel Name(*):</label>
               <input type="text" class="form-control" id="hotelName" name="hotelName" placeholder="Enter hotel name" required>
               <div class="invalid-feedback">Please enter the hotel name.</div>
            </div>

            <div class="mb-3">
               <label for="imgUrl" class="form-label">Image URL(*):</label>
               <input type="text" class="form-control" id="imgUrl" name="imgUrl" placeholder="Enter image URL" required>
               <div class="invalid-feedback">Please enter the image URL.</div>
            </div>

            <div class="mb-3">
               <label for="description" class="form-label">Description(*):</label>
               <textarea class="form-control" id="description" name="description" rows="3" placeholder="Enter description" required></textarea>
               <div class="invalid-feedback">Please enter the description.</div>
            </div>

            <div class="mb-3">
               <label for="startDate" class="form-label">Start Date(*):</label>
               <input type="date" class="form-control" id="startDate" name="startDate" required>
               <div class="invalid-feedback">Please select a start date.</div>
            </div>

            <div class="mb-3">
               <label for="endDate" class="form-label">End Date(*):</label>
               <input type="date" class="form-control" id="endDate" name="endDate" required>
               <div class="invalid-feedback">Please select an end date.</div>
            </div>

            <div class="mb-3">
               <label for="active" class="form-label">Active</label>
               <input type="checkbox" class="form-check-input" id="active" name="active">
            </div>

            <div class="mb-3">
               <label for="price" class="form-label">Price(*):</label>
               <input type="number" step="0.01" class="form-control" id="price" name="price" placeholder="Enter price" required>
               <div class="invalid-feedback">Please enter the price.</div>
            </div>

            <button type="submit" class="btn btn-submit w-100">Add Hotel</button>
         </form>

         <script>
            function toggleDropdown() {
               const dropdown = document.getElementById("dropdown");
               dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
            }

            window.onclick = function(event) {
               if (!event.target.matches('.profile-button')) {
                  const dropdown = document.getElementById("dropdown");
                  if (dropdown.style.display === "block") {
                     dropdown.style.display = "none";
                  }
               }
            };

            function validateForm() {
               const hotelName = document.getElementById("hotelName").value.trim();
               const imgUrl = document.getElementById("imgUrl").value.trim();
               const description = document.getElementById("description").value.trim();
               const startDate = document.getElementById("startDate").value;
               const endDate = document.getElementById("endDate").value;
                const price = document.getElementById("price").value;
               // Check for empty fields
               if (hotelName.trim() === "") {
                  alert("Hotel Name is required.");
                  return false;
               if (imgUrl.trim() === "") {
                  alert("Image URL is required.");
                  return false;
               }
               if (description.trim() === "") {
                  alert("Description is required.");
                  return false;
               }

               // Check start and end dates
               if (startDate.trim() === "") {
                  alert("Start Date is required.");
                  return false;
               }
               if (endDate.trim() === "") {
                  alert("End Date is required.");
                  return false;
               }

               // Check if end date is later than start date
               const start = new Date(startDate);
               const end = new Date(endDate);
               if (end <= start) {
                  alert("End Date must be later than Start Date.");
                  return false;
               }
                if (price.trim() === "") {
                  alert("Price is required.");
                  return false;
               }
               return true; // If all checks pass
            }
         </script>
      </main>
   </div>
</body>
</html>
