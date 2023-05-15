package com.zomato.FoodService.domain;

public class Dish {

    private String dishName;
    private int price;
    private String category;
    private String description;
    private int quantity;
    private boolean isVeg;

    public Dish() {
    }

    public Dish(String dishName, int price, String category, String description, int quantity, boolean isVeg) {
        this.dishName = dishName;
        this.price = price;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
        this.isVeg = isVeg;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", isVeg=" + isVeg +
                '}';
    }
}
