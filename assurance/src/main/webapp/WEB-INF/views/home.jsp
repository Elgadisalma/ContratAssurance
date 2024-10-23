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

<h2>Voulez-vous se souscrire a une assurance ?</h2>
<h2>Laquel voulez-vous</h2>

<form action="home/subscribe" method="post">
    <label for="assuranceType">Choisissez le type d'assurance:</label>
    <select name="assuranceType" id="assuranceType">
        <option value="">--Selectionnez--</option>
        <option value="sante">Assurance Sante</option>
        <option value="automobile">Assurance Automobile</option>
        <option value="habitation">Assurance Habitation</option>
    </select>


    <button type="submit">Soumettre</button>
</form>

</body>
</html>
