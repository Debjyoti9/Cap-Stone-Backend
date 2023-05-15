package com.zomato.FevoutiteService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND,reason = "Sorry !! The cuisine already exists.")
public class CuisineAlreadyExistsException extends Exception{
}
