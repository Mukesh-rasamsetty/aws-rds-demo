<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Employee</title>
</head>
<body>
	<div id="container-fluid">
		<div id="container-fluid">
			<h1>Employee Details</h1>
			<br /> <a href="/Employee" class="btn btn-info">Add Employee</a> <br />
			<p class="text-success">${status}</p>
			<div class="container-fluid">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Mobile</th>
							<th scope="col" colspan="2">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="temp" items="${employeeList}">
							<tr>
								<td>${temp.id}</td>
								<td>${temp.name}</td>
								<td>${temp.email}</td>
								<td>${temp.mobile}</td>
								<td><form:form action="/${temp.id}" method="post">
										<input type="submit" class="btn btn-warning" value="Update" />
									</form:form></td>
								<td><form:form action="/${temp.id}" method="get">
										<input type="submit" class="btn btn-danger" value="Delete" />
									</form:form></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
