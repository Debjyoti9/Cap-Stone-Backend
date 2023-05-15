package com.zomato.FevoutiteService.domain;

public class Dish {

    private String dishName;
    private double price;
    private String category;

    private String description;
    private boolean isVeg;

    public Dish(String dishName, double price, String category, String description, boolean isVeg) {
        this.dishName = dishName;
        this.price = price;
        this.category = category;
        this.description = description;
        this.isVeg = isVeg;
    }

    public Dish(){}

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
