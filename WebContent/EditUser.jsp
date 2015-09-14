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
<title>Edit User</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Edit User <span class="glyphicon glyphicon-user"></div>
		<div class="panel-body">

			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger">
					<c:out value="${errorMessage}" />
				</div>
			</c:if>

			<c:if test="${not empty goodMessage}">
				<div class="alert alert-success">
					<c:out value="${goodMessage}" />
				</div>
			</c:if>

			<form role="form" action="RegisterUser" method="POST">
				<div class="form-group">
					<label for="firstName"></label> <input type="text"
						class="form-control" name="firstName" placeholder="First Name"
						required /> <label for="lastName"></label> <input type="text"
						class="form-control" name="lastName" placeholder="Last Name"
						required /> <label for="email"></label> <input type="text"
						class="form-control" name="email" placeholder="Email" required />
					<label for="userName"></label> <select>
						<option selected="selected">Major</option>
						<c:forEach var="item" items="${major}">
							<option id="${item.major}">${item.major}</option>
						</c:forEach>
					</select> <input type="text" class="form-control" name="userName"
						placeholder="User Name" required /> <label for="password"></label>
					<input type="password" class="form-control" name="password"
						placeholder="Password" required />
				</div>

				<div class="form-group">
					<button type="submit" value="submit" class="btn btn-default">Register</button>


				</div>
			</form>
		</div>
	</div>

</body>
</html>