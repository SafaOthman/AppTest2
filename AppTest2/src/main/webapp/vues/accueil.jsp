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
<link href="<c:url value='/bootdtrap/css/bootstrap.min.css' />" rel="stylsheet" >
</head>
<body>
<sec:authorize access="isAuthenticated()">
     Bienvenue <sec:authentication property="name"/> 
     (<a href ='<c:url value="/logout"/> '>se deconnecter</a>)
</sec:authorize>

<h2>Liste des Magasins</h2>
<table border="1">
<c:forEach items="${liste}" var="m">
<tr>
<td>${m.id }</td><td>${m.nom }</td>
<td> <a href="${cxt}/produits/${m.id }"> Liste des produits</a> </td>
</tr>
</c:forEach>
</table>
<sec:authorize access="hasRole('ADMIN')">

<p> <a href="${cxt}/ajoutProduit"> Ajouter un produit</a> </p>

</sec:authorize>
</body>
</html>