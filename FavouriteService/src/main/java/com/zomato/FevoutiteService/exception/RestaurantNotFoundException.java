package com.zomato.FevoutiteService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Sorry !! The restaurant doesn't exists.")
public class RestaurantNotFoundException extends Exception {
}
