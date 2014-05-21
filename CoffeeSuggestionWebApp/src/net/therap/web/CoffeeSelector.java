package net.therap.web;

import net.therap.model.CoffeeExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/19/14
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoffeeSelector extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        String coffeeColor = req.getParameter("color_of_coffee");

//        PrintWriter out = response.getWriter();
//        out.println("Coffee Selection Suggestion<br>");

        List suggestedCoffeeList = CoffeeExpert.getBrands(coffeeColor);
        req.setAttribute("coffee_list", suggestedCoffeeList);
        RequestDispatcher viewFile = req.getRequestDispatcher("suggestion.jsp");
        viewFile.forward(req,response);

//        List suggestedCoffeeList = CoffeeExpert.getBrands(coffeeColor);
//        Iterator it = suggestedCoffeeList.iterator();
//        while(it.hasNext()) {
//            out.println("Suggested: "+ it.next().toString());
//        }
    }
}
