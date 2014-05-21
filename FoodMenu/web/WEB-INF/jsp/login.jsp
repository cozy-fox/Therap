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
<fmt:setBundle basename="properties.messages"/>

<html>
<head>
    <title><fmt:message key="login.title"/></title>
</head>
<body>
    <h1><fmt:message key="login.title"/></h1>
    <input type="text" name="user_name" placeholder="User Name">
    <input type="password" name="user_password" placeholder="Password">
    <input type="submit" value="<fmt:message key="login.submit"/>">
</body>
</html>