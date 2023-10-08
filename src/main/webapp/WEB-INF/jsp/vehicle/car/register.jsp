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
    <h3>Cadastro de Carros</h3>

    <form action="${pageContext.request.contextPath}/vehicle/car/register" method="post">

        <div class="mb-3 mt-3">
            <label for="brand">Marca</label>
            <input type="text" class="form-control" value="HB20" id="brand" name="brand">
        </div>

        <div class="mb-3 mt-3">
            <label for="year">Ano</label>
            <input type="text" class="form-control" value="2020" id="year" name="year">
        </div>

        <div class="mb-3 mt-3">
            <label for="fuelType">Combustível</label>
            <input type="text" class="form-control" value="GASOLINE" id="fuelType" name="fuelType">
        </div>

        <div class="mb-3 mt-3">
            <label for="basePrice">Preço base</label>
            <input type="text" class="form-control" value="5000" id="basePrice" name="basePrice">
        </div>

        <div class="mb-3 mt-3">
            <label for="numberOfDoors">Número de portas</label>
            <input type="text" class="form-control" value="TWO_DOORS" id="numberOfDoors" name="numberOfDoors">
        </div>

        <div class="mb-3 mt-3">
            <label for="color">Cor</label>
            <input type="text" class="form-control" value="WHITE" id="color" name="color">
        </div>

        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</div>
</body>
</html>