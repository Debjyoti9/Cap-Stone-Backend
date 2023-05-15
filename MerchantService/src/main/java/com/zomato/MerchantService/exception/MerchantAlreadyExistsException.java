package com.zomato.MerchantService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND, reason = "Merchant Already Exists")
public class MerchantAlreadyExistsException extends Exception{
}
