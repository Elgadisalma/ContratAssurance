<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Formulaire de Souscription - Assurance Habitation</h2>

<form action="habitation/submitHabitation" method="post">

    <input type="hidden" name="typeAssurance" value="HABITATION">

    <label for="valeurBien">Valeur du bien:</label>
    <input type="number" step="0.01" id="valeurBien" name="valeurBien" required><br><br>

    <label for="typeLogement">Type de logement:</label>
    <select name="typeLogement" id="typeLogement" required>
        <option value="">--Selectionnez--</option>
        <option value="APPARTEMENT">Appartement</option>
        <option value="MAISON">Maison</option>
    </select><br><br>

    <label for="risque">Le bien est-il à risque ?</label>
    <input type="checkbox" id="risque" name="risque"><br><br>

    <label for="systemSecurite">Systeme de securite installe ?</label>
    <input type="checkbox" id="systemSecurite" name="systemSecurite"><br><br>

    <button type="submit">Soumettre</button>
</form>

</body>
</html>
