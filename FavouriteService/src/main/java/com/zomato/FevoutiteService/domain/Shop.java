package com.zomato.FevoutiteService.domain;

import java.util.List;

public class Shop {
    private String shopName;
    private String area;

    private int zipcode;
    private String state;
    private float rating;
    private String bestFood;
    private List<Dish> menu;

    public Shop(String shopName, String area, int zipcode, String state, float rating, String bestFood, List<Dish> menu) {
        this.shopName = shopName;
        this.area = area;
        this.zipcode = zipcode;
        this.state = state;
        this.rating = rating;
        this.bestFood = bestFood;
        this.menu = menu;
    }

    public Shop(){}

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getBestFood() {
        return bestFood;
    }

    public void setBestFood(String bestFood) {
        this.bestFood = bestFood;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }
}
