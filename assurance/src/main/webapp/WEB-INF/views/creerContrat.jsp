<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/contrat/submitContrat" method="post" >
    <input type="hidden" name="assuranceId" value="${assuranceId}">
    <input type="hidden" name="montant" value="${montant}">

    <div>
        <label for="dateDebut">Date de début :</label>
        <input type="date" id="dateDebut" name="dateDebut" required>
    </div>

    <div>
        <label for="dateFin">Date de fin :</label>
        <input type="date" id="dateFin" name="dateFin" required>
    </div>

    <div>
        <label for="documents">Documents :</label>
        <input type="file" id="documents" name="documents" >
    </div>

    <div>
        <button type="submit">Créer le Contrat</button>
    </div>
</form>
</body>
</html>
