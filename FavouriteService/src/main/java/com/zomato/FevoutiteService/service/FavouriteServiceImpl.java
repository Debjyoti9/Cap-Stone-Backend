package com.zomato.FevoutiteService.service;

import com.zomato.FevoutiteService.exception.*;
import com.zomato.FevoutiteService.repository.FavouriteServiceRepository;
import com.zomato.FevoutiteService.domain.Dish;
import com.zomato.FevoutiteService.domain.Shop;
import com.zomato.FevoutiteService.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FavouriteServiceImpl implements FavouriteService{

    private FavouriteServiceRepository favouriteServiceRepository;

    @Autowired
    public FavouriteServiceImpl(FavouriteServiceRepository favouriteServiceRepository){
        this.favouriteServiceRepository = favouriteServiceRepository;
    }

    @Override
    public User saveUserData(User user) {
            return this.favouriteServiceRepository.save(user);
    }

    @Override
    public User getUser(String email) throws UserNotFoundException {
        if (this.favouriteServiceRepository.findById(email).isEmpty())
            throw new UserNotFoundException();
        return this.favouriteServiceRepository.findById(email).get();
    }

    @Override
    public List<Shop> getShops(String email) {
        User userFromDataBase = favouriteServiceRepository.findByEmail(email);
        return userFromDataBase.getShopList();
    }

    @Override
    public List<Dish> getDishes(String email) {
        User userFromDataBase = favouriteServiceRepository.findByEmail(email);
        return userFromDataBase.getDishList();
    }

    @Override
    public List<Shop> addShopToUser(String email, Shop shop) throws RestaurantAlreadyExistsException, UserNotFoundException {
        User userFromDataBase = favouriteServiceRepository.findByEmail(email);

        List<Shop> shopList= userFromDataBase.getShopList();

        if (shopList == null) {
            userFromDataBase.setShopList(Arrays.asList(shop));
        }else {
            for (int i = 0; i < shopList.size(); i++) {
                if (shopList.get(i).getShopName().equals(shop.getShopName())) {
                    throw new RestaurantAlreadyExistsException();
                }
            }
            shopList.add(shop);
            userFromDataBase.setShopList(shopList);


        }
          return favouriteServiceRepository.save(userFromDataBase).getShopList();
    }

    @Override
    public List<Dish> addDishToUser(String email, Dish dish) throws CuisineAlreadyExistsException, UserNotFoundException {
        User userFromDataBase = favouriteServiceRepository.findByEmail(email);

        List<Dish> dishList = userFromDataBase.getDishList();

        if (dishList == null) {
            userFromDataBase.setCuisineList(Arrays.asList(dish));
        }else {
            for (int i = 0; i < dishList.size(); i++) {
                if (dishList.get(i).getDishName().equals(dish.getDishName())) {
                    throw new CuisineAlreadyExistsException();
                }

            }
            dishList.add(dish);
            userFromDataBase.setCuisineList(dishList);

        }
        return favouriteServiceRepository.save(userFromDataBase).getDishList();
    }

    @Override
    public List<Shop> deleteShopFromUser(String email, String shopName) throws RestaurantNotFoundException, UserNotFoundException {
        User userFromDataBase = favouriteServiceRepository.findByEmail(email);

        List<Shop> shopList = userFromDataBase.getShopList();

        for (int i = 0; i < shopList.size(); i++) {
            if (shopList.get(i).getShopName().equals(shopName)) {
                shopList.remove(shopList.get(i));
                userFromDataBase.setShopList(shopList);
                break;
            }
        }

        return favouriteServiceRepository.save(userFromDataBase).getShopList();
    }

    @Override
    public List<Dish> deleteDishFromUser(String email, String dishName) throws CuisineNotFoundException, UserNotFoundException {
        User userFromDataBase = favouriteServiceRepository.findByEmail(email);

        List<Dish> dishList = userFromDataBase.getDishList();


        for (int i = 0; i < dishList.size(); i++) {
            if (dishList.get(i).getDishName().equals(dishName)) {
                dishList.remove(dishList.get(i));
                userFromDataBase.setCuisineList(dishList);
                break;
            }
        }
        return favouriteServiceRepository.save(userFromDataBase).getDishList();
    }

    @Override
    public User deleteUser(String email) throws UserNotFoundException {
        if (this.favouriteServiceRepository.findById(email).isEmpty())
            throw new UserNotFoundException();
        User user1 = this.favouriteServiceRepository.findById(email).get();
        this.favouriteServiceRepository.deleteById(email);
        return user1;
    }
}
