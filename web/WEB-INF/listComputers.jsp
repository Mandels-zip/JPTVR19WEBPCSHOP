<%-- 
 
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table class="table">
  <thead class="table-dark">
    <tr>
          <th scope="col">Производитель</th>
          <th scope="col">Модель</th>
          <th scope="col">Процессор</th>
          <th scope="col">Видеокарта</th>
          <th scope="col">ОЗУ</th>
          <th scope="col">Звуковая карта</th>
          <th scope="col">Жесткий диск</th>
          <th scope="col">ССД</th>
          <th scope="col">Блок питания</th>
          <th scope="col">Цена</th>
          <th scope="col">Количество</th>
    </tr>
  </thead>
    <c:forEach var="сomputer" items="${listComputers}"> 
  <tbody>
      <tr>
          <td>${сomputer.manufacturer}</td>
          <td>${сomputer.model}</td>
          <td>${сomputer.procmodel}</td>
          <td>${сomputer.videocard}</td>
          <td>${сomputer.ram}</td>
          <td>${сomputer.soundboard}</td>
          <td>${сomputer.harddrive}</td>
          <td>${сomputer.ssd}</td>
          <td>${сomputer.power}</td>
          <td>${сomputer.price}</td>
          <td>${сomputer.quantity}</td>
      </tr>
  </tbody>
  </c:forEach>
</table>

