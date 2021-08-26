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
<form:form method="post" modelAttribute="account">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter A/C Type</td>
				<td><form:input path="accountType"  /></td>
			</tr>
			<tr>
				<td>Enter Opening Balance</td>
				<td><form:input path="openingBalance" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Create Account" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>