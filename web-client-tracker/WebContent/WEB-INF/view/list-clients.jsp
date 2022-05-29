<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>List of Clients</title>

	<!-- reference the css -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Client Information Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
		
			<!-- Add a button for adding client -->
			<input type="button" value="Add Client"
					onclick="window.location.href='AddNewClient'; return false;"
					class="add-button"
			/>
			
			<!--  Add a search box -->
			<form:form action="searchClient" method="POST">
				Search Client: <input type="text" name="theSearchName"/>
				
				<input type="submit" value="Search" class="add-button"/>			
			</form:form>
			
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempClient" items="${clients}">
				
				<!-- construct an "update link" client id  -->
				<c:url var="updateLink" value="/client/showFormForUpdate">
					<c:param name="clientID" value="${tempClient.id }">
				</c:param>
				</c:url>
				
				<!-- construct an "delete link" client id  -->
				<c:url var="deleteLink" value="/client/delete">
					<c:param name="clientID" value="${tempClient.id }">
				</c:param>
				</c:url>				
				
					<tr>
						<td>${tempClient.firstName }</td>
						<td>${tempClient.lastName }</td>
						<td>${tempClient.email }</td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink }">Update</a>
							|
							<a href="${deleteLink }" 
							onclick="if (!(confirm('Are you sure you want to delete this client?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>	
	</div>
</body>
</html>