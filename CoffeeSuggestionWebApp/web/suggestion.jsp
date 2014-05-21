<%@page import="java.util.*" %>

<html>
    <head>
        <title>Coffee Suggestions</title>
    </head>

    <body style="text-align: center">
        <h1>Coffee Suggestions</h1>
        <table>
        <%
            List coffeeNames = (List)request.getAttribute("coffee_list");
            Iterator iterator = coffeeNames.iterator();

            while(iterator.hasNext()) {
                out.println("<tr><td>"+iterator.next()+"</td></tr>");
            }
        %>
        </table>
    </body>
</html>