<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire de Souscription - Assurance Automobile</title>
</head>
<body>
<h2>Formulaire de Souscription - Assurance Automobile</h2>

<form action="automobile/submitAutomobile" method="post">
    <input type="hidden" name="typeAssurance" value="AUTOMOBILE">

    <div>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" min="18" required>
    </div>

    <div>
        <label for="typeVehicule">Type de Véhicule:</label>
        <select id="typeVehicule" name="typeVehicule" required>
            <option value="">--Sélectionnez--</option>
            <option value="LUXE">Luxe</option>
            <option value="UTILITAIRE">Utilitaire</option>
        </select>
    </div>

    <div>
        <label for="utilisationVehicule">Utilisation du Véhicule:</label>
        <select id="utilisationVehicule" name="utilisationVehicule" required>
            <option value="">--Sélectionnez--</option>
            <option value="PRIVE">Privé</option>
            <option value="PROFESSIONNEL">Professionnel</option>
        </select>
    </div>

    <div>
        <label for="historique">Historique:</label>
        <input id="historique" name="historique" placeholder="Décrivez l'historique du véhicule" required>
    </div>

    <div>
        <button type="submit">Soumettre</button>
    </div>
</form>
</body>
</html>
