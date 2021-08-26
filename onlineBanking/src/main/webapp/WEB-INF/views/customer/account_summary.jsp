<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello, ${sessionScope.customer_details.username}</h3>
	<h4>Your Account Details</h4>
	<table style="background-color: lightgrey; margin: auto">
		<caption>Account List</caption>
		<c:forEach var="account" items="${requestScope.account_details}">
			<tr>
				<td>${account.id}</td>
				<td>${account.accountType}</td>
				<td>${vendor.openingBalance}</td>
			</tr>
		</c:forEach>
	</table>
	<h5>
		<a href="<spring:url value='/account/add_account'/>">Create Account</a></td>
	</h5>
	<h5>
	<a href="<spring:url value='/account/delete_account?id=${account.id}'/>">Delete</a></h5>
	<h5>
		<a href="<spring:url value='/user/logout'/>">Log Me Out</a>
	</h5>
</body>
</html>