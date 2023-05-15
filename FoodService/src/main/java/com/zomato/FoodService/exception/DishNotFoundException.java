package com.zomato.FoodService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Dish Not Found")
public class DishNotFoundException extends Exception{
}
