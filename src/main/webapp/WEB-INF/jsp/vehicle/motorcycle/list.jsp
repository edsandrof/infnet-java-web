<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>VehicleDealer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

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
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>