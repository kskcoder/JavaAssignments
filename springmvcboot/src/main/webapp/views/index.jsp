<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="addUser" method="post">
		id: <input type="text" name="uid"> </br>
		first name: <input type="text" name="fname"> </br>
		last name: <input type="text" name="lname"> </br>
		<input type="submit">
		
	</form>
	
	</br>
	
	<form action="getUser" method="get">
		id: <input type="text" name="uid"> </br>
		<input type="submit">
		
	</form>
	
	</br>
		
		<form action="getUserByName" method="get">
			name: <input type="text" name="fname"> </br>
			<input type="submit">
			
		</form>

</body>
</html>