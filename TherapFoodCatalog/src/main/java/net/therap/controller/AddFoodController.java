package net.therap.controller;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/25/14
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */

import net.therap.service.FoodService;
import net.therap.util.DateHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newfood")
public class AddFoodController extends HttpServlet {

    FoodService foodService;

    public AddFoodController() {
        foodService = new FoodService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodName = request.getParameter("food_name");
        foodService.addNewFood(foodName);
        response.sendRedirect("/newfood");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("allFoodList", foodService.getAllFoodList());
        request.setAttribute("authenticatedUserName", DateHelper.getAuthenticatedUserName(request.getSession()));
        request.setAttribute("authenticatedUserType", DateHelper.getAuthenticatedUserType(request.getSession()));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin_dashboard.jsp");
        requestDispatcher.forward(request, response);

    }
}

