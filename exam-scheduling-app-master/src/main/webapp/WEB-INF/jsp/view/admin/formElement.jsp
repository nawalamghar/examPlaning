<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/adminHeader.jsp" />


<div class="container">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<jsp:include page="../fragments/menu.jsp" />

		</div>
	</nav>



	<div>
		<h3>
			 Ajout d'un Elément Pédagogique
		</h3>
	</div>
	<div>


		<f:form action="addElement" method="POST" modelAttribute="elementModel">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
			<div class="row">
				<div class="col">
					<label>Titre</label>
					<f:input path="titre" type="text" class="form-control"
						placeholder="Titre" />
					<f:errors path="titre" class="text-danger" />
				</div>
			</div>
			<div class="row">
				
				<div class="col">
					
					<label>Enseignant</label>
						<f:select path="ens" items="${coordList}" class="form-control" />
						<f:errors path="ens" class="text-danger" />
					</div>
				<div class="col">
					
					<label>Coordinateur</label>
						<f:select path="coord" items="${coordList}" class="form-control" />
						<f:errors path="coord" class="text-danger" />
					</div>
			</div>
			
			
			<div class="row">
				
				<div class="col">
					
					<label>Niveau</label>
						<f:select path="niveau" items="${niveauList}" class="form-control" />
						<f:errors path="niveau" class="text-danger" />
					</div>
					
				<div class="col">
					
					<label>Type</label>
						<f:select path="type" items="${typeList}" class="form-control" />
						<f:errors path="type" class="text-danger" />
					</div>
				
				</div>	
			
			
				<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Enregistrer</button>
					<button type="reset" class="btn btn-secondary">Annuler</button>
				</div>
		</f:form>
	</div>

	<div>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Titre</th>
					<th scope="col">Coordinateur</th>
					<th scope="col">Enseignant</th>
					<th scope="col">Niveau</th>
					<th scope="col">Type</th>
					<th>Actions</th>
				</tr>
			</thead>

			<c:forEach items="${elementList}" var="e">
				<tr>

					
					<td><c:out value="${e.titre}" /></td>
					<td><c:out value="${e.coord.nom} ${e.coord.prenom}" /></td>
					<td><c:out value="${e.ens.nom} ${e.ens.prenom}" /></td>
					<td><c:out value="${e.niveau.titreN}" /></td>
					<td><c:out value="${e.type.titreT}" /></td>
					<td>
						<ul>
							<li><a 
								href="${pageContext.request.contextPath}/admin/deleteElement/${e.idElement}">Delete</a></li>

							<li><a
								href="${pageContext.request.contextPath}/admin/updateElementForm/${e.idElement}">Update</a></li>


						</ul>
					</td>

				</tr>

			</c:forEach>
			

		</table>
		
</div>
		
	</div>










<jsp:include page="../fragments/adminfooter.jsp" />