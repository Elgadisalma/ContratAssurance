<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<c:if test="${not empty user}">
    <h2>Welcome, ${user.name}!</h2>
</c:if>

<form action="auth/logout" method="post">
    <button type="submit">LogOut</button>
</form>

<h2>Voulez-vous souscrire à une assurance ?</h2>
<h2>Laquelle voulez-vous ?</h2>

<form action="home/subscribe" method="post">
    <label for="assuranceType">Choisissez le type d'assurance :</label>
    <select name="assuranceType" id="assuranceType">
        <option value="">--Selectionnez--</option>
        <option value="sante">Assurance Sante</option>
        <option value="automobile">Assurance Automobile</option>
        <option value="habitation">Assurance Habitation</option>
    </select>

    <button type="submit">Soumettre</button>
</form>

<h2>Liste des Contrats</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Date Debut</th>
        <th>Date Fin</th>
        <th>Montant</th>
        <th>Resilie</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="contrat" items="${contrats}">
        <tr>
            <td>${contrat.id}</td>
            <td>${contrat.dateDebut}</td>
            <td>${contrat.dateFin}</td>
            <td>${contrat.montant}</td>
            <td>${contrat.resilier ? 'Oui' : 'Non'}</td>
            <td>
                <a href="${pageContext.request.contextPath}/contrat/edit/${contrat.id}">Modifier</a>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/contrat/resilier/${contrat.id}" method="post">
                    <button type="submit" ${contrat.resilier ? "disabled" : ""}>Resilier</button>
                </form>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
