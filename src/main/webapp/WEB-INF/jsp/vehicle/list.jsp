<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>VehicleDealer</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../menu.jsp"/>

<div class="container-fluid mt-3">
    <h3>Listagem de Ve�culos:</h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>Marca</td>
            <td>Ano</td>
            <td>Combust�vel</td>
            <td>Pre�o base</td>
            <td>Pre�o total</td>
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