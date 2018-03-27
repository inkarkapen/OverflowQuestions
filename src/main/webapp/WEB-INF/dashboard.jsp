<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
</head>
<style>
	th, tr, td{
		border: 1px black solid;
	}
</style>
<body>
	<table>
		<tr>
			<th>Question</th>
			<th>Tags</th>
			<th>Links</th>
		</tr>
		<c:forEach items = "${ questions }" var = "question">
			<tr>
				<td><c:out value = "${ question.question }"/></td>
				<td>
					<c:forEach items="${question.tags}" var="tag">
						<c:out value="${tag.tag} " />
					</c:forEach>
				</td>
				<td><a href = "questions/${ question.id }">Show Question</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href = "question/new">New Question</a>
</body>
</html>