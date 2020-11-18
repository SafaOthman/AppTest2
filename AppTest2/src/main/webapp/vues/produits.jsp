<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<c:set var="cxt" value="${pageContext.request.contextPath }"/>
</head>
<body>
<h2>Liste des produits</h2>
<table border="1">
<c:forEach items="${liste}" var="p">
<tr>
<td>${p.id }</td><td>${p.titre }</td><td>${p.prix }</td>
<sec:authorize access="hasRole('ADMIN')">
<td><a href="${cxt}/deleteProduit/${p.id}"> Delete</a> </td>
</sec:authorize>

</tr>
</c:forEach>
</table>

<sec:authorize access="hasRole('ADMIN')">
<p> <a href="${cxt}/ajoutProduit"> Ajouter un produit</a> </p>

</sec:authorize>
</body>
</html>