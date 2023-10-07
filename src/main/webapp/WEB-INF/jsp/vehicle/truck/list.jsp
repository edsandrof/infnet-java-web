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
    <h3>Listagem de Caminhões:</h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>Marca</td>
            <td>Ano</td>
            <td>Combustível</td>
            <td>Preço base</td>
            <td>Preço total</td>
            <td>Capacidade de carga (T)</td>
            <td>Número de Eixos</td>
            <td>Caçamba</td>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="t" items="${trucks}">
            <tr>
                <td>${t.id}</td>
                <td>${t.brand}</td>
                <td>${t.year}</td>
                <td>${t.fuelType}</td>
                <td>${t.basePrice}</td>
                <td>${t.totalPrice}</td>
                <td>${t.loadCapacity}</td>
                <td>${t.numberOfAxle}</td>
                <td>${t.hasCargoBody}</td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>