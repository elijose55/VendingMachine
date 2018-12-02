<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<style type="text/css">  <%@include file="/WEB-INF/lib/form_style.css" %> </style>

<body>


<div class="login-page">
  <div class="form">
  <h3>Sugestão de Produto</h3>
    <form class="login-form" action="adicionaSugestao" method="post"><br>
      <input type="text" name="nome" placeholder="Nome do produto"/>
      <input id="botao" type="submit" value="Enviar">
    </form>
  </div>
</div>
</body>
</html>