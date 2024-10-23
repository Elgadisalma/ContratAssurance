<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire de Souscription - Assurance Sante</title>
</head>
<body>
<h1>Formulaire de Souscription - Assurance Sante</h1>

<form action="sante/submitSante" method="post">

    <input type="hidden" name="typeAssurance" value="SANTE">

    <div>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" min="0" required>
    </div>

    <div>
        <label for="etatSante">Etat de Sante:</label>
        <input id="etatSante" name="etatSante" placeholder="Decrivez votre etat de sante" required>
    </div>

    <div>
        <label for="typeCouverture">Type de Couverture:</label>
        <select id="typeCouverture" name="typeCouverture" required>
            <option value="">--Selectionnez--</option>
            <option value="BASIC">Basic</option>
            <option value="PREMIUM">Premium</option>
        </select>
    </div>

    <div>
        <button type="submit">Soumettre</button>
    </div>
</form>
</body>
</html>
