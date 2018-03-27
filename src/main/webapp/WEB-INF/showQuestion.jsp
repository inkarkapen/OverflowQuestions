<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question Detail</title>
</head>
<body>
<h1><c:out value="${question.question}" /></h1>
<h1><c:out value="${question.id}" /></h1>
<h2>Tags</h2>
<c:forEach items="${question.tags}" var="tag">
<button><c:out value="${tag.tag}" /></button>
</c:forEach>
<table>
	<tr>
		<th>Answers</th>
		<c:forEach items="${question.answers}" var="answer">
			<tr><td><c:out value="${answer.answer}" /></td></tr>
		</c:forEach>
	</tr>
</table>

<h2>Add your answer:</h2>
<form:form method="POST" action="/answers/submit" modelAttribute="questionAnswer">
    <form:label path="question">
    <form:errors path="question"/>
    <%-- <fmt:parseNumber var ="i" integerOnly = "true" type="number" value="${question.id}" /> --%>
    <form:input type="hidden" path="question" value="${question.id}" /></form:label>

    <form:label path="answer">
    <form:errors path="answer"/>
    <form:input path="answer"/></form:label>
    
    <input type="submit" value="Add Answer"/>
</form:form>
<a href = "/">Go back</a>
</body>
</html>