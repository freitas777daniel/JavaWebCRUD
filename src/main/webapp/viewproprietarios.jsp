<!DOCTYPE html>
<%@page import="dao.ProprietarioDao"%>
<html>
<head>
<meta charset="UTF-8">
<title>Visualização de Proprietários</title>
</head>
<body>

	<%@ page import="conexao.Conexao, model.Proprietario, java.util.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	

	<h1>Listagem de Proprietários</h1>
	

	<table border="2">
		<tr>
			<th>ID</th>
			<th>CPF-CNPJ</th>
			<th>Nome</th>
			<th>Endereço</th>
			<th style="color:blue;padding:7px">Editar</th>
			<th style="color:red;padding:7px">Excluir</th>
		</tr>
		
		<c:forEach items="${list}" var="proprietario">
			<tr>
				<td>${proprietario.id}</td>
				<td>${proprietario.cpf_cnpj}</td>
				<td>${proprietario.nome}</td>
				<td>${proprietario.endereco}</td>
				<td><a href="ProprietarioUpdate?id=${proprietario.id}">Editar</a></td>
				<td><a href="ProprietarioDelete?id=${proprietario.id}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="insertform.html">Adicionar Novo Proprietario</a><br></br>


</body>
</html>