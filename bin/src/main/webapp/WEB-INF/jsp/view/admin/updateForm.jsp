<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
			Mise à jour d'un
			<c:if test="${personelModel.typePerson== 1}"
				var="variable">
					Administrateur
				</c:if>
			<c:if test="${personelModel.typePerson== 2}"
				var="variable">
					Enseignant
				</c:if>


		</h3>
	</div>
	<div>

		<c:if test="${not empty msg}">
			<div class="alert alert-success" role="alert">${msg}</div>
		</c:if>

		<f:form action="${pageContext.request.contextPath}/admin/updatePersonel"
			method="POST" modelAttribute="personelModel">
			<f:hidden path="idPersonnel" />
			
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">

			<f:hidden path="typePerson" />

			<div class="row">
				<div class="col">
					<label>CIN</label>
					<f:input path="cin" type="text" class="form-control"
						placeholder="cin" />
					<f:errors path="cin" class="text-danger" />
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label>Nom</label>
					<f:input path="nom" type="text" class="form-control"
						placeholder="nom" />
					<f:errors path="nom" class="text-danger" />
				</div>
				<div class="col">
					<label>Prénom</label>
					<f:input path="prenom" type="text" class="form-control"
						placeholder="prenom" />
					<f:errors path="prenom" class="text-danger" />
				</div>
				
			</div>	
			
			<div class="row">
				<div class="col">
					<label>Télé</label>
					<f:input path="telephone" type="text" class="form-control"
						placeholder="telephone" />
					<f:errors path="telephone" class="text-danger" />
				</div>
				
				
					<div class="col">
						<label>Email</label>
						<f:input path="email" class="form-control" placeholder="Email" />
						<f:errors path="email" class="text-danger" />
					</div>
			</div>
			
			
				<f:hidden path="typePerson" />
				<c:if test="${personelModel.typePerson== 2}"
					var="variable">
					<div class="row">
					
					<div class="col">
					
					<label>Département</label>
						<f:select path="dept" items="${deptList}" class="form-control" />
						<f:errors path="dept" class="text-danger" />
						
					</div>
					<div class="col">
					<label>Filière</label>
						<f:select path="filiere" items="${filList}" class="form-control" />
						<f:errors path="filiere" class="text-danger" />
						
					</div>
					<div class="col">
					<label>Groupe</label>
						<f:select path="groupe" items="${groupetList}" class="form-control" />
						<f:errors path="groupe" class="text-danger" />
						
					</div>
					</div>
					
					
				</c:if>
			<div style="text-align: right">
				<button type="submit" class="btn btn-primary">Update</button>
				<button type="reset" class="btn btn-secondary">Rest</button>
			</div>

		</f:form>
	</div>



	<jsp:include page="../fragments/adminfooter.jsp" />