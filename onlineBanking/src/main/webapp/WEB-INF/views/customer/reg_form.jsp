<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" modelAttribute="customer">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter UserName</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Enter Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:password path="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>