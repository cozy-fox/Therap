<%--
  Created by IntelliJ IDEA.
  User: sanjoy.saha
  Date: 6/15/14
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
    <h1>Customers Page</h1>
    <c:out value="${customer.name}"/>
</body>
</html>
