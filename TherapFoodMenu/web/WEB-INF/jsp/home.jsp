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
<fmt:setBundle basename="net.therap.properties.messages"/>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    You are logged in as <c:out value="${authenticatedUser.userName}"/>
    This is home.jsp
</body>
</html>