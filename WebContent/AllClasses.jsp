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
<title>All Available Classes</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<jsp:include page="./header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<div class="panel panel-primary col-sm-6 col-sm-offset-3">

				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Course Name</th>
							<th>Time</th>
							<th>Availability</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="currentClass" items="${currentClasses}">
							<tr>
								<td>${currentClass.HCourse.name}</td>
								<td>${currentClass.getClassSchedule()}</td>
								<td>${currentClass.getCurrentAvailability()}</td>
								
								<c:if test="${currentClass.hasEnrolled(user.userId)}">
									<td><a class="btn btn-danger" href="#">Enrolled</a></td>
								</c:if>
								
								<c:if test="${not currentClass.hasEnrolled(user.userId)}">
								<c:choose>
								  <c:when test="${user.HStudentDetail.isTimeOk(currentClass)}">
								  <c:if test="${currentClass.getCurrentAvailability()<=0}">
									<td><a class="btn btn-danger" href="#">Full</a></td>
									</c:if>
									<c:if test="${currentClass.getCurrentAvailability()>0}">
								    <td><a class="btn btn-success" href="Enroll?classId=${currentClass.classId}">Enroll</a></td>
								    </c:if>
								  </c:when>

								  <c:otherwise>
								   	<td>Time Overlapped</td>
								  </c:otherwise>
								</c:choose>	
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
					

				</table>	
					
						


			
			</div>
			
</body>
</html>
