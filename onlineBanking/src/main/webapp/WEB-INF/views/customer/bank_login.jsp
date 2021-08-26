<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h5>${requestScope.message}</h5>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter User Email</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><button type="submit" formaction="bank_login">Login</button></td>
              <!--   <td><button type="submit" formaction="reg_form">Register</button></td> -->
              <td><a href="reg_form">Register</a></td>
			</tr>
		</table>
	</form>
</body>
</html>