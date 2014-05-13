package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.UserService;
import net.therap.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
@WebServlet("/register.html")
public class RegistrationController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    private UserService userService;

     public RegistrationController(){
         userService = new UserServiceImpl();
     }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User registeringUser = new User();
        registeringUser.setUserName(request.getParameter("userName"));
        registeringUser.setPassword(request.getParameter("password"));

        userService.saveUser(registeringUser);

        response.sendRedirect("/helloWorld/login.html");
    }
}
