<%-- 
    Document   : loginForm
    Created on : Feb 12, 2021, 1:34:14 PM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login form</title>
    </head>
    <body>
        <h2>Введите логин и пароль</h2>
    <a href="index.jsp">Главная страница</a>
    <form action="login" method="POST">
        Логин: <input type="text" name="login" id="login" value="${login}">
        <br>
        Пароль: <input id = "password" type="password" name="password">
        <br>
        <input id="btn-submit" class="btn btn-dark" type="submit" value="Войти">
    </form>
    </body>
</html>
