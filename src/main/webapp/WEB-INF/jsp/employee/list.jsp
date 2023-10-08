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
    <h3>Listagem de Empregados</h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>Nome</td>
            <td>E-mail</td>
            <td>Senha</td>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${employees}">
            <tr>
                <td>${e.id}</td>
                <td>${e.name}</td>
                <td>${e.email}</td>
                <td>${e.password}</td>
                <td><a href="${pageContext.request.contextPath}/employee/${e.id}"><span class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>