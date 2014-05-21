package net.therap.controller;

import net.therap.service.FoodService;
import net.therap.service.MealService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet{

    MealService mealService;
    FoodService foodService;

    public AdminController() {
        mealService = new MealService();
        foodService = new FoodService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("availableBreakfastList", foodService.getAvailableBreakfastListForToday());
        request.setAttribute("availableLunchList", foodService.getAvailableLunchListForToday());

        request.setAttribute("currentBreakfastList", foodService.getBreakfastListForToday());
        request.setAttribute("currentLunchList", foodService.getLunchListForToday());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_meal.jsp");
        requestDispatcher.forward(request, response);

    }
}
