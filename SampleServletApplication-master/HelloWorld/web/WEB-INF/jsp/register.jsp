<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="messages"/>
<html>
<head><title><fmt:message key="register.title"/></title></head>
<body>
<div>
    <h1 style="text-align:center;"><fmt:message key="register.title"/></h1>

    <form action="/helloWorld/register.html" method="post">
        <fieldset style="width:340px;margin-left:450;">
            <table>
                <tr>
                    <td><fmt:message key="register.userName"/></td>
                    <td><input type="text" name="userName"/></td>
                </tr>
                <tr>
                    <td><fmt:message key="register.password"/></td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="<fmt:message key="register.submit"/>"/></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</body>
</html>