package com.zomato.MerchantService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Shop not available")
public class ShopNotFoundException extends Exception{

}
