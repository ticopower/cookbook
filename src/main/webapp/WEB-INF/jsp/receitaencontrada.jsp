<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recipe List</title>
</head>
<body>
<c:forEach var="receitaencontrada" items='${receitaencontrada}'>
	<a href="/recipes/${receitaencontrada.oid}">${receitaencontrada.titulo}</a><br/>
	<a href="/recipes/delete/${receitaencontrada.oid}">Apagar Receita</a><br/>
</c:forEach>
</body>
</html>