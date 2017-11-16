<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Register Here</h1>
	<br/>

	<h2> Account Information </h2>
	<br/>
			<s:form action= "register" method="get" modelAttribute="bean"  >
			Email: <s:input path ="email"/><br/>
			<s:errors path="email"/><br/>
			Password: <s:input path ="password"/><br/>
			<s:errors path="password"/><br/>
			ConfirmPassword: <s:input path ="cpassword"/><br/>
			<s:errors path="cpassword"/><br/>
			

			<h2> Personal Information </h2>
			First Name: <s:input path ="name"/><br/>
			<s:errors path="name"/><br/>
			Last Name: <s:input path ="lname"/><br/>
			<s:errors path="lname"/><br/>
			Date of birth: <s:input path="dob"/><br/>
			<s:errors path="dob"/><br/>
			City: <s:input path ="city"/><br/>
			<s:errors path="city"/><br/>
			<input type="submit" value="Register"/>
			</s:form>
	
</body>
</html>