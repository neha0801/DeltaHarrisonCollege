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
<title>Admin Edit Role</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Admin Edit User Role </div>
		<div class="panel-body">


			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger">
					<c:out value="${errorMessage}" />
				</div>
			</c:if>
			<p>User Name: ${tempUser.userName}</p>
			<p>Name: ${tempUser.firstName} ${tempUser.lastName}</p>
			<p>Email: ${tempUser.email}</p>
	        <p>Current Role(s):
	        	<c:forEach var="userRole" items="${tempUser.HUserRoles}">
					${userRole.HRole.name}
				</c:forEach>
        	</p>
			<c:choose>
			    <c:when test="${tempUser.isAdmin() or tempUser.isAdvisor() or tempUser.isInstructor()}">
			       <p>Employee Number: ${tempUser.HStaffDetail.employeeNumber}</p>
			       <p>Department: ${tempUser.HStaffDetail.HDepartment.name}</p>
			    </c:when>
			    <c:when test="${tempUser.isStudent()}">
			        <p>Student Number: ${tempUser.HStudentDetail.studentNumber}</p>
			        <p>Major: ${tempUser.HStudentDetail.HMajor.name}</p>
			    </c:when>
			    <c:otherwise>
			       
			    </c:otherwise>
			</c:choose>
			<form action="AdminEditRole" method="POST">

				<input type="hidden" value="${tempUser.userId}" name="tempUserId" />
				Add A Role:
				<select name="newRole">
				
					<option value="no">no</option>
		        	<c:forEach var="role" items="${tempUser.getPossibleRoles()}">
	        			<option value="${role}">${tempUser.getRoleFromId(role)}</option>
					</c:forEach>
				</select>
				<br><br>
				
				Disable A Role:
					<br>
					
	        		<c:forEach var="userRole" items="${tempUser.HUserRoles}">
	        			
	        			
	        				<select name="currentRole${userRole.userRoleId}">
	        					<option value="Active" <c:if test="${userRole.status eq 'Active'}">selected</c:if> >Active</option>
	        					
	        					<option value="Inactive" <c:if test="${userRole.status eq 'Inactive'}">selected</c:if> >Inactive</option>
	        				</select>
	        				${userRole.HRole.name}<br>
					</c:forEach>
				
				<input type="submit" value = "Save" class="btn btn-primary"/>
			</form>
			
		</div>
	</div>
	
	
	
	
	
	
	

</body>
</html>
