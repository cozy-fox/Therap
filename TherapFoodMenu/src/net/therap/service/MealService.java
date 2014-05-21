package net.therap.service;

import net.therap.dao.FoodListDao;
import net.therap.dao.MealListDao;
import net.therap.domain.Food;
import net.therap.domain.Meal;
import net.therap.util.HelperClass;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class MealService {

    private FoodListDao foodListDao;
    private MealListDao mealListDao;

    public MealService() {
        foodListDao = new FoodListDao();
        mealListDao = new MealListDao();
    }

    public List<Food> getFoodListForToday() {
        String todaysDate = HelperClass.getTodaysDateOnly();
        //return foodListDao.getAvailableFoodsListForDate();
        return null;
    }

    public void addTodaysMeal(String mealType, long[] foodsToAdd, long userId) {

        String todaysDate = HelperClass.getTodaysDateOnly();
        Meal mealOfToday = mealListDao.getMealOfADay(mealType, todaysDate);
        mealListDao.addMealOfADay(mealType, todaysDate, foodsToAdd, userId);
/*
        if ( mealOfToday.getFoodIdList().length > 0 ) {
            // meal already exists for today
            System.out.println("meal already exists: MealService");
            return false;
        } else {


            System.out.println("meal dont exists: MealService");
            return true;
            // meal has not been added yet
            // so, add meal now
        }*/

    }


}
