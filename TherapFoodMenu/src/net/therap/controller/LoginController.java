package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/20/14
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginController extends HttpServlet {

    UserService userService;

    public LoginController() {
        userService = new UserService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//        requestDispatcher.forward(request, response);
        List<User> userList = userService.getAllUsers();
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        out.print("<html><body><h2>Employee Details</h2>");
        out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
        out.print("<th>ID</th>");
        out.print("<th>Name</th>");
        out.print("<th>Type</th>");

        Iterator<User> iteratorUser = userList.iterator();
        while(iteratorUser.hasNext())
        {
            User tmpUser = iteratorUser.next();
            out.print("<tr>");
            out.print("<td>" + tmpUser.getUserId() + "</td>");
            out.print("<td>" + tmpUser.getUserName() + "</td>");
            out.print("<td>" + tmpUser.getUserType() + "</td>");
            out.print("</tr>");
        }
        out.print("</table></body><br/>");

    }
}
