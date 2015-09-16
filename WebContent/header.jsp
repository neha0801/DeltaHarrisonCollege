
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">Harrison College</a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<c:if test="${empty user}">
					<li><a href="./LoginForm.jsp">Login</a></li>
				</c:if>
				<c:if test="${empty user}">
					<li><a href="./RegisterUser.jsp">Register</a></li>
				</c:if>
				<c:if test="${not empty user}">


					<li><a href="Logout">Logout</a>
					<li><a href="AllClasses">Enroll</a>


					<li><a href="InstructorClasses">Instructor Classes</a></li>
					<li><a href="InstructorRoster?action=getAll">Generate your Roster</a></li>		
					<li><a href="AddClass?action=load">Add Class</a></li>				



				</c:if>

			</ul>
		</div>
	</div>
</nav>
