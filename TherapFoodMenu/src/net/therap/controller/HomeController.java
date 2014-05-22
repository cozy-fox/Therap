package net.therap.controller;

import net.therap.domain.Food;
import net.therap.domain.User;
import net.therap.service.FoodService;
import net.therap.service.MealService;
import net.therap.util.HelperClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/home/*")
public class HomeController extends HttpServlet {

    MealService mealService;
    FoodService foodService;

    public HomeController() {
        mealService = new MealService();
        foodService = new FoodService();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        User authenticatedUser = (User) httpSession.getAttribute("authenticatedUser");
        String userType = authenticatedUser.getUserType();

        if (userType.equals("admin")) {

            response.sendRedirect("/admin");

        } else if (userType.equals("regular")) {
            List<Food> breakfastList = foodService.getBreakfastListForToday();
            List<Food> lunchList = foodService.getLunchListForToday();

            Food emptyFood = new Food();
            emptyFood.setFoodName("No Food Added Yet");

            if (breakfastList.size() < 1) breakfastList.add(emptyFood);
            if (lunchList.size() < 1) lunchList.add(emptyFood);

            request.setAttribute("currentBreakfastList", breakfastList);
            request.setAttribute("currentLunchList", lunchList);

            request.setAttribute("todaysDay", HelperClass.getDayNameFromDate(new Date()));
            request.setAttribute("todaysDate", HelperClass.getTodaysDateOnly());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            requestDispatcher.forward(request, response);
        }


    }
}
