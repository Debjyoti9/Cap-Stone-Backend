package com.bej.userauthenticationservice.service;


import com.bej.userauthenticationservice.domain.Merchant;
import com.bej.userauthenticationservice.exception.UserAlreadyExistsException;
import com.bej.userauthenticationservice.exception.InvalidCredentialsException;

public interface MerchantService {


    Merchant saveMerchant(Merchant merchant) throws UserAlreadyExistsException;
    //user name and pwd is in db ot not, if not save
    Merchant findByEmailAndPassword(String email,String password) throws InvalidCredentialsException;



}
