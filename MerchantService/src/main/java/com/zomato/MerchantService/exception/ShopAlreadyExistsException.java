package com.zomato.MerchantService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND,reason = "shop already exists")
public class ShopAlreadyExistsException extends Exception{
}
