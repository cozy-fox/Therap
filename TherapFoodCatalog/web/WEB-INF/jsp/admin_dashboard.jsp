<%--
  Created by IntelliJ IDEA.
  User: sanjoy.saha
  Date: 5/25/14
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setBundle basename="net.therap.properties.messages"/>
<html>
<head>
    <title><fmt:message key="addfood.title"/></title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div id="links">
            <a href="<fmt:message key="site.baseurl"/>admin"><fmt:message key="url.name.admin"/></a>&nbsp;&nbsp;
            <a href="<fmt:message key="site.baseurl"/>prev"><fmt:message key="url.name.previous"/></a>&nbsp;&nbsp;
            <a href="<fmt:message key="site.baseurl"/>logout"><fmt:message key="url.name.logout"/> </a>
            <br><fmt:message key="site.user.name"/>&nbsp;&nbsp;<c:out value="${authenticatedUserName}"/>(<c:out value="${authenticatedUserType}"/>)&nbsp;&nbsp;
        </div>
        <h1><fmt:message key="site.title"/></h1>

    </div>
    <div id="home_container">
        <h1><fmt:message key="addfood.title"/></h1>
        <div class="meal_list_container">
            <div id="breakfast_list">
                <h3 style="text-align: left; margin-left: 15px; margin-bottom: 15px;"><fmt:message key="addfood.form.title"/></h3>
                <form action="/newfood" method="POST">
                    <input type="text" name="food_name" placeholder="<fmt:message key="addfood.form.foodname" />" >
                    <input type="submit" value="<fmt:message key="addfood.form.submit"/>">
                </form>
            </div>

            <div id="lunch_list">
                <h3 style="text-align: left; margin-left: 15px; margin-bottom: 15px;"><fmt:message key="addfood.currentlist"/></h3>
                <ul>
                    <c:forEach var="food" items="${allFoodList}">
                        <li><c:out value="${food.foodName}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </div>

    </div>
    <div id="footer"><fmt:message key="footer.text"/></div>
</div>
</body>
</html>