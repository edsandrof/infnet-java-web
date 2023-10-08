<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>ALLCARS - VehicleDealer</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="menu.jsp"/>

<div class="container mt-3">
    <h2>${project.name} - ${project.description}</h2>

    <c:forEach var="c" items="${project.classes}">
        <p>${c.name}</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Field</th>
                <th>Type</th>
                <th>Note</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="a" items="${c.attribute}">
                <tr>
                    <td>${a.name}</td>
                    <td>${a.type}</td>
                    <td>${a.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:forEach>
</div>
</body>
</html>