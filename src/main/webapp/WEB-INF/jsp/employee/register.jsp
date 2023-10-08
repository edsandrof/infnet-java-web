<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>ALLCARS - VehicleDealer</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../menu.jsp"/>

<div class="container-fluid mt-3">
    <h3>Cadastro de Empregados</h3>

    <form action="${pageContext.request.contextPath}/employee/register" method="post">

        <div class="mb-3 mt-3">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" value="Human Resources" id="nome" placeholder="Entre com o seu nome" name="name">
        </div>

        <div class="mb-3 mt-3">
            <label for="email">E-mail</label>
            <input type="email" class="form-control" value="hr@allcars.com" id="email" placeholder="Entre com o seu e-mail" name="email">
        </div>

        <div class="mb-3">
            <label for="password">Senha</label>
            <input type="password" class="form-control" value="123" id="password" placeholder="Entre com a sua senha" name="password">
        </div>

        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</div>
</body>
</html>