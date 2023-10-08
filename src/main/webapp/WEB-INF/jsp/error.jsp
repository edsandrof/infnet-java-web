<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>ALLCARS - VehicleDealer</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container-fluid mt-3 bg-danger">

    <div class="d-flex align-items-center justify-content-center vh-100">
        <div class="text-center">
            <h1 class="display-1 fw-bold"><%=response.getStatus()%>
            </h1>
            <p class="fs-3"><span class="text-danger">Opps!</span></p>
            <p class="lead">
                Ocorreu um erro!
            </p>
            <a href="/" class="btn btn-success">Home</a>
        </div>
    </div>

</div>
</body>
</html>