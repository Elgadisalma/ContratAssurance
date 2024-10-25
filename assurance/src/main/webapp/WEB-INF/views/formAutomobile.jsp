<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire de Souscription - Assurance Automobile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/forms.css">
    <style>
        .popup {
            display: none;
            position: fixed;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            background-color: white;
            border: 1px solid black;
            padding: 20px;
            z-index: 1000;
        }
        .popup-overlay {
            display: none;
            position: fixed;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            z-index: 999;
        }
    </style>
</head>
<body>
<h2>Formulaire de Souscription - Assurance Automobile</h2>
<div class="hh">

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
        <input id="historique" type="text" name="historique" placeholder="Décrivez l'historique du véhicule" required>
    </div>

    <div>
        <button type="submit">Soumettre</button>
    </div>
</form>

<!-- Pop-up pour afficher le devis -->
<div class="popup-overlay" id="popup-overlay"></div>
<div class="popup" id="popup">
    <h3>Montant du Devis</h3>
    <p>Le montant de votre devis est : <span id="montantDevis">${montantDevis} MAD/MOIS</span></p>
    <form action="accepterAssurance" method="post">
        <input type="hidden" name="montantDevis" value="${montantDevis}">
        <input type="hidden" name="id" value="${automobile.id}">
        <button type="submit">Accepter l'assurance</button>
    </form>
    <button onclick="fermerPopup()">Annuler</button>
</div>
</div>

<script>
    window.onload = function() {
        var montantDevis = "${montantDevis}";
        if (montantDevis) {
            document.getElementById("popup-overlay").style.display = "block";
            document.getElementById("popup").style.display = "block";
        }
    };

    function fermerPopup() {
        document.getElementById("popup-overlay").style.display = "none";
        document.getElementById("popup").style.display = "none";
    }
</script>
</body>
</html>
