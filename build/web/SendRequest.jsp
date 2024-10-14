<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Send request</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        label {
            font-size: 15px;
            color: #34495e;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        textarea {
            padding: 12px;
            border: 1px solid #dcdfe3;
            border-radius: 6px;
            font-size: 14px;
            width: 100%;
            box-sizing: border-box;
            background-color: #f9f9f9;
            transition: all 0.2s ease;
        }

        input[type="text"]:focus,
        textarea:focus {
            border-color: #3498db;
            background-color: #fff;
            outline: none;
        }

        textarea {
            resize: none;
            height: 150px;
        }

        button {
            padding: 12px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #2980b9;
        }

        .error {
            color: red;
            font-size: 12px;
        }

        .success {
            color: green;
            font-size: 14px;
            margin-bottom: 15px;
            text-align: center;
        }

        /* Form responsiveness */
        @media (max-width: 600px) {
            form {
                padding: 20px;
                gap: 15px;
            }
        }
    </style>

    <script>
        function validateForm() {
            var title = document.getElementById("title").value;
            var description = document.getElementById("description").value;
            var isValid = true;

            // Reset error messages
            document.getElementById("titleError").innerText = "";
            document.getElementById("descriptionError").innerText = "";

            // Validate title length (5-200 characters)
            if (title.trim().length < 5 || title.trim().length > 200) {
                document.getElementById("titleError").innerText = "Title must be between 5 and 200 characters.";
                isValid = false;
            }

            // Validate description length (5-255 characters)
            if (description.trim().length < 5 || description.trim().length > 255) {
                document.getElementById("descriptionError").innerText = "Description must be between 5 and 255 characters.";
                isValid = false;
            }

            return isValid;
        }
    </script>
</head>
<body>
    <form action="createRequest" method="post" onsubmit="return validateForm()">
        <label for="title">Title(*)</label>
        <input type="text" id="title" name="title">
        <div class="error" id="titleError">
            <!-- Server-side error message for title -->
            <% String titleError = (String) request.getAttribute("titleError");
               if (titleError != null) { %>
                <%= titleError %>
            <% } %>
        </div>

        <label for="description">Description(*)</label>
        <textarea id="description" name="description"></textarea>
        <div class="error" id="descriptionError">
            <!-- Server-side error message for description -->
            <% String descriptionError = (String) request.getAttribute("descriptionError");
               if (descriptionError != null) { %>
                <%= descriptionError %>
            <% } %>
        </div>

        <button type="submit">Send</button>

        <!-- Display success message if it exists -->
        <% String successMessage = (String) request.getAttribute("successMessage");
           if (successMessage != null) { %>
            <div class="success">
                <%= successMessage %>
            </div>
        <% } %>
    </form>
</body>
</html>
