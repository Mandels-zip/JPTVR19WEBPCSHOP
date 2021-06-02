<%-- 
    Document   : addPCForm
    Created on : Jan 17, 2021, 8:33:51 PM
    Author     : ilja2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавление ПК</title>
  </head>
  <body>
    <h1>Добавить новый ПК</h1>
    <p>${info}</p>
    <br>
    <a href="index.jsp">Главная страница</a>
    <form action="createComputer" method="POST">
      Производитель <input type="text" name="manufacturer"><br>
      Модель <input type="text" name="model"><br>
      Процессор <input type="text" name="procmodel"><br>
      Видеокарта<input type="text" name="videocard"><br>
      Оперативная карта<input type="text" name="ram"><br>
      Звуковая карта<input type="text" name="soundboard"><br>
      Жесткий диск<input type="text" name="harddrive"><br>
      ССД<input type="text" name="ssd"><br>
      Блок питания<input type="text" name="power"><br>
      Цена<input type="text" name="price"><br>
      Кол-во<input type="text" name="quantity"><br>
      <input class="btn btn-dark" type="submit" name="submit" value="Добавить">
    </form>
  </body>
</html>