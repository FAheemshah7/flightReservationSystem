<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>

	<form action="registerUser" method="post">
		<pre>
			First Name:<input type="text" name="f_name" />
			Last Name : <input type="text" name="l_name" />
			User NAme : <input type="text" name="email" />
			Password  :<input type="password" name="pass" />
			Confirm Password:<input type="password" name="cpass" />
			
			<input type="submit" name="register" />
		</pre>
	</form>

</body>
</html>