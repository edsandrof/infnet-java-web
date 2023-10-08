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
    <h3>Listagem de Compradores:</h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>Nome</td>
            <td>Endereço</td>
            <td>Fone</td>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="b" items="${buyers}">
            <tr>
                <td>${b.id}</td>
                <td>${b.name}</td>
                <td>${b.address}</td>
                <td>${b.phone}</td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>