<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Vehicle List</title>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- DataTable CSS -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
    </head>
    <body>

        <h1>Vehicle List</h1>
        <button class="btn btn-primary mb-3" data-toggle="modal" data-target="#addModal">Add Vehicle</button>

        <table id="table" class="table">
            <thead>
                <tr>
                    <th>Vehicle ID</th>
                    <th>Vehicle Name</th>
                    <th>Image</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Description</th>
                    <th>Travel Agent ID</th>
                    <th>Active</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="vehicle" items="${vehicles}">
                    <tr>
                        <td>${vehicle.vehicleId}</td>
                        <td>${vehicle.vehicleName}</td>
                        <td><img src="${vehicle.imgUrl}" alt="${vehicle.vehicleName}" width="100"/></td>
                        <td>${vehicle.startDate}</td>
                        <td>${vehicle.endDate}</td>
                        <td>${vehicle.description}</td>
                        <td>${vehicle.travelAgentId}</td>
                        <td>${vehicle.active ? 'Yes' : 'No'}</td>
                        <td>${vehicle.price}</td>
                        <td>
                            <button class="btn btn-warning" data-toggle="modal" data-target="#editModal${vehicle.vehicleId}">Edit</button>
                            <form action="list-vehicle" method="post" style="display:inline;">
                                <input type="hidden" name="vehicleId" value="${vehicle.vehicleId}" />
                                <input type="hidden" name="action" value="delete" />
                                <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this vehicle?');">Delete</button>
                            </form>
                            <div class="modal fade" id="editModal${vehicle.vehicleId}" tabindex="-1" role="dialog" aria-labelledby="editModalLabel${vehicle.vehicleId}" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="editModalLabel${vehicle.vehicleId}">Edit Vehicle - ${vehicle.vehicleName}</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="list-vehicle?action=edit" method="post">
                                                <input type="hidden" name="vehicleId" value="${vehicle.vehicleId}">

                                                <div class="form-group">
                                                    <label for="vehicleName${vehicle.vehicleId}">Vehicle Name:</label>
                                                    <input type="text" class="form-control" id="vehicleName${vehicle.vehicleId}" name="vehicleName" value="${vehicle.vehicleName}" required>
                                                </div>

                                                <div class="form-group">
                                                    <label for="imgUrl${vehicle.vehicleId}">Image URL:</label>
                                                    <input type="text" class="form-control" id="imgUrl${vehicle.vehicleId}" name="imgUrl" value="${vehicle.imgUrl}" required>
                                                </div>

                                                <div class="form-group">
                                                    <label for="startDate${vehicle.vehicleId}">Start Date:</label>
                                                    <input type="date" class="form-control" id="startDate${vehicle.vehicleId}" name="startDate" value="${vehicle.startDate}" required>
                                                </div>

                                                <div class="form-group">
                                                    <label for="endDate${vehicle.vehicleId}">End Date:</label>
                                                    <input type="date" class="form-control" id="endDate${vehicle.vehicleId}" name="endDate" value="${vehicle.endDate}">
                                                </div>

                                                <div class="form-group">
                                                    <label for="description${vehicle.vehicleId}">Description:</label>
                                                    <textarea class="form-control" id="description${vehicle.vehicleId}" name="description">${vehicle.description}</textarea>
                                                </div>

                                                <div class="form-group">
                                                    <label for="travelAgentId${vehicle.vehicleId}">Travel Agent ID:</label>
                                                    <input type="number" class="form-control" id="travelAgentId${vehicle.vehicleId}" name="travelAgentId" value="${vehicle.travelAgentId}" required>
                                                </div>

                                                <div class="form-check">
                                                    <input type="checkbox" class="form-check-input" id="active${vehicle.vehicleId}" name="active" ${vehicle.active ? 'checked' : ''}>
                                                    <label class="form-check-label" for="active${vehicle.vehicleId}">Active</label>
                                                </div>

                                                <div class="form-group">
                                                    <label for="price${vehicle.vehicleId}">Price:</label>
                                                    <input type="number" class="form-control" id="price${vehicle.vehicleId}" name="price" value="${vehicle.price}" step="0.01" required>
                                                </div>

                                                <button type="submit" class="btn btn-primary">Update Vehicle</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addModalLabel">Add Vehicle</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="list-vehicle?action=add" method="post">
                            <div class="form-group">
                                <label for="vehicleName">Vehicle Name:</label>
                                <input type="text" class="form-control" id="vehicleName" name="vehicleName" required>
                            </div>

                            <div class="form-group">
                                <label for="imgUrl">Image URL:</label>
                                <input type="text" class="form-control" id="imgUrl" name="imgUrl" required>
                            </div>

                            <div class="form-group">
                                <label for="startDate">Start Date:</label>
                                <input type="date" class="form-control" id="startDate" name="startDate" required>
                            </div>

                            <div class="form-group">
                                <label for="endDate">End Date:</label>
                                <input type="date" class="form-control" id="endDate" name="endDate">
                            </div>

                            <div class="form-group">
                                <label for="description">Description:</label>
                                <textarea class="form-control" id="description" name="description"></textarea>
                            </div>

                            <div class="form-group">
                                <label for="travelAgentId">Travel Agent ID:</label>
                                <input type="number" class="form-control" id="travelAgentId" name="travelAgentId" required>
                            </div>

                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="active" name="active">
                                <label class="form-check-label" for="active">Active</label>
                            </div>

                            <div class="form-group">
                                <label for="price">Price:</label>
                                <input type="number" class="form-control" id="price" name="price" step="0.01" required>
                            </div>

                            <button type="submit" class="btn btn-primary">Add Vehicle</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
        <!-- DataTables -->
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>
        <script>
                                    $(document).ready(function () {
                                        // Initialize DataTable
                                        $('#table').DataTable({
                                            "pagelength": 5,"lengthMenu": [5, 10, 20, 50], // Các tùy chọn số bản ghi trên mỗi trang mà người dùng có thể chọn
                                            "pagingType": "simple_numbers"
                                        });
                                    });
        </script>

    </body>
</html>
