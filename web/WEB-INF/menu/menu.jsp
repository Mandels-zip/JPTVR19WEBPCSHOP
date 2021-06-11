<%-- 
    Document   : menu
    Created on : Jan 25, 2021, 2:35:10 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark"">
  <a class="navbar-brand" href="index.jsp">Магазин</a>
 
    <div class="navbar-nav">
        <div class="navbar-nav w-100 d-flex justify-content-end">
            <%-- 
         <c:choose>
      <c:when test="${role eq 'ADMIN'}">
      <a class="nav-link <c:if test="${activeListCustomers}">active</c:if>" href="listCustomers">Список покупателей</a>
      <a class="nav-link <c:if test="${activePCForm}">active</c:if>" href="addPCForm">Добавить компьтер</a>
      <a class="nav-link <c:if test="${activeListComputers}">active</c:if>" href="listComputers">Список компьютеров</a>
      <a class="nav-link <c:if test="${activeBuyComputerForm}">active</c:if>" href="showBuyComputer">Выдать компьютер</a>
      <a class="nav-link <c:if test="${activeAdmin}">active</c:if>" href="adminPanel">Панель Администрации</a>
      <a class="nav-link <c:if test="${activeOut}">active</c:if>" href="logout">Выйти</a>  
      </c:when>
       <c:when test="${role eq 'MANAGER'}">
      <a class="nav-link <c:if test="${activePCForm}">active</c:if>" href="addPCForm">Добавить компьтер</a>
      <a class="nav-link <c:if test="${activeListComputers}">active</c:if>" href="listComputers">Список компьютеров</a>
      <a class="nav-link <c:if test="${activeBuyComputerForm}">active</c:if>" href="showBuyComputer">Выдать компьютер</a>
      <a class="nav-link <c:if test="${activeOut}">active</c:if>" href="logout">Выйти</a>
       </c:when>
        <c:when test="${role eq 'CUSTOMER'}">
      <a class="nav-link <c:if test="${activeListComputers}">active</c:if>" href="listComputers">Список компьютеров</a>
      <a class="nav-link <c:if test="${activeBuyComputerForm}">active</c:if>" href="showBuyComputer">Выдать компьютер</a>
      <a class="nav-link <c:if test="${activeOut}">active</c:if>" href="logout">Выйти</a>    
              </c:when>
       <c:otherwise>
      <a class="nav-link <c:if test="${activeListComputers}">active</c:if>" href="listComputers">Список компьютеров</a>
      <a class="nav-link <c:if test="${activeLogin}">active</c:if>" id="loginForm" href="loginForm">Войти</a>
      <a class="nav-link <c:if test="${activeRegistration}">active</c:if>" href="registrationForm">Регистрация</a>    
       </c:otherwise>
         </c:choose>
       
       --%>
      <a class="nav-link <c:if test="${activeListCustomers}">active</c:if>" href="listCustomers">Список покупателей</a>
      <a class="nav-link <c:if test="${activeListComputers}">active</c:if>" href="listComputers">Список компьютеров</a>
      <a class="nav-link <c:if test="${activeBuyComputerForm}">active</c:if>" href="showBuyComputer">Выдать компьютер</a>
      <a class="nav-link <c:if test="${activePCForm}">active</c:if>" href="addPCForm">Добавить компьтер</a>
      <a class="nav-link <c:if test="${activeAdmin}">active</c:if>" href="adminPanel">Панель Администрации</a>
       <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Статус
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <li><a style = "color: black" class="nav-link <c:if test="${activeLogin}">active</c:if>" id="loginForm" href="loginForm">Войти</a></li>
                <li><a style = "color: black" class="nav-link <c:if test="${activeOut}">active</c:if>" href="logout">Выйти</a></li>
                <li><a style = "color: black" class="nav-link <c:if test="${activeRegistration}">active</c:if>" href="registrationForm">Регистрация</a> </li>
          </ul>
        </li>  

  </div>
</nav>

    