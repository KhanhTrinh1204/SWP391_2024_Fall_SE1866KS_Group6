<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Staff</title>
</head>
<body>
    <h1>Add New Staff</h1>

    <!-- Form để thêm nhân viên mới -->
    <form action="${pageContext.request.contextPath}/staff/add" method="POST">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required /><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required /><br>

        <label for="active">Active:</label>
        <input type="checkbox" id="active" name="active" value="true" /><br>

        <!-- Không yêu cầu nhập roleId vì mặc định là 4 -->

        <input type="submit" value="Add Staff" />
    </form>

    <a href="${pageContext.request.contextPath}/staff/list">Back to Staff List</a> <!-- Liên kết quay lại danh sách nhân viên -->
</body>
</html>
