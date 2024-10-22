<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>

<c:if test="${not empty user}">
    <h2>Welcome, ${user.name}!</h2>
</c:if>

<form action="logout" method="post">
    <button type="submit">LogOut</button>
</form>

</body>
</html>
