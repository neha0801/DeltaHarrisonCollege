
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<style>
	.navbar-brand
	{
	    margin: 0px;
	    padding: 4px;
	}
	
	body 
	{
	    background-image: url("logo.png");
	    background-color:rgba(0, 0, 0, 0.8);
	    
	}

</style>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand"><img src="logo.png" width="40px" alt="Harrison College"/></a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<c:if test="${empty user}">
					<li><a href="LoginForm.jsp">Login</a></li>
					<li><a href="RegisterUser.jsp">Register</a></li>
				</c:if>
				<c:if test="${not empty user}">
					<c:if test="${user.isAdmin()}">
						<li><a href="SearchForUser">Edit User Role</a>
						<li><a href="AddClass?action=add">Add Class</a></li>	
					</c:if>
					<c:if test="${user.isStudent()}">
						<li><a href="AllClasses">Enroll</a>
					</c:if>
					<c:if test="${user.isAdvisor()}">
					
					</c:if>
					<c:if test="${user.isInstructor()}">
						<li><a href="InstructorClasses">Instructor Classes</a></li>
						<li><a href="InstructorRoster?action=getAll">Generate your Roster</a></li>		
						
					</c:if>
					<li><a href="Logout">Logout</a>
				</c:if>

			</ul>
		</div>
	</div>
</nav>
