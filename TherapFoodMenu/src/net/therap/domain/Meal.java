package net.therap.domain;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/21/14
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Meal{
    private long mealId;
    private String mealType;
    private long userId;
    private long[] foodIdList;
    private String addedDate;

    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long[] getFoodIdList() {
        return foodIdList;
    }

    public void setFoodIdList(long[] foodIdList) {
        this.foodIdList = foodIdList;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }
}
