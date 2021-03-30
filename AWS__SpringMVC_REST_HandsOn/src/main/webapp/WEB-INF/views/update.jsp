<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Employee</title>
</head>
<body>
	<div id="container-fluid">
		<div id="container-fluid">
		<a href="/" class="btn btn-info">Home</a><br/><br/>
			<div class="container-fluid">
			<form:form action="/Employee" modelAttribute="employee" method="put">
				<div class="row">
					<form:hidden path="id"></form:hidden>
				</div>
				<div class="row">
					<div class="col-2"><form:label path="id">Enter id:</form:label> </div>
					<div class="col"><form:input path="id" class="form-control"  disabled="true"/></div>
					<div class="col"><form:errors path="id"></form:errors></div>
				</div>
				<div class="row">
					<div class="col-2"><form:label path="name">Enter Name:</form:label> </div>
					<div class="col"><form:input path="name" class="form-control"/></div>
					<div class="col"><form:errors path="name" cssClass="error"></form:errors></div>
				</div>
				<div class="row">
					<div class="col-2"><form:label path="email">Enter Email:</form:label> </div>
					<div class="col"><form:input path="email" class="form-control"/></div>
					<div class="col"><form:errors path="email" cssClass="error"></form:errors></div>
				</div>
				<div class="row">
					<div class="col-2"><form:label path="mobile">Enter Mobile:</form:label> </div>
					<div class="col"><form:input path="mobile" class="form-control"/></div>
					<div class="col"><form:errors path="mobile" cssClass="error"></form:errors></div>
				</div>
				<div class="row">
					<div class="col-5"></div>
					<div class="col-2"><input type="submit" value="Update-Employee" class="form-control btn btn-warning"/></div>
					<div class="col-5"></div>
				</div>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>