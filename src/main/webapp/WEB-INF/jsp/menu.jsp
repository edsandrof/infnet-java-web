<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant" %>

<nav class="navbar navbar-dark bg-success">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/about">VehicleDealer</a>
        </div>

        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="<%=Constant.Route.EMPLOYEE%>">Funcionários</a></li>

            <c:if test="${not empty employee}">
                <li><a href="<%=Constant.Route.VEHICLE_BUYER%>">Compradores</a></li>
                <li><a href="<%=Constant.Route.VEHICLE_SALE%>">Vendas</a></li>
                <li><a href="<%=Constant.Route.VEHICLE%>">Veículos</a></li>
                <li><a href="<%=Constant.Route.CAR%>">Carros</a></li>
                <li><a href="<%=Constant.Route.MOTORCYCLE%>">Motos</a></li>
                <li><a href="<%=Constant.Route.TRUCK%>">Caminhões</a></li>
            </c:if>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty employee}">
                <li><a href="/employee/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>

            <c:if test="${not empty employee}">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout ${employee.email}</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>