package com.zomato.MerchantService.domain;

public class Dish {

    private String dishName;
    private String price;
    private String category;
    private String description;
    private boolean isVeg;

    public Dish() {
    }

    public Dish(String dishName, String price, String category, String description, boolean isVeg) {
        this.dishName = dishName;
        this.price = price;
        this.category = category;
        this.description = description;
        this.isVeg = isVeg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public void setVeg(boolean veg) {
        isVeg = veg;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishName='" + dishName + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", isVeg=" + isVeg +
                '}';
    }
}
