<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">
<%@include file="/WEB-INF/lib/style.css" %></style>
<head>
<script>
$(window).on("load resize ", function() {
	  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
	  $('.tbl-header').css({'padding-right':scrollWidth});
	}).resize();
</script>

<meta charset="ISO-8859-1">

<%@ page import="java.util.*,mvc.model.*" %>
<%@ page import="java.util.*,mvc.controller.*" %>

<%List<Material> listaMateriais = (ArrayList<Material>) request.getAttribute("material");%>
<title>Home</title>
</head>

<body>
<section>
  <!--for demo wrap-->
  <h1>Inventário</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Produto</th>
          <th>Quantidade</th>
          <th>Vendas</th>
          <th>Preço</th>
          <th>Sucesso</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      <% for (Material material : listaMateriais) {
    	  String sucesso = "Baixo";
    	  if(material.getVendas()>5){
    		  sucesso = "Médio";
    	  }
    	  if(material.getVendas()>10){
    		  sucesso = "Alto";
    	  }
    	  if(material.getVendas()<6){
    		  sucesso = "Baixo";
    	  }
    	  if(material.getVendas()==0){
    		  sucesso = "Indefinido";
    	  }
    	  %>
        <tr>
          <td><%=material.getNome()%></td>
          <td><%=material.getQuantidade()%></td>
          <td><%=material.getVendas()%></td>
          <td><%=material.getPreco()%></td>
          <td><%=sucesso%></td>
        </tr>
        <% } %>
      </tbody>
    </table>
  </div>
</section>



<div class="made-with-love">

  <a target="_blank" href="/VendingMachine/sugeridos">Ver sugestões de produtos</a>
</div>
</body>
</html>