<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="messages"/>
<html>
<head><title><fmt:message key="login.title"/></title></head>
<body>
<div>
    <h1 style="text-align:center;"><fmt:message key="login.title"/></h1>

    <div style="margin-left:450;">
        <form action="/helloWorld/login.html" method="post">

            <fieldset style="width:340px;">
                <table>
                    <tr>
                        <td><fmt:message key="login.userName"/></td>
                        <td><input type="text" name="userName"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="login.password"/></td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="<fmt:message key="login.submit"/>"/></td>
                    </tr>
                </table>
            </fieldset>
        </form>
        Not yet Registered? <a href="/helloWorld/register.html">Register Here</a>!
    </div>
</div>

</body>
</html>