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
		<h1>Produtos Disponíveis</h1>
		<div class="tbl-header">
			<table cellpadding="0" cellspacing="0" border="0">
				<thead>
					<tr>
						<th>Produto</th>
						<th>Quantidade</th>
						<th>Preço</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="tbl-content">
			<table cellpadding="0" cellspacing="0" border="0">
				<tbody>
					<% for (Material material : listaMateriais) {
    	  %>
					<tr>
						<td><%=material.getNome()%></td>
						<td><%=material.getQuantidade()%></td>
						<td><%=material.getPreco()%></td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</div>
	</section>



	<div class="made-with-love">

		<a target="_blank" href="/VendingMachine/criaSugestao">Tem
			sugestões de produtos? Clique Aqui!</a>
	</div>
</body>
</html>