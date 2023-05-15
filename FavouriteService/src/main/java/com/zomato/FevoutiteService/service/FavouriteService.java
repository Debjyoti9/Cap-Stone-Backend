package com.zomato.FevoutiteService.service;

import com.zomato.FevoutiteService.domain.Dish;
import com.zomato.FevoutiteService.domain.Shop;
import com.zomato.FevoutiteService.domain.User;
import com.zomato.FevoutiteService.exception.*;

import java.util.List;


public interface FavouriteService {
    User saveUserData(User user);
    User getUser(String email) throws UserNotFoundException;
    List<Shop> getShops(String email);
    List<Dish> getDishes(String email);
    List<Shop> addShopToUser(String email, Shop shop) throws RestaurantAlreadyExistsException, UserNotFoundException;
    List<Dish> addDishToUser(String email, Dish dish) throws CuisineAlreadyExistsException, UserNotFoundException;
    List<Shop> deleteShopFromUser(String email, String shopName) throws RestaurantNotFoundException, UserNotFoundException;
    List<Dish> deleteDishFromUser(String email, String dishName) throws CuisineNotFoundException, UserNotFoundException;
    User deleteUser(String email) throws UserNotFoundException;
}
