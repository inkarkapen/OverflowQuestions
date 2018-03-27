<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Question</title>
</head>
<body>
<h1>What is your question?</h1>
<form method="POST" action="/questions/submit">
	<p>Question<input type="text" name="question" /></p>
	<p>Tags (separated with a space)<input type="text" name="raw_tags" /></p>
	<input type="submit" value="Create"/>
</form>
<a href = "/">Go back</a>
</body>
</html>