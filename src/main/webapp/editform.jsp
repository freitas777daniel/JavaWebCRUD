<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edição de Proprietário</title>
</head>
<body>

	<h1>Edição do Proprietário</h1>
	
	<form action="ProprietarioUpdate"  method="post">
		
			<input type="hidden" name="id" value="${proprietario.id}"/>
			<table>
				<tr>
					<td>CPF-CNPJ: </td>
					<td><input type="text" name="cpf_cnpj" value="${proprietario.cpf_cnpj}"/></td>
				</tr>
				<tr>
					<td>Nome: </td>
					<td><input type="text" name="nome" value="${proprietario.nome}"/></td>
				</tr>
				<tr>
					<td>Endereço: </td>
					<td><input type="text" name="endereco" value="${proprietario.endereco}"/></td>
				</tr>
				<tr>
					<td><br><input type="submit" value="Editar Proprietario"/></td>
				</tr>
			</table>
		
	</form>

</body>
</html>