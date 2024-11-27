<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

          
				<div class="col" id="sallelist">
				<c:forEach items="${salleList}" var="s" varStatus="status">
                <div class="form-check-inline">                 
                    <f:checkbox path="salles" value="${s.idSalle}" class="form-check-input" 
                        onclick="toggleInput(this, 'nbrS' + ${status.index})" /> 
                    <label class="form-check-label">${s.nom}</label> --%>
                    <f:input path="nbrS[${s.idSalle}]" type="number" id="nbrS${status.index}" 
                         style="display:none;" class="form-control form-check-inline" /> 
                </div>
            </c:forEach>
            </div>