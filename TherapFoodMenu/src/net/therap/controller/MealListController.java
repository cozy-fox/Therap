package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.MealService;
import net.therap.util.HelperClass;

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
public class MealListController extends HttpServlet{
    MealService mealService;

    public MealListController() {
        mealService = new MealService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mealType = request.getParameter("meal_type");
        String[] foodsToAddString = request.getParameterValues("foods");
        long[] foodsToAdd = HelperClass.convertStringArraytoLong(foodsToAddString);

        HttpSession session = request.getSession();
        User authenticatedUser = (User)session.getAttribute("authenticatedUser");
        long userId = authenticatedUser.getUserId();

        mealService.addTodaysMeal(mealType, foodsToAdd, userId);
        /*if (!mealService.addTodaysMeal(mealType, foodsToAdd, userId)) {
            // meal already exists
            // mealService.editTodaysMeal(mealType, foodsToAdd)
            System.out.println("meal already exists: MealListController");

        } else {
            // show success msg
            // redirect to add page
            System.out.println("meal doesnt exist: MealListController");
        }*/
        response.sendRedirect("/admin");


    }
}
