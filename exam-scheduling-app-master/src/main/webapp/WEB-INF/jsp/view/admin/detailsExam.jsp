<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
<html>
<head>
    <title>Détails de l'examen</title>
</head>
<body>

    <h1>Détails de l'examen</h1>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">Salles de l'examen</th>
                <th scope="col">Coordinateur </th>
                <th scope="col">contrôleur d'abscence</th>
                <th scope="col">surveillants</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="salle" items="${salles}">
                <tr>
                    <td>${salle.nom}</td>
                    <td>${cordSall[salle].nom} ${cordSall[salle].prenom}</td>
                    <td>${absExam[salle].nom} ${absExam[salle].prenom}</td>
                    <td>
                        <ul>
                            <c:forEach var="enseignant" items="${survExam[salle]}">
                                <li>${enseignant.nom} ${enseignant.prenom}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    
</body>
</html>
