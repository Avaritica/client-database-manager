<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Save new Client</title>
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-client-style.css">			
</head>
<body>
		
		<div id="wrapper">
			<div id="header">
				<h2>Client Information Manager</h2>	
			</div>	
		</div>
		<div id="container">
			<h3>Save Client</h3>
			
			<form:form action="saveClient" modelAttribute="client" method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>First name:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						
						<tr>
							<td><label>Last name:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						
						<tr>
							<td><label>Email Address:</label></td>
							<td><form:input path="email" /></td>
						</tr>	
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>																	
					</tbody>				
				</table>				
			</form:form>
		
			<div style="clear; both;"></div>
			
			<p>
				<a href="${pageContext.request.contextPath}/client/list">Back to List</a>
			</p>
		
		</div>
</body>
</html>