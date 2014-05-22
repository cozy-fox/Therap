package net.therap.dao;

import net.therap.domain.Meal;
import net.therap.domain.MealCompact;
import net.therap.domain.MealRow;
import net.therap.util.DatabaseTemplate;
import net.therap.util.HelperClass;
import net.therap.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 12:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class MealListDao {

    public Meal getMealOfADay(String mealType, String dateToFind) {

        List<MealRow> mealRowList = new DatabaseTemplate().queryForObject("SELECT * FROM meal_list_tmp WHERE day_added = '" + dateToFind + "' and m_type = '" + mealType + "'",
                new ObjectRowMapper<MealRow>() {
                    public MealRow mapRowToObject(ResultSet resultSet) throws SQLException {
                        MealRow mealRow = new MealRow();
                        mealRow.setMealId(resultSet.getInt("id"));
                        mealRow.setMealType(resultSet.getString("m_type"));
                        mealRow.setUserId(resultSet.getInt("u_id"));
                        mealRow.setFoodId(resultSet.getInt("f_id"));
                        return mealRow;
                    }
                });

        Meal meal = makeMealObjectFromMealRowList(mealRowList);
        return meal;
    }

    private Meal makeMealObjectFromMealRowList(List<MealRow> mealRowList) {

        Meal meal = new Meal();
        long[] foodListForMeal = new long[mealRowList.size()];

        Iterator<MealRow> mealRowIterator = mealRowList.iterator();
        int i = 0;
        while (mealRowIterator.hasNext()) {
            foodListForMeal[i++] = mealRowIterator.next().getFoodId();
        }

        meal.setFoodIdList(foodListForMeal);
        if (mealRowList.size() > 0) {
            meal.setUserId(mealRowList.get(0).getUserId());
            meal.setMealType(mealRowList.get(0).getMealType());
            meal.setMealId(mealRowList.get(0).getMealId());
            meal.setAddedDate(mealRowList.get(0).getAddedDate());
        }

        return meal;
    }

    public void addMealOfADay(String mealType, String dateToAdd, long[] foodsToAdd, long userId) {
        for (int i = 0; i < foodsToAdd.length; i++) {
            new DatabaseTemplate().executeInsertQuery("INSERT INTO meal_list_tmp(id,f_id,m_type,u_id,day_added) VALUES(?,?,?,?,?)", 0, foodsToAdd[i], mealType, userId, dateToAdd);
        }
    }

    public Map<String, MealCompact> getBothMealListOfLastMonth() {

        List<MealRow> mealRowList = new DatabaseTemplate().queryForObject("SELECT f_id, m_type, day_added, f_name FROM meal_list_tmp, food_list WHERE meal_list_tmp.f_id=food_list.id AND day_added BETWEEN CURDATE() - INTERVAL 30 DAY AND CURDATE() ",
                new ObjectRowMapper<MealRow>() {
                    public MealRow mapRowToObject(ResultSet resultSet) throws SQLException {
                        MealRow mealRow = new MealRow();
                        mealRow.setMealType(resultSet.getString("m_type"));
                        mealRow.setFoodName(resultSet.getString("f_name"));
                        mealRow.setAddedDate(resultSet.getString("day_added"));
                        return mealRow;
                    }
                });

        Map<String, MealCompact> retMap = makeCompactMealRowFromMealRowList(mealRowList);
        return retMap;
    }

    private Map<String, MealCompact> makeCompactMealRowFromMealRowList(List<MealRow> mealRowList) {
        Iterator<MealRow> mealRowIterator = mealRowList.iterator();
        Map<String, MealCompact> mapByDate = new TreeMap<String, MealCompact>();

        while (mealRowIterator.hasNext()) {
            MealRow mealRow = mealRowIterator.next();
            String addedDate = mealRow.getAddedDate();
            String mealType = mealRow.getMealType();
            String foodName = mealRow.getFoodName();

            MealCompact currentEntry = mapByDate.get(addedDate);

            String dayString = HelperClass.getDayNameFromDateString(addedDate);

            if (mealType.equals("breakfast")) {
                String currentString = "";
                if (currentEntry != null)
                    currentString = currentEntry.getBreakfastString();
                if (currentString == null) currentString = "";
                currentString = currentString +", "+foodName;

                if (currentEntry == null)
                    currentEntry = new MealCompact();

                currentEntry.setBreakfastString(currentString);
                currentEntry.setDay(dayString);
                mapByDate.put(addedDate, currentEntry);

            } else if (mealType.equals("lunch")) {

                String currentString = "";
                if (currentEntry != null)
                    currentString = currentEntry.getLunchString();
                if (currentString == null) currentString = "";
                currentString = currentString +", "+foodName;

                if (currentEntry == null)
                    currentEntry = new MealCompact();

                currentEntry.setLunchString(currentString);
                currentEntry.setDay(dayString);
                mapByDate.put(addedDate, currentEntry);
            }
        }

        return mapByDate;
    }
}
