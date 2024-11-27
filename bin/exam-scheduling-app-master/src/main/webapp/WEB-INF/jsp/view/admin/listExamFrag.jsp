<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Date</th>
            <th scope="col">Duré de début</th>
            <th scope="col">Sujet</th>
            <th scope="col">Session</th>
            <th scope="col">Preuve</th>
            <th scope="col">procès-verbal</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="e" items="${ListExams}">
            <tr>
            	<td hidden value="${e.idExam}"></td>
                <td><c:out value="${e.date}" /></td>
                <td><c:out value="${e.heureDebut}" /></td>
                <td><c:out value="${e.element.titre}" /></td>
                <td><c:out value="${e.session.intitule}" /></td>
                <td><a href="${pageContext.request.contextPath}/admin/epreuve?filename=${e.eprouve}" >Voir l'épreuve</a></td>
                <td><a href="${pageContext.request.contextPath}/admin/pv?filename=${e.pv}">Voir procès-verbal </a></td>
                <td>
						<ul>
<!-- 							<li><a  -->
<%-- 								href="${pageContext.request.contextPath}/admin/voirDetailExam/${e.idExam}">Details</a></li> --%>
								<li><button onclick="afficheDetailsExams(${e.idExam})">Details</button></li> 
						</ul>
				</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

