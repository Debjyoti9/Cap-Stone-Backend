package com.zomato.MerchantService.controller;

import com.zomato.MerchantService.domain.Merchant;
import com.zomato.MerchantService.domain.Shop;
import com.zomato.MerchantService.exception.MerchantAlreadyExistsException;
import com.zomato.MerchantService.exception.ShopAlreadyExistsException;
import com.zomato.MerchantService.exception.ShopNotFoundException;
import com.zomato.MerchantService.service.IMerchantService;
import com.zomato.MerchantService.service.MerchantService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1")
public class MerchantController {
    @Autowired
    private IMerchantService merchantService;

    private ResponseEntity<?> responseEntity;

    @PostMapping("/register")
    public ResponseEntity<?> registerMerchant(@RequestBody Merchant merchant) throws MerchantAlreadyExistsException{

        try {
            responseEntity = new ResponseEntity<>(merchantService.register(merchant), HttpStatus.OK);
        }catch (MerchantAlreadyExistsException merchantAlreadyExistsException){
            throw new MerchantAlreadyExistsException();
        }
        return responseEntity;
    }

    @GetMapping("/auth/merchant/shops")
    public ResponseEntity<?> getShops(HttpServletRequest request) throws ShopNotFoundException{

        try {
            System.out.println("header" + request.getHeader("Authorization"));
            Claims claims = (Claims) request.getAttribute("claims");
            System.out.println("email from claims :: " + claims.getSubject());
            String email = claims.getSubject();
            System.out.println("email :: "+email);

            responseEntity = new ResponseEntity<>(merchantService.getAllShopsOfMerchant(email),HttpStatus.OK);
        }catch (ShopNotFoundException shopNotFoundException){
           throw new ShopNotFoundException();
        }
        return responseEntity;
    }

    @GetMapping("/auth/merchant/profile")
    public ResponseEntity<?> getMerchant(HttpServletRequest request){

        System.out.println("header" + request.getHeader("Authorization"));
        Claims claims = (Claims) request.getAttribute("claims");
        System.out.println("email from claims :: " + claims.getSubject());
        String email = claims.getSubject();
        System.out.println("email :: "+email);

        return new ResponseEntity<>(merchantService.getMerchant(email),HttpStatus.OK);
    }

    @GetMapping("/shops")
    public ResponseEntity<?> getAllShops() throws ShopNotFoundException{

        try {
            responseEntity = new ResponseEntity<>(merchantService.allShops(),HttpStatus.OK);
        }catch(ShopNotFoundException shopNotFoundException){
            throw new ShopNotFoundException();
        }
        return responseEntity;
    }

    @GetMapping("/shops/{shopName}")
    public ResponseEntity<?> getSingleShopFromAllShops(@PathVariable String shopName){
        return new ResponseEntity<>(merchantService.getSingleShopFromAllShops(shopName),HttpStatus.OK);
    }

    @PostMapping("/auth/merchant/addShop")
    public ResponseEntity<?> addShop(@RequestBody Shop shop, HttpServletRequest request) throws ShopAlreadyExistsException {

        try {
            System.out.println("header" + request.getHeader("Authorization"));
            Claims claims = (Claims) request.getAttribute("claims");
            System.out.println("email from claims :: " + claims.getSubject());
            String email = claims.getSubject();
            System.out.println("email :: "+email);

            responseEntity = new ResponseEntity<>(merchantService.addShop(email,shop),HttpStatus.OK);
        }catch (ShopAlreadyExistsException shopAlreadyExistsException){
            return new ResponseEntity<>("Shop already added",HttpStatus.OK);
        }


        return responseEntity;
    }

    @DeleteMapping("/auth/merchant/deleteShop/{shopName}")
    public ResponseEntity<?> deleteShop(@PathVariable String shopName, HttpServletRequest request){
        Claims claims = (Claims) request.getAttribute("claims");
        System.out.println("email from claims :: " + claims.getSubject());
        String email = claims.getSubject();
        System.out.println("email :: "+email);

        responseEntity = new ResponseEntity<>(merchantService.deleteShop(email,shopName),HttpStatus.OK);
        return responseEntity;
    }


}
