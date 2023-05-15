package com.zomato.FoodService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND, reason = "Dish already Found")
public class DishAlreadyExistsException extends Exception{
}
