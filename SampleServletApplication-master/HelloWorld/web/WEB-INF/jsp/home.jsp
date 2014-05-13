<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="messages"/>
<html>
<head><title><fmt:message key="home.title"/></title></head>
<body>
<div>
    <h1 style="text-align:center;"><fmt:message key="home.title"/></h1>
    <table>
        <tr>
            <td>You are LoggedIn as :</td>
            <td><b>${authenticatedUser.userName}</b>.</td>
        </tr>
        <tr>
            <td>
                <a href="/helloWorld/logout.html">Logout</a>
            </td>
        </tr>
    </table>

</div>
</body>
</html>