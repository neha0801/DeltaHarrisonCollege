<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.min.js"></script>
<title>Student Transcript</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<jsp:include page="./header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			
			
			<c:if test="${user.isAdvisor()}">
				<div class="col-sm-8 col-sm-offset-2" style="padding:10px;">
					<form  action="Transcript" method="GET">
					<label for="student">Student Number:</label> 
					<input type = "text" name="student" />	
					<input type = "hidden" value="Unofficial" name="type" />									
					<br>					
					<button type="submit" value="submit" class="btn btn-default">Enter</button>
					</form>	
				</div>										
			</c:if>

			<form  action="Transcript" method="GET">
			<input type = "hidden" value="Unofficial" name="type" />
			</form>	

			<div class="panel panel-default col-sm-8 col-sm-offset-2">
			  <!-- Default panel contents -->
			  <div class="panel-heading">
			  <h2 align="center">Unofficial Transcript</h2>
			   </div>
			  <div class="panel-body">
				${message}
			  </div>
				<!-- Table -->
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Course Name</th>
							<th>Semester</th>
							<th>Grade</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="currentTranscript" items="${currentTranscript}">
							<tr>
								<td>${currentTranscript.HClass.HCourse.name}</td>
								<td>${currentTranscript.HClass.HSemester.season} ${currentTranscript.HClass.HSemester.year}</td>
								<td>${currentTranscript.grade}</td>							
								<td>${currentTranscript.status}</td>	
							</tr>
						</c:forEach>
							<tr>
								<td colspan="3" align="right">Overall GPA = </td>
								<td>${gpa}</td>
							</tr>
					
					</tbody>
				</table>	
			</div>
			
</body>
</html>
