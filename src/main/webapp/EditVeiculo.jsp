<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edição de Veiculo</title>
</head>
<body>

	<%@ page import="conexao.Conexao, model.Veiculo, java.util.*, dao.VeiculoDao" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	

	<h1>Edição de Veiculo</h1>
	
	<form action="VeiculoUpdate"  method="post">
		
			<input type="hidden" name="id" value="${veiculo.id}"/>
			<table>
				<tr>
					<td>Placa: </td>
					<td><input type="text" name="placa" value="${veiculo.placa}"/></td>
				</tr>
				<tr>
					<td>Renavam: </td>
					<td><input type="text" name="renavam" value="${veiculo.renavam}"/></td>
				</tr>
				<tr>
					<td>Nome do Proprietario: </td>
					<td>
						<select name="id_prop">
<%-- 								<option value="${veiculo.proprietario.id}"> ${veiculo.proprietario.nome}</option> --%>
							<c:forEach var="list" items="${list}">
								<option <c:if test="${list.id == veiculo.proprietario.id }">selected="selected"</c:if>
								value="${list.id}">${list.nome}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><br><input type="submit" value="Editar Veiculo"/></td>
				</tr>
			</table>
		
	</form>

</body>
</html>