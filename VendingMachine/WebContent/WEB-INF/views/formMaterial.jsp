<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<style type="text/css">
<%@include file="/WEB-INF/lib/style.css" %></style>
<body>
 <h3>Adicionar material</h3>
 <form action="adicionaMaterial" method="post">
 Nome: <br />
 <textarea name="nome" rows="1" cols="20"></textarea><br>
 Quantidade: <br />
 <textarea name="quantidade" rows="1" cols="20"></textarea><br>
 Preço: <br />
 <textarea name="preco" rows="1" cols="20"></textarea><br>
 <input type="submit" value="Adicionar">
 </form>
</body></html>