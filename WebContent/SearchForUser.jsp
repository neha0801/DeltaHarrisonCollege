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
<title>Admin Search for User</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">
			Admin Search for a User to Edit <span class="glyphicon glyphicon-user"> 
		</div>
		<div class="panel-body">


			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger">
					<c:out value="${errorMessage}" />
				</div>
			</c:if>

			

			<form role="form" action="SearchForUser" method="GET">
				<label for="userName">User Name:</label> 
					<input type = "text" name="userName" />
					<input type="submit" value="Search" class="btn btn-primary"/>
					
					<br>
			</form>
		</div>
	</div>
	
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">

				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>User Name</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Role</th>
							<th>Edit</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="currentUser" items="${users}">
							<tr>
								<td>${currentUser.userName}</td>
								<td>${currentUser.firstName}</td>								
								<td>${currentUser.lastName}</td>
								<td>
									<c:forEach var="userRole" items="${currentUser.HUserRoles}">
											
											<c:if test="${userRole.roleStatus == 'Active'}">
												${userRole.HRole.name} -
											</c:if> 
									</c:forEach>
								</td>
								<td><a class="btn btn-success" href="AdminEditRole?tempUserId=${currentUser.userId}">Edit</a></td>
								
								
							</tr>
						</c:forEach>
					</tbody>
					

				</table>	
					
						


			
			</div>
	
	
	
	
	

</body>
</html>