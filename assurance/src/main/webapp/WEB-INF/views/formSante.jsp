<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Formulaire de Souscription - Assurance Sante</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/forms.css">
</head>
<body>
<h1>Formulaire de Souscription - Assurance Sante</h1>
<div class="hh">
    <form action="sante/submitSante" method="post">

        <input type="hidden" name="typeAssurance" value="SANTE">

        <div>
            <label for="age">Age:</label>
            <input type="number" id="age" name="age" min="0" required>
        </div>

        <div>
            <label for="etatSante">Etat de Sante:</label>
            <input type="text" id="etatSante" name="etatSante" placeholder="Decrivez votre etat de sante" required>
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

    <!-- Pop-up pour afficher le devis -->
    <div class="popup-overlay" id="popup-overlay"></div>
    <div class="popup" id="popup">
        <h3>Montant du Devis</h3>
        <p>Le montant de votre devis est : <span id="montantDevis">${montantDevis} MAD/MOIS</span></p>
        <form action="accepterAssurance" method="post">
            <input type="hidden" name="montantDevis" value="${montantDevis}">
            <input type="hidden" name="id" value="${sante.id}">
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
