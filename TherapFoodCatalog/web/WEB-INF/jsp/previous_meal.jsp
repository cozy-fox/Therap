<%--
  Created by IntelliJ IDEA.
  User: sanjoy.saha
  Date: 5/22/14
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:setBundle basename="net.therap.properties.messages"/>
<html>
<head>
    <title><fmt:message key="previous.title"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="../../css/style.css"/>">
</head>
<body>
    <div id="wrapper">
        <div id="header">
        <div id="links">
            <a href="<fmt:message key="site.baseurl"/>admin"><fmt:message key="url.name.admin"/></a>&nbsp;&nbsp;
            <a href="<fmt:message key="site.baseurl"/>newfood"><fmt:message key="url.name.addfood"/> </a>&nbsp;&nbsp;
            <a href="<fmt:message key="site.baseurl"/>logout"><fmt:message key="url.name.logout"/></a>
            <br><fmt:message key="site.user.name"/>&nbsp;&nbsp;<c:out value="${authenticatedUserName}"/>(<c:out value="${authenticatedUserType}"/>)&nbsp;&nbsp;
        </div>
        <h1><fmt:message key="site.title"/></h1>

    </div>
    <div id="home_container">
            <h1><fmt:message key="previous.title"/></h1>
            <table id="previous_table">
                <colgroup>
                    <col id="dateCol" style="text-align: center;">
                    <col id="dayCol" style="text-align: center;">
                    <col class="mealListCol">
                    <col class="mealListCol">
                </colgroup>
                <tr>
                    <th><fmt:message key="previous.date"/></th>
                    <th><fmt:message key="previous.day"/></th>
                    <th><fmt:message key="previous.breakfast"/></th>
                    <th><fmt:message key="previous.lunch"/></th>
                </tr>
            <c:forEach var="mealRow" items="${mealRowMap}">
                <tr>
                    <c:set var="breakfastStr" value="${mealRow.value.breakfastString}"/>
                    <c:set var="lunchStr" value="${mealRow.value.lunchString}"/>
                    <c:set var="breakfastLength" value="${fn:length(breakfastStr)}"/>
                    <c:set var="lunchLength" value="${fn:length(lunchStr)}"/>

                    <td><c:out value="${mealRow.key}"/></td>
                    <td><c:out value="${mealRow.value.day}"/></td>
                    <td><c:out value="${fn:substring(breakfastStr, 2, breakfastLength)}"/></td>
                    <td><c:out value="${fn:substring(lunchStr, 2, lunchLength)}"/></td>
                </tr>
            </c:forEach>
            </table>
        </div>
    <div id="footer">
        <p><fmt:message key="footer.text"/></p>
    </div>
    </div>
</body>
</html>