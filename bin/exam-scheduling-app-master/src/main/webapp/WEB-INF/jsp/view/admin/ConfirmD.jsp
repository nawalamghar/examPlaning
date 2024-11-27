<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
.confirmation-dialog {
    display: none;
    position: fixed;
    z-index: 9999;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
}

.confirmation-dialog-content {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}

.confirmation-dialog-content p {
    margin-bottom: 10px;
}

.confirmation-dialog-content button {
    margin-right: 10px;
}

</style>
</head>

<body>

<div id="confirmationDialog" class="confirmation-dialog">
    <div class="confirmation-dialog-content">
        <p>Êtes-vous sûr de vouloir supprimer cet élément ?</p>
        <button id="confirmButton">Confirmer</button>
        <button id="cancelButton">Annuler</button>
    </div>
</div>


</body>
</html>