package net.therap.controller;

import net.therap.domain.Food;
import net.therap.service.FoodService;
import net.therap.service.MealService;
import net.therap.util.DateHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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

        List<Food> currentBreakfastList = foodService.getBreakfastListForToday();
        List<Food> currentLunchList = foodService.getLunchListForToday();

        Food emptyFood = new Food();
        emptyFood.setFoodName("Not Added Yet");
        if (currentBreakfastList.size() < 1) currentBreakfastList.add(emptyFood);
        if (currentLunchList.size() < 1) currentLunchList.add(emptyFood);

        request.setAttribute("currentBreakfastList", currentBreakfastList);
        request.setAttribute("currentLunchList", currentLunchList);

        request.setAttribute("todaysDay", DateHelper.getDayNameFromDate(new Date()));
        request.setAttribute("todaysDate", DateHelper.getTodaysDateOnly());


        request.setAttribute("authenticatedUserName", DateHelper.getAuthenticatedUserName(request.getSession()));
        request.setAttribute("authenticatedUserType", DateHelper.getAuthenticatedUserType(request.getSession()));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_meal.jsp");
        requestDispatcher.forward(request, response);

    }
}
