<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
    <html xmlns:th="http://www.thymeleaf.org"> 
<jsp:include page="../fragments/adminHeader.jsp" />
<script>
        function afficheExams(dateInput) {
        	//examDetails
        	document.getElementById('examDetails').innerHTML = "";
        	var dateValue = dateInput.value;
        	console.log("Fetching exams for date: " + dateValue);
            //alert('hello ' + dateValue);
            
            fetch('showListExamResponse?date=' + dateValue, {
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
                document.getElementById('examContainer').innerHTML = data;
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });
        }
        
        
		function afficheDetailsExams(idExam) {
        	
            fetch('detailsExam?idExam=' + idExam, {
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
                document.getElementById('examDetails').innerHTML = data;
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
	
	
		<div class="col">
					
					<label>Date Examen</label>
					<input onchange="afficheExams(this)" type="date" class="form-control"
						placeholder="date examen" />
					<div id="examContainer"></div>
					
				
		</div>
		
		<div id="examContainer" class="col">
            <!-- The exam list will be inserted here -->
        </div>
        
        <div id="examDetails" class="col">
            <!-- The exam list will be inserted here -->
        </div>
        
       

   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</div>


















<jsp:include page="../fragments/adminfooter.jsp" />