<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }

        /* Form Styles */
        form {
            width: 60%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            font-size: 16px;
        }

        form label {
            display: block;
            margin: 10px 0 5px;
            color: #555;
        }

        form input[type="text"],
        form select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        form input[type="submit"],
        button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        form input[type="submit"]:hover,
        button:hover {
            background-color: #218838;
        }

        /* Table Styles */
        table {
            width: 65%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        td img {
            width: 50px;
            height: 50px;
            border-radius: 50%;
        }

        tr:hover {
            background-color: #f9f9f9;
        }

        /* Pagination Styles */
        .pagination {
            text-align: center;
            margin: 20px 0;
        }

        .pagination a {
            padding: 10px 15px;
            color: #007bff;
            text-decoration: none;
            border: 1px solid #007bff;
            border-radius: 4px;
            margin: 0 5px;
        }

        .pagination a:hover {
            background-color: #007bff;
            color: white;
        }

        /* Status Action Styles */
        .status-action {
            display: inline-block;
            padding: 6px 12px;
            background-color: #f0f0f0;
            color: #007bff;
            text-decoration: none;
            border-radius: 4px;
            border: 1px solid #ccc;
            margin: 0 5px;
            transition: background-color 0.3s ease;
        }

        .status-action:hover {
            background-color: #e0e0e0;
            color: #0056b3;
        }
  table {
            width: 80%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        /* Setting specific widths for each column */
        th:nth-child(1), td:nth-child(1) { width: 20%; } /* Email */
        th:nth-child(2), td:nth-child(2) { width: 15%; } /* Title */
        th:nth-child(3), td:nth-child(3) { width: 10%; } /* Date */
        th:nth-child(4), td:nth-child(4) { width: 25%; } /* Description */
        th:nth-child(5), td:nth-child(5) { width: 15%; } /* Response */
        th:nth-child(6), td:nth-child(6) { width: 10%; } /* Status */
        th:nth-child(7), td:nth-child(7) { width: 15%; } /* Action */
        
        /* Optional: Set word wrapping for long text */
        td {
            word-wrap: break-word;
        }

        /* Modal Styles */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
        }

        .modal-content {
            background-color: white;
            margin: 10% auto;
            padding: 20px;
            width: 50%;
            border-radius: 8px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
        }

        .close {
            float: right;
            font-size: 20px;
            cursor: pointer;
        }

        .close:hover {
            color: red;
        }
        .modal-content textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
    font-size: 16px;
    resize: vertical; /* Allow vertical resizing, but disable horizontal resizing */
}
    </style>
</head>
<body onload="showAlerts()">
    <h2>Accounts Information</h2>

    <!-- Form to capture email and status input -->
    <form action="ListFeedback" method="get">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" placeholder="Enter email" value="${param.email}">

        <label for="status">Status:</label>
        <select id="status" name="status">
            <option value="">All</option>
            <option value="1" ${param.status == 1 ? 'selected' : ''}>Responding</option>
            <option value="0" ${param.status == 0 ? 'selected' : ''}>No response</option>
        </select>

        <input type="submit" value="Search">
    </form>
    <!-- Table to display all account information -->
    <table>
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
                            <c:when test="${feedback.status == 1}">Responding</c:when>
                            <c:when test="${feedback.status == 0}">No response</c:when>
                        </c:choose>
                    </td>
                    <td style="width: 120%">
                        <a href="/SupportProject/DeleteFeedbackControl?feedbackID=${feedback.feedbackID}" class="status-action" style="width:68%; margin-bottom: 10px;">Delete</a>
                        <a href="#" class="status-action" onclick="openModal('${feedback.feedbackID}', '${feedback.email}')">Response</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Modal HTML -->
    <div id="responseModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h3>Respond to Feedback</h3>
            <form action="/SupportProject/ResponseControl" method="post">
                <input type="hidden" id="feedbackID" name="feedbackID">
                <label for="email">Email:</label>
                <input type="text" id="modalEmail" name="email" readonly>

                <label for="response">Response:</label>
                <textarea id="response" name="response" rows="4" placeholder="Enter your response here"></textarea>

                <button type="submit">Submit Response</button>
            </form>
        </div>
    </div>

    <!-- Pagination Links -->
    <div class="pagination">
        <c:if test="${currentPage > 1}">
            <a href="ListFeedback?page=${currentPage - 1}&email=${param.email}&status=${param.status}">Previous</a>
        </c:if>
        <c:if test="${currentPage < totalPages}">
            <a href="ListFeedback?page=${currentPage + 1}&email=${param.email}&status=${param.status}">Next</a>
        </c:if>
    </div>

    <!-- JavaScript to control the modal -->
    <script>
        function openModal(feedbackID, email) {
            document.getElementById('feedbackID').value = feedbackID;
            document.getElementById('modalEmail').value = email;
            document.getElementById('responseModal').style.display = 'block';
        }

        function closeModal() {
            document.getElementById('responseModal').style.display = 'none';
        }
          // Function to display alert if delete was successful
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
</body>
</html>
