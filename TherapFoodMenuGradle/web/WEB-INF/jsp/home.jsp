<%--
  Created by IntelliJ IDEA.
  User: sanjoy.saha
  Date: 5/21/14
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="../../css/style.css"/>"><!---->
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div id="links">
            <a href="<fmt:message key="site.baseurl"/>logout">Logout</a>
            <br><fmt:message key="site.user.name"/>&nbsp;&nbsp;<c:out value="${authenticatedUserName}"/>(<c:out value="${authenticatedUserType}"/>)&nbsp;&nbsp;
        </div>
        <h1><fmt:message key="site.title"/></h1>

    </div>
    <div id="home_container">
        <h1><fmt:message key="home.title"/>&nbsp;(<c:out value="${todaysDate}"/>&nbsp;-&nbsp;<c:out value="${todaysDay}"/>)</h1>
        <div class="meal_list_container">

            <div id="breakfast_list">
                <h3 style="text-align: left; margin-left: 15px; margin-bottom: 15px;"><fmt:message key="home.breakfast.title"/></h3>
                <ul>
                    <c:forEach var="food" items="${currentBreakfastList}">
                        <li><c:out value="${food.foodName}"/></li>
                    </c:forEach>
                </ul>
            </div>

            <div id="lunch_list">
                <h3 style="text-align: left; margin-left: 15px; margin-bottom: 15px;"><fmt:message key="home.lunch.title"/></h3>
                <ul>
                    <c:forEach var="food" items="${currentLunchList}">
                        <li><c:out value="${food.foodName}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <div id="footer">
        <p><fmt:message key="footer.text"/></p>
    </div>
</div>
</body>
</html>