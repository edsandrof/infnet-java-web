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
    <h3>Listagem de Motos:</h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>Marca</td>
            <td>Ano</td>
            <td>Combustível</td>
            <td>Preço base</td>
            <td>Preço total</td>
            <td>Trilha</td>
            <td>CC</td>
            <td>Categoria</td>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="m" items="${motorcycles}">
            <tr>
                <td>${m.id}</td>
                <td>${m.brand}</td>
                <td>${m.year}</td>
                <td>${m.fuelType}</td>
                <td>${m.basePrice}</td>
                <td>${m.totalPrice}</td>
                <td>${m.offRoad}</td>
                <td>${m.cubicCapacity}</td>
                <td>${m.category}</td>
                <td><a href="${pageContext.request.contextPath}/vehicle/motorcycle/${m.id}"><span class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>