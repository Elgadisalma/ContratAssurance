<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<form action="login" method="post">
    <h2>Login</h2>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">Login</button>

    <p style="text-align: center; margin-top: 15px;">
        You don't have an account yet?
        <a href="${pageContext.request.contextPath}/auth/register">Create one here</a>
    </p>
</form>
</body>
</html>
