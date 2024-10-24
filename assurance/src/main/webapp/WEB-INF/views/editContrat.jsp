<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Éditer le Contrat</title>
</head>
<body>
<h1>Éditer le Contrat</h1>
<form action="${pageContext.request.contextPath}/contrat/update" method="post">
    <input type="hidden" name="id" value="${contrat.id}">
    <div>
        <label for="dateDebut">Date de début :</label>
        <input type="date" id="dateDebut" name="dateDebut" value="${contrat.dateDebut}" required>
    </div>
    <div>
        <label for="dateFin">Date de fin :</label>
        <input type="date" id="dateFin" name="dateFin" value="${contrat.dateFin}" required>
    </div>
    <div>
        <input type="hidden" name="montant" value="${contrat.montant}" required>
    </div>
    <div>
        <button type="submit">Mettre à jour</button>
    </div>
</form>
</body>
</html>
