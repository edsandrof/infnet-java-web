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
<jsp:include page="../../menu.jsp"/>

<div class="container-fluid mt-3">
    <h4><a href="${pageContext.request.contextPath}/vehicle/car/register"> Novo</a></h4>
    <h3>Listagem de Carros:</h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>Marca</td>
            <td>Ano</td>
            <td>Combustível</td>
            <td>Preço base</td>
            <td>Preço total</td>
            <td>Portas</td>
            <td>Cor</td>
            <td>Motor v8</td>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${cars}">
            <tr>
                <td>${c.id}</td>
                <td>${c.brand}</td>
                <td>${c.year}</td>
                <td>${c.fuelType}</td>
                <td>${c.basePrice}</td>
                <td>${c.totalPrice}</td>
                <td>${c.numberOfDoors}</td>
                <td>${c.color}</td>
                <td>${c.v8Engine}</td>
                <td><a href="${pageContext.request.contextPath}/vehicle/car/${c.id}"><span class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>