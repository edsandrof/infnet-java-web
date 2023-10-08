<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>ALLCARS - VehicleDealer</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container mt-3">
    <h2>Autenticação</h2>

    <form action="/employee/validate" method="post">

        <div class="mb-3 mt-3">
            <label for="email">E-mail:</label>
            <input type="email" class="form-control" value="admin@allcars.com" id="email"
                   placeholder="Entre com o seu -mail" name="email">
        </div>

        <div class="mb-3">
            <label for="password">Senha:</label>
            <input type="password" class="form-control" value="123" id="password" placeholder="Entre com a sua senha"
                   name="password">
        </div>

        <button type="submit" class="btn btn-primary">Acessar</button>
    </form>
</div>
</body>
</html>