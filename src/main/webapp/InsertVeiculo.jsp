<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Veiculo</title>
</head>
<body>

	<%@ page import="conexao.Conexao, model.Proprietario, java.util.*, dao.ProprietarioDao" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%
	
	List<Proprietario> list = ProprietarioDao.getAllProprietarios();
	request.setAttribute("list", list);
	
	%>

<h1>Cadastrar Novo Veiculo</h1>

<form action="VeiculoListAndCreate" method="post">
	<table>
		<tr>
			<td>Placa: </td>
			<td><input type="text" name="placa"/></td>
		</tr>
		<tr>
			<td>Renavam: </td>
			<td><input type="text" name="renavam"/></td>
		</tr>
		<tr>
			<td>Nome do Proprietario: </td>
			<td>
				<select name="id_prop">
					<option>Selecione o Proprietario...</option>
					<c:forEach var="list" items="${list}">
						<option value="${list.id}">${list.nome}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2"><br></br><input type="submit" value="Cadastrar Veiculo" /></td>
		</tr>
	</table>
	
</form>


</body>
</html>