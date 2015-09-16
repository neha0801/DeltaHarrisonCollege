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
<title>Admin Reports</title>
<link rel="stylesheet" type="text/css" href="style.css">

<script type="text/javascript">
	function showDiv() {
		document.getElementById('welcomeDiv').style.display = "block";
	}
</script>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Reports</div>
		<div class="panel-body">

			<form action="AdminReports" method="GET">
				<input type="hidden" value="ByInstructor" name="ReportType"></input>
				<input type="submit" class="btn btn-success"
					value="Students taught by an instructor"></input>
			</form>
			
			<c:if test="${reportType eq 'ByInstructor'}">
				<table class="table table-bordered table-striped">
					<tbody>
						<form action="AdminReports" method="POST">
						<tr>
							<td><label>Instructor</label> <select name="instructor">
									<c:forEach var="item" items="${instructors}">
										<option type="text" value="${item.userId}">${item.getFullName()}</option>
									</c:forEach>
							</select></td>
							<td><input type="hidden" 	value="ByInstructor" name="reportType">
							<input type="submit" class="btn pull-right btn-warning"
								value="View Students"></input></td>
						</form>
						</tr>
					</tbody>
				</table>
			</c:if>

 
		</div>
	</div>



</body>
</html>