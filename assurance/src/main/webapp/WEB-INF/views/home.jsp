<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
</head>
<body>

<div class="header">
    <c:if test="${not empty user}">
        <h2>Welcome, ${user.name}!</h2>
    </c:if>
    <form action="auth/logout" method="post">
        <button type="submit" class="logout-button">Log Out</button>
    </form>
</div>

<h3>Voulez-vous souscrire à une assurance ?</h3>
<h4>Laquelle voulez-vous ?</h4>

<form action="home/subscribe" method="post">
    <label for="assuranceType">Choisissez le type d'assurance :</label>
    <select name="assuranceType" id="assuranceType" class="assurance-select">
        <option value="">--Selectionnez--</option>
        <option value="sante">Assurance Sante</option>
        <option value="automobile">Assurance Automobile</option>
        <option value="habitation">Assurance Habitation</option>
    </select>

    <button type="submit" class="submit-button">Soumettre</button>
</form>

<h2>Liste des Contrats</h2>
<table>
    <thead>
    <tr>
        <th>Date Debut</th>
        <th>Date Fin</th>
        <th>Montant</th>
        <th>Resilie</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="contrat" items="${contrats}">
        <tr>
            <td>${contrat.dateDebut}</td>
            <td>${contrat.dateFin}</td>
            <td>${contrat.montant}</td>
            <td>${contrat.resilier ? 'Oui' : 'Non'}</td>
            <td class="actions">
                <a href="${pageContext.request.contextPath}/contrat/edit/${contrat.id}" class="modify-button">Modifier</a>
                <form action="${pageContext.request.contextPath}/contrat/resilier/${contrat.id}" method="post" style="display:inline;">
                    <button type="submit" class="resilier-button" ${contrat.resilier ? "disabled" : ""}>Resilier</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
