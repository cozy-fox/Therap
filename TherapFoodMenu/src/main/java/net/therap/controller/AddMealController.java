package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.MealService;
import net.therap.util.DateHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/mealAdd")
public class AddMealController extends HttpServlet{
    MealService mealService;

    public AddMealController() {
        mealService = new MealService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mealType = request.getParameter("meal_type");
        String[] foodsToAddString = request.getParameterValues("foods");
        long[] foodsToAdd = DateHelper.convertStringArraytoLong(foodsToAddString);

        HttpSession session = request.getSession();
        User authenticatedUser = (User)session.getAttribute("authenticatedUser");
        long userId = authenticatedUser.getUserId();

        mealService.addTodaysMeal(mealType, foodsToAdd, userId);

        response.sendRedirect("admin");


    }
}
