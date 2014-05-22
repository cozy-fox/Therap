<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: sanjoy.saha
  Date: 5/20/14
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="net.therap.properties.messages"/>

<html>
<head>
    <title><fmt:message key="login.title"/></title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1><fmt:message key="site.title"/></h1>
    </div>
    <div class="login">
        <h1><fmt:message key="login.title"/></h1>
        <form action="/login" method="POST">
            <p><input type="text" name="user_name" placeholder="<fmt:message key="login.userName"/>"></p>
            <p><input type="password" name="user_password" placeholder="<fmt:message key="login.userPass"/>"></p>
            <input type="submit" value="<fmt:message key="login.submit"/>">
        </form>
    </div>

    <div id="footer">
        <p>A Footer! Just to make it look complete...</p>
    </div>
</div>
</body>
</html>