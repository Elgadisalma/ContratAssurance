<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<h2>Formulaire de Souscription - Assurance Habitation</h2>

<div class="hh">
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

<!-- Pop-up pour afficher le devis -->
<div class="popup-overlay" id="popup-overlay"></div>
<div class="popup" id="popup">
    <h3>Montant du Devis</h3>
    <p>Le montant de votre devis est : <span id="montantDevis">${montantDevis} MAD/MOIS</span></p>
    <form action="accepterAssurance" method="post">
        <input type="hidden" name="montantDevis" value="${montantDevis}">
        <input type="hidden" name="id" value="${habitation.id}">
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
