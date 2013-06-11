<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recipe ${recipe.oid}</title>

</head>
<body>
	<h1>${recipe.titulo}</h1>
	<b>Problema:</b>
	<p>${recipe.problema}</p>
	<b>Solucao:</b>
	<p>${recipe.solucao}</p>
	<b>Ator:</b>
	<p>${recipe.autor}</p>
	<b>Data de Criação:</b>
	<p>${recipe.creationTimestamp}</p>
	<b>Tags:</b>
	<c:forEach var="tag" items='${tag}'>
	${tag.tag}</b>
	
</c:forEach>
<a href="/recipes/delete/${recipe.oid}">Apagar Receita</a><br/>	
</body>
</html>