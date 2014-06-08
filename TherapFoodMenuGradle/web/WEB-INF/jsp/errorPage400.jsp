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
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="previous.title"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="../../css/style.css"/>">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div id="links">
            <a href="<fmt:message key="site.baseurl"/>home"><fmt:message key="url.name.home"/></a>&nbsp;&nbsp;
        </div>
        <h1><fmt:message key="site.title"/></h1>

    </div>
    <div id="home_container">
        <div id="div404">
            <fmt:message key="site.error.text" />
        </div>
    </div>
    <div id="footer">
        <p><fmt:message key="footer.text"/></p>
    </div>
</div>
</body>
</html>