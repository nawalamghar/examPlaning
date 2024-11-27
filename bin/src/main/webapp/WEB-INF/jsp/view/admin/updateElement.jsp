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
			 Modification d'un Elément Pédagogique
		</h3>
	</div>
	<div>


		<f:form action="${pageContext.request.contextPath}/admin/updateElement" method="POST" modelAttribute="elementModel">
			<f:hidden path="idElement"/>
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
					<button type="submit" class="btn btn-primary">Modifier</button>
					<button type="reset" class="btn btn-secondary">Annuler</button>
				</div>
		</f:form>
	</div>

	
		
	</div>



<jsp:include page="../fragments/adminfooter.jsp" />