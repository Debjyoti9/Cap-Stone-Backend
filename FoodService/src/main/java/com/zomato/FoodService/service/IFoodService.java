package com.zomato.FoodService.service;

import com.zomato.FoodService.domain.Dish;
import com.zomato.FoodService.domain.User;
import com.zomato.FoodService.exception.DishAlreadyExistsException;
import com.zomato.FoodService.exception.DishNotFoundException;
import com.zomato.FoodService.exception.UserAlreadyExistsException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFoodService {

    User getUserDetails(String email);

    List<Dish> dishesFromOrderList(String email);
    User register(User user) throws UserAlreadyExistsException;
    List<Dish> addToOrderList(String email,Dish dish) throws DishAlreadyExistsException;
    List<Dish> deleteFromOrderList(String email,String dishName);
    User deleteAllItemsFromOrderList(String email);


}
