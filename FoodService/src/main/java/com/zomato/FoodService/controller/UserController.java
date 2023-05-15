package com.zomato.FoodService.controller;

import com.zomato.FoodService.domain.Dish;
import com.zomato.FoodService.domain.User;
import com.zomato.FoodService.exception.DishAlreadyExistsException;
import com.zomato.FoodService.exception.UserAlreadyExistsException;
import com.zomato.FoodService.service.UserFoodService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v2")
public class UserController {

    @Autowired
    UserFoodService userFoodService;


    private ResponseEntity<?> responseEntity;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody User user) throws UserAlreadyExistsException{

        try {

            responseEntity = new ResponseEntity<>(userFoodService.register(user), HttpStatus.OK);
        }catch (UserAlreadyExistsException merchantAlreadyExistsException){
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }
    @GetMapping("/auth/user/details")
    public ResponseEntity<?> getUserDetails(HttpServletRequest request){
        System.out.println("header" + request.getHeader("Authorization"));
        Claims claims = (Claims) request.getAttribute("claims");
        System.out.println("email from claims :: " + claims.getSubject());
        String email = claims.getSubject();
        System.out.println("email :: "+email);

        return new ResponseEntity<>(userFoodService.getUserDetails(email),HttpStatus.OK);

    }

    @PostMapping("/auth/user/addToOrderList")
    public ResponseEntity<?> addToOrderList(@RequestBody Dish dish,HttpServletRequest request) throws DishAlreadyExistsException {

        try {
            System.out.println("header" + request.getHeader("Authorization"));
            Claims claims = (Claims) request.getAttribute("claims");
            System.out.println("email from claims :: " + claims.getSubject());
            String email = claims.getSubject();
            System.out.println("email :: "+email);

            responseEntity = new ResponseEntity<>(userFoodService.addToOrderList(email,dish),HttpStatus.OK);

            return responseEntity;
        }catch (DishAlreadyExistsException dishAlreadyExistsException){
            return new ResponseEntity<>("Dish already added",HttpStatus.OK);
        }

    }

    @GetMapping("/auth/user/dishes")
    public ResponseEntity<?> dishFromOrderList(HttpServletRequest request){

        System.out.println("header" + request.getHeader("Authorization"));
        Claims claims = (Claims) request.getAttribute("claims");
        System.out.println("email from claims :: " + claims.getSubject());
        String email = claims.getSubject();
        System.out.println("email :: "+email);

        responseEntity = new ResponseEntity<>(userFoodService.dishesFromOrderList(email),HttpStatus.OK);

        return responseEntity;
    }

    @DeleteMapping("/auth/user/deleteFromOrderList/{dishName}")
    public ResponseEntity<?> deleteFromOrderList(@PathVariable String dishName,HttpServletRequest request){

        System.out.println("header" + request.getHeader("Authorization"));
        Claims claims = (Claims) request.getAttribute("claims");
        System.out.println("email from claims :: " + claims.getSubject());
        String email = claims.getSubject();
        System.out.println("email :: "+email);

        return new ResponseEntity<>(userFoodService.deleteFromOrderList(email,dishName),HttpStatus.OK);


    }

    @DeleteMapping("/auth/user/deleteOrderList")
    public ResponseEntity<?> deleteAllItemsFromOrderList(HttpServletRequest request){
        System.out.println("header" + request.getHeader("Authorization"));
        Claims claims = (Claims) request.getAttribute("claims");
        System.out.println("email from claims :: " + claims.getSubject());
        String email = claims.getSubject();
        System.out.println("email :: "+email);

        return new ResponseEntity<>(userFoodService.deleteAllItemsFromOrderList(email),HttpStatus.OK);
    }
}
