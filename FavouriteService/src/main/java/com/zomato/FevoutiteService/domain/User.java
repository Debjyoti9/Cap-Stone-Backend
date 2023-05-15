package com.zomato.FevoutiteService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "favouriteCollection")
public class User {
    @Id
    private String email;
    private List<Shop> shopList;
    private List<Dish> dishList;

    public User(String email, List<Shop> shopList, List<Dish> dishList) {
        this.email = email;
        this.shopList = shopList;
        this.dishList = dishList;
    }

    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setCuisineList(List<Dish> dishList) {
        this.dishList = dishList;
    }
}
