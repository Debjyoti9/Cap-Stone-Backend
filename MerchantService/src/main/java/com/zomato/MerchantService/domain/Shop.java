package com.zomato.MerchantService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "All Shops")
public class Shop {

    @Id
    private String shopName;
    private String area;
    private String state;

    private int zipcode;
    private float rating;
    private String bestFood;
    private List<Dish> menu;

    public Shop() {
    }

    public Shop(String shopName, String state, String area, int zipcode, int rating, String bestFood, List<Dish> menu) {
        this.shopName = shopName;
        this.state = state;
        this.area = area;
        this.zipcode = zipcode;
        this.rating = rating;
        this.bestFood = bestFood;
        this.menu = menu;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
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
