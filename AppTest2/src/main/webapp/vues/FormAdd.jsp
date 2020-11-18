<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Ajouter un produit</h2>
<form:form method="POST" action="saveProduit" modelAttribute="p">
<p>  Titre : <form:input path="titre" /></p>
<p>  Prix : <form:input path="prix" /></p>
<p> Magasin : <form:select  path="mag.id" items="${liste}" itemValue="id"  itemLabel="nom"/></p>
<p> <input type="submit" value="Ajouter"></p>
</form:form>
</body>
</html>