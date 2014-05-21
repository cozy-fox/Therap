<%--
  Created by IntelliJ IDEA.
  User: sanjoy.saha
  Date: 5/21/14
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setBundle basename="net.therap.properties.messages"/>
<html>
<head>
    <title>Admin Add Meal Page</title>
</head>
<body>
    <h1>Add Meal</h1>

    <!--form action="/mealAdd" method="POST">
        <input type="radio" name="meal_type" value="breakfast">Breakfast<br>
        <input type="radio" name="meal_type" value="lunch">Lunch<br><br>

        <c:forEach var="food" items="${allFoodList}">
            <input type="checkbox" name="foods" value='<c:out value="${food.foodId}"/>'> <c:out value="${food.foodName}"/></br>
        </c:forEach>

        <input type="submit" value="Add">
    </form-->

    <h3>Breakfast List For Today</h3>
    <ol>
        <c:forEach var="food" items="${currentBreakfastList}">
            <li><c:out value="${food.foodName}"/></li>
        </c:forEach>
    </ol>

    <h3>Lunch List For Today</h3>
    <ol>
        <c:forEach var="food" items="${currentLunchList}">
            <li><c:out value="${food.foodName}"/></li>
        </c:forEach>
    </ol>




    <h3>Available Breakfast List For Today</h3>
    <form action="/mealAdd" method="POST">
    <c:forEach var="food" items="${availableBreakfastList}">
        <input type="checkbox" name="foods" value='<c:out value="${food.foodId}"/>'> <c:out value="${food.foodName}"/></br>
    </c:forEach>
        <input type="hidden" name="meal_type" value="breakfast">
        <input type="submit" value="Add">
    </form>

    <h3>Available Lunch List For Today</h3>
    <form action="/mealAdd" method="POST">
    <c:forEach var="food" items="${availableLunchList}">
        <input type="checkbox" name="foods" value='<c:out value="${food.foodId}"/>'> <c:out value="${food.foodName}"/></br>
    </c:forEach>
        <input type="hidden" name="meal_type" value="breakfast">
        <input type="submit" value="Add">
    </form>


</body>
</html>