package com.bej.userauthenticationservice.controller;


import com.bej.userauthenticationservice.domain.Merchant;
import com.bej.userauthenticationservice.exception.InvalidCredentialsException;
import com.bej.userauthenticationservice.exception.UserAlreadyExistsException;


import com.bej.userauthenticationservice.security.SecurityTokenGeneratorMerchant;
import com.bej.userauthenticationservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v4")
public class MerchantAuthController {
    private MerchantService merchantService;
    private SecurityTokenGeneratorMerchant securityTokenGeneratorMerchant;

    @Autowired
    public MerchantAuthController(MerchantService merchantService, SecurityTokenGeneratorMerchant securityTokenGeneratorMerchant) {
        this.merchantService = merchantService;
        this.securityTokenGeneratorMerchant = securityTokenGeneratorMerchant;
    }

    @PostMapping("/merchant")
    public ResponseEntity<?> saveMerchant(@RequestBody Merchant merchant) throws UserAlreadyExistsException {
        return new ResponseEntity<>(merchantService.saveMerchant(merchant),HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginMerchant(@RequestBody Merchant merchant) throws InvalidCredentialsException
    {
        Map<String,String> token = new HashMap<>();

        Merchant retrievedMerchant = merchantService.findByEmailAndPassword(merchant.getEmail(),merchant.getPassword());
        if(retrievedMerchant==null)
        {
            token.put("message", "Login Unsuccessful");
            token.put("emailId", merchant.getEmail());
            return new ResponseEntity<>(token,HttpStatus.OK);
        }
        token = securityTokenGeneratorMerchant.createToken(merchant);
        return new ResponseEntity<>(token,HttpStatus.OK);
    }
}
