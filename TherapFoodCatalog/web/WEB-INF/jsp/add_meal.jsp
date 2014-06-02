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
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div id="links">
            <a href="<fmt:message key="site.baseurl"/>newfood"><fmt:message key="url.name.addfood"/></a>&nbsp;&nbsp;
            <a href="<fmt:message key="site.baseurl"/>prev">Previous Meal</a>&nbsp;&nbsp;
            <a href="<fmt:message key="site.baseurl"/>logout">Logout</a>
            <br><fmt:message key="site.user.name"/>&nbsp;&nbsp;<c:out value="${authenticatedUserName}"/>(<c:out value="${authenticatedUserType}"/>)&nbsp;&nbsp;
        </div>
        <h1><fmt:message key="site.title"/></h1>

    </div>
    <div id="home_container">
        <h1><fmt:message key="addmeal.title"/>&nbsp;(<c:out value="${todaysDate}"/>&nbsp;-&nbsp;<c:out value="${todaysDay}"/>)</h1>
        <div class="meal_list_container">
            <div id="breakfast_list">
                <h3 style="text-align: left; margin-left: 15px; margin-bottom: 15px;"><fmt:message key="addmeal.currentlist.breakfast"/></h3>
                <ul>
                    <c:forEach var="food" items="${currentBreakfastList}">
                        <li><c:out value="${food.foodName}"/></li>
                    </c:forEach>
                </ul>
            </div>

            <div id="lunch_list">
                <h3 style="text-align: left; margin-left: 15px; margin-bottom: 15px;"><fmt:message key="addmeal.currentlist.lunch"/></h3>
                <ul>
                    <c:forEach var="food" items="${currentLunchList}">
                        <li><c:out value="${food.foodName}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="meal_list_container">
            <div id="breakfast_list_add">
                <h3 style="text-align: left; margin-left: 15px; margin-bottom: 15px;"><fmt:message key="addmeal.add.breakfast"/></h3>
                <form action="/mealAdd" method="POST">
                    <c:forEach var="food" items="${availableBreakfastList}">
                        <input type="checkbox" name="foods" value='<c:out value="${food.foodId}"/>'> <c:out value="${food.foodName}"/></br>
                    </c:forEach>
                    <input type="hidden" name="meal_type" value="breakfast">
                    <input type="submit" value="Add">
                </form>
            </div>

            <div id="lunch_list_add">
                <h3 style="text-align: left; margin-left: 15px; margin-bottom: 15px;"><fmt:message key="addmeal.add.lunch"/></h3>
                <form action="/mealAdd" method="POST">
                    <c:forEach var="food" items="${availableLunchList}">
                        <input type="checkbox" name="foods" value='<c:out value="${food.foodId}"/>'> <c:out value="${food.foodName}"/></br>
                    </c:forEach>
                    <input type="hidden" name="meal_type" value="lunch">
                    <input type="submit" value="Add">
                </form>
            </div>
        </div>
    </div>
    <div id="footer"><fmt:message key="footer.text"/></div>
</div>
</body>
</html>