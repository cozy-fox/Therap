package net.therap.service;

import net.therap.dao.FoodListDao;
import net.therap.domain.Food;
import net.therap.util.DateHelper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodService {

    private FoodListDao foodListDao;

    public FoodService() {
        foodListDao = new FoodListDao();
    }
    public List<Food> getAvailableBreakfastListForToday() {
        String todaysDate = DateHelper.getTodaysDateOnly();
        return foodListDao.getAvailableFoodsListForDate("breakfast", todaysDate);
    }

    public List<Food> getAvailableLunchListForToday() {
        String todaysDate = DateHelper.getTodaysDateOnly();
        return foodListDao.getAvailableFoodsListForDate("lunch", todaysDate);
    }

    public List<Food> getBreakfastListForToday() {
        String todaysDate = DateHelper.getTodaysDateOnly();
        return foodListDao.getFoodsListForDate("breakfast", todaysDate);

    }

    public List<Food> getLunchListForToday() {
        String todaysDate = DateHelper.getTodaysDateOnly();
        return foodListDao.getFoodsListForDate("lunch", todaysDate);
    }

    public List<Food> getAllFoodList() {
        return foodListDao.getAllFoodList();
    }

    public void addNewFood(String foodName) {
        foodListDao.addNewFoodToFoodList(foodName);
    }
}
