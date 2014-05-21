package net.therap.dao;

import net.therap.domain.Food;
import net.therap.util.DatabaseTemplate;
import net.therap.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodListDao {

    public List<Food> getAvailableFoodsListForDate(String mealType, String dateToFind) {

        String queryString;
        if (mealType!=null)
            queryString = "SELECT * FROM food_list WHERE id NOT IN ( SELECT f_id FROM meal_list_tmp WHERE m_type='"+mealType+"' AND day_added='"+dateToFind+"')";
        else queryString = "SELECT * FROM food_list WHERE id NOT IN ( SELECT f_id FROM meal_list_tmp WHERE AND day_added='"+dateToFind+"')";

        List<Food> foodList = new DatabaseTemplate().queryForObject(queryString,
                new ObjectRowMapper<Food>() {
                    public Food mapRowToObject(ResultSet resultSet) throws SQLException {
                        Food food = new Food();
                        food.setFoodId(resultSet.getInt("id"));
                        food.setFoodName(resultSet.getString("f_name"));

                        return food;
                    }
                });
        return foodList;
    }

    public List<Food> getFoodsListForDate(String mealType, String dateToFind) {

        String queryString;
        if (mealType!=null)
            queryString = "SELECT * FROM food_list WHERE id IN ( SELECT f_id FROM meal_list_tmp WHERE m_type='"+mealType+"' AND day_added='"+dateToFind+"')";
        else queryString = "SELECT * FROM food_list WHERE id IN ( SELECT f_id FROM meal_list_tmp WHERE AND day_added='"+dateToFind+"')";

        List<Food> foodList = new DatabaseTemplate().queryForObject(queryString,
                new ObjectRowMapper<Food>() {
                    public Food mapRowToObject(ResultSet resultSet) throws SQLException {
                        Food food = new Food();
                        food.setFoodId(resultSet.getInt("id"));
                        food.setFoodName(resultSet.getString("f_name"));

                        return food;
                    }
                });
        return foodList;
    }
}
