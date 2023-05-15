package com.zomato.FevoutiteService.controller;


import com.zomato.FevoutiteService.domain.Dish;
import com.zomato.FevoutiteService.domain.Shop;
import com.zomato.FevoutiteService.domain.User;
import com.zomato.FevoutiteService.exception.*;
import com.zomato.FevoutiteService.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import io.jsonwebtoken.Claims;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v5")
public class FavouriteServiceController {
    private FavouriteService favouriteService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public FavouriteServiceController(FavouriteService favouriteService){
        this.favouriteService = favouriteService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUserFavourite(@RequestBody User user){
        return new ResponseEntity<>(this.favouriteService.saveUserData(user), HttpStatus.OK);
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUser(HttpServletRequest httpServletRequest) throws UserNotFoundException {
        try {
            System.out.println("Header" + httpServletRequest.getHeader("Authorization"));
            Claims claims = (Claims) httpServletRequest.getAttribute("claims");
            String email = claims.getSubject();
            System.out.println("Email :: " + email);
            return new ResponseEntity<>(this.favouriteService.getUser(email), HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
    }

    @PostMapping("/favourite/addShop")
    public ResponseEntity<?> addRestaurant(@RequestBody Shop shop, HttpServletRequest httpServletRequest) throws UserNotFoundException, RestaurantAlreadyExistsException {
        try {
            System.out.println("Header" + httpServletRequest.getHeader("Authorization"));
            Claims claims = (Claims) httpServletRequest.getAttribute("claims");
            String email = claims.getSubject();
            System.out.println("Email :: " + email);
            return new ResponseEntity<>(this.favouriteService.addShopToUser(email, shop), HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (RestaurantAlreadyExistsException e) {
            return new ResponseEntity<>("Restaurant already added",HttpStatus.OK);
        }
    }

    @GetMapping("/favourite/shops")
    public ResponseEntity<?> getShops(HttpServletRequest httpServletRequest){
        System.out.println("Header" + httpServletRequest.getHeader("Authorization"));
        Claims claims = (Claims) httpServletRequest.getAttribute("claims");
        String email = claims.getSubject();
        System.out.println("Email :: " + email);

        return new ResponseEntity<>(favouriteService.getShops(email),HttpStatus.OK);
    }
    @GetMapping("/favourite/dishes")
    public ResponseEntity<?> getDishes(HttpServletRequest httpServletRequest){
        System.out.println("Header" + httpServletRequest.getHeader("Authorization"));
        Claims claims = (Claims) httpServletRequest.getAttribute("claims");
        String email = claims.getSubject();
        System.out.println("Email :: " + email);

        return new ResponseEntity<>(favouriteService.getDishes(email),HttpStatus.OK);
    }

    @PostMapping("/favourite/addDish")
    public ResponseEntity<?> addCuisine(@RequestBody Dish dish, HttpServletRequest httpServletRequest) throws UserNotFoundException, CuisineAlreadyExistsException {
        try {
            System.out.println("Header" + httpServletRequest.getHeader("Authorization"));
            Claims claims = (Claims) httpServletRequest.getAttribute("claims");
            String email = claims.getSubject();
            System.out.println("Email :: " + email);
            return new ResponseEntity<>(this.favouriteService.addDishToUser(email, dish), HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (CuisineAlreadyExistsException e) {
            return new ResponseEntity<>("Cuisine already added",HttpStatus.OK);
        }
    }

    @DeleteMapping("/favourite/deleteShop/{shopName}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable String shopName, HttpServletRequest httpServletRequest) throws UserNotFoundException, RestaurantNotFoundException {
        try {
            System.out.println("Header" + httpServletRequest.getHeader("Authorization"));
            Claims claims = (Claims) httpServletRequest.getAttribute("claims");
            String email = claims.getSubject();
            System.out.println("Email :: " + email);
            return new ResponseEntity<>(this.favouriteService.deleteShopFromUser(email, shopName), HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (RestaurantNotFoundException e) {
            throw new RestaurantNotFoundException();
        }
    }

    @DeleteMapping("/favourite/deleteDish/{dishName}")
    public ResponseEntity<?> deleteDish(@PathVariable String dishName, HttpServletRequest httpServletRequest) throws UserNotFoundException, CuisineNotFoundException {
        try {
            System.out.println("Header" + httpServletRequest.getHeader("Authorization"));
            Claims claims = (Claims) httpServletRequest.getAttribute("claims");
            String email = claims.getSubject();
            System.out.println("Email :: " + email);
            return new ResponseEntity<>(this.favouriteService.deleteDishFromUser(email, dishName), HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (CuisineNotFoundException e) {
            throw new CuisineNotFoundException();
        }
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(HttpServletRequest httpServletRequest) throws UserNotFoundException{
        try {
            System.out.println("Header" + httpServletRequest.getHeader("Authorization"));
            Claims claims = (Claims) httpServletRequest.getAttribute("claims");
            String email = claims.getSubject();
            System.out.println("Email :: " + email);
            return new ResponseEntity<>(this.favouriteService.deleteUser(email), HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
    }
}
