<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="../fragments/adminHeader.jsp" />

<script type="text/javascript">
	function setDefaultDure(sujet) {
		
		var element = sujet.options[sujet.selectedIndex].value;
        console.log("element: " + element);
	    //alert('hello ' + dateValue);
	    
	    fetch('setDefaultDure?element=' + element, {
	        method: 'GET'
	    })
	    .then(response => {
	        if (!response.ok) {
	            throw new Error('Network response was not ok');
	        }
	        return response.text();
	    })
	    .then(data => {
	    	console.log(data);
	        document.getElementById('dure').value = data;
	    })
	    .catch(error => {
	        console.error('There was a problem with the fetch operation:', error);
	    });
	}
</script>


<div class="container">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<jsp:include page="../fragments/menu.jsp" />

		</div>
	</nav>



	<div>
		<h3>
			 Planifier Examen 
		</h3>
	</div>
	<div id="fragPlanExam">


		<f:form action="addExam" method="POST" modelAttribute="examenModel" enctype="multipart/form-data">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
				
			<div class="row">
				<div class="col">
					<label>Session</label>
							<f:select path="session" items="${sessionList}" class="form-control" />
							<f:errors path="session" class="text-danger" />
				</div>
				<div class="col">
					<label>Semestre</label>
							<f:select path="semestre" items="${semestreList}" class="form-control" />
							<f:errors path="semestre" class="text-danger" />
				</div>
				
			</div>
			<div class="row">
				<div class="col">
				
					<label>Sujet</label>
							<f:select onchange="setDefaultDure(this)" path="element" items="${elementList}" class="form-control" id="sujet"/>
							<f:errors path="element" class="text-danger" />
				
				</div>
				<div class="col">
					<label>Type</label>
							<f:select path="type" items="${typeExamList}" class="form-control" />
							<f:errors path="type" class="text-danger" />
				</div>
			
			</div>
			
			
			<div class="row">
				
				<div class="col">
					
					<label>Date Examen</label>
					<f:input path="date" type="date" class="form-control"
						placeholder="date examen" id="date" />
					<f:errors path="date" class="text-danger" />
				
				</div>
				
				<div class="col">
					
					<label>Heure Debut</label>
					<f:input path="heureDebut" type="time" class="form-control"
						placeholder="heure début" id="heureD" />
					<f:errors path="heureDebut" class="text-danger" />
				
				</div>
			
			</div>	
			
			<div class="row">
				
				<div class="col">
					
					<label>Durée prévue</label>
					<f:input path="durePrevu" type="time" class="form-control"
						placeholder="Durée prévue" id="dure"/>
					<f:errors path="durePrevu" class="text-danger" />
				
				</div>
				<div class="col">
					
					<label>Durée réelle</label>
					<f:input path="dureReelle" type="time" class="form-control"
						placeholder="Durée réelle" />
					<f:errors path="dureReelle" class="text-danger" />
				
				</div>
				
				
			</div>	
			
			
			
			
			<div class="row">
<!-- 				<legend class="col-form-label ">Salle</legend> -->
				<label>Salle</label>
				
				
				<div class="col" id="salle">
				<c:forEach items="${salleList}" var="s" varStatus="status">
                <div class="form-check-inline">
                     
	                    <f:checkbox path="salles" value="${s.idSalle}" class="form-check-input" 
	                        onclick="toggleInput(this, 'nbrS' + ${status.index})" />
	                    <label class="form-check-label">${s.nom}</label>
	                    <div id="res"></div>
	                    <f:input value="2" path="nbrS[${s.idSalle}]" type="number" id="nbrS${status.index}" 
	                        style="display:none;" class="form-control form-check-inline" />
                     
                </div>
            </c:forEach>
            </div>
            
            <div class="col">
<!--             		<legend class="col-form-label ">Anné universitaire</legend> -->
            		<label>Anné universitaire</label>
					<f:select path="anneUni" items="${anneUnList}" class="form-control" />
					<f:errors path="anneUni" class="text-danger" />
            	
            </div>
				
			</div>	
			
			<div class="row">
				
            <div class="col">
                <label>Epreuve</label>
                <input  type="file" name="eprouveFile"  class="form-control"/>
                <f:errors path="eprouveFile" class="text-danger" />
            </div>
            
            <div class="col">
                <label>PV</label>
                <input type="file" name="pvFile" class="form-control"/>
                <f:errors path="pvFile" class="text-danger" />
            </div>
        
			</div>	
			
			
			
			<div class="row">
				
				<div class="col">
				<legend class="col-form-label ">Rapport textuelle</legend>
<!-- 					<label>Rapport textuelle</label> -->
					<f:input value="rien à signaler" path="rapportText" placeholder="rapport textuelle" type="text"/>
				</div>
				
				<div class="col">
					<legend class="col-form-label ">les surveillants</legend>
						<div class="form-check">
							<f:radiobutton path="choix" value="1"
								class="form-check-input" />
							<label class="form-check-label">choisis aléatoirement</label>

						</div>

						<div class="form-check">
							<f:radiobutton path="choix" value="2"
								class="form-check-input" />
							<label class="form-check-label">choisis aléatoirement et appartient au meme groupe</label>

						</div>

					
				</div>
			</div>	
			
				<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Enregistrer</button>
					<button type="reset" class="btn btn-secondary">Annuler</button>
				</div>
		</f:form>
	</div>

<!-- 	<div> -->

<!-- 		<table class="table"> -->
<!-- 			<thead> -->
<!-- 				<tr> -->
<!-- 					<th scope="col">Titre</th> -->
<!-- 					<th scope="col">Coordinateur</th> -->
<!-- 					<th scope="col">Enseignant</th> -->
<!-- 					<th scope="col">Niveau</th> -->
<!-- 					<th scope="col">Type</th> -->
<!-- 					<th>Actions</th> -->
<!-- 				</tr> -->
<!-- 			</thead> -->

<%-- 			<c:forEach items="${elementList}" var="e"> --%>
<!-- 				<tr> -->

					
<%-- 					<td><c:out value="${e.titre}" /></td> --%>
<%-- 					<td><c:out value="${e.coord.nom} ${e.coord.prenom}" /></td> --%>
<%-- 					<td><c:out value="${e.ens.nom} ${e.ens.prenom}" /></td> --%>
<%-- 					<td><c:out value="${e.niveau.titreN}" /></td> --%>
<%-- 					<td><c:out value="${e.type.titreT}" /></td> --%>
<!-- 					<td> -->
<!-- 						<ul> -->
<!-- 							<li><a  -->
<%-- 								href="${pageContext.request.contextPath}/admin/deleteElement/${e.idElement}">Delete</a></li> --%>

<!-- 							<li><a -->
<%-- 								href="${pageContext.request.contextPath}/admin/updateElementForm/${e.idElement}">Update</a></li> --%>


<!-- 						</ul> -->
<!-- 					</td> -->

<!-- 				</tr> -->

<%-- 			</c:forEach> --%>
			

<!-- 		</table> -->
		
<!-- </div> -->
		
	</div>










<jsp:include page="../fragments/adminfooter.jsp" />