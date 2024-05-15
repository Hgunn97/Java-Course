<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>My E-Banking Application!</h2>
<form action="LoginSignInController" method="post">
<label>EmailId</label>
<input type="email" name="emailid"/><br/>
<label>Password</label>
<input type="password" name="password"/><br/>
<label>TypeOfUser</label>
<input type="radio" name="typeofuser" value="Manager">Manager
<input type="radio" name="typeofuser" value="Customer">Customer<br/>
<input type="submit" value="SignIn"/>
<input type="reset" value="reset"/>
</form>
</body>
</html>