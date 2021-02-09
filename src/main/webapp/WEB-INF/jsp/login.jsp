<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Login</h1>
	<form:form method="POST" action="/loginUser" modelAttribute="userDetail">
		<table  align="center">
			<tr>
				<th><form:label path="username">Username</form:label></th>
				<th><form:input path="username" /></th>
				<th><form:errors path="username" cssStyle="color:red" /></th>
			</tr>
			<tr>
				<th><form:label path="password">Password</form:label></th>
				<th><form:password path="password"  /></th>
				<th><form:errors path="password" cssStyle="color:red" /></th>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>