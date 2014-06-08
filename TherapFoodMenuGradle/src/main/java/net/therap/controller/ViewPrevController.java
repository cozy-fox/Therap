package net.therap.controller;

import net.therap.service.MealService;
import net.therap.util.DateHelper;

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
 * Date: 5/22/14
 * Time: 9:16 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/prev")
public class ViewPrevController extends HttpServlet {

    MealService mealService;

    public ViewPrevController() {
        mealService = new MealService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("mealRowMap", mealService.getMealRowMapForLastMonth());

        request.setAttribute("authenticatedUserName", DateHelper.getAuthenticatedUserName(request.getSession()));
        request.setAttribute("authenticatedUserType", DateHelper.getAuthenticatedUserType(request.getSession()));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/previous_meal.jsp");
        requestDispatcher.forward(request, response);

    }
}
