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
    <h3>Listagem de Veículos:</h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>Marca</td>
            <td>Ano</td>
            <td>Combustível</td>
            <td>Preço base</td>
            <td>Preço total</td>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="v" items="${vehicles}">
            <tr>
                <td>${v.id}</td>
                <td>${v.brand}</td>
                <td>${v.year}</td>
                <td>${v.fuelType}</td>
                <td>${v.basePrice}</td>
                <td>${v.totalPrice}</td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>