package com.zomato.FoodService.service;

import com.zomato.FoodService.domain.Dish;
import com.zomato.FoodService.domain.User;
import com.zomato.FoodService.exception.DishAlreadyExistsException;
import com.zomato.FoodService.exception.UserAlreadyExistsException;
import com.zomato.FoodService.notification.FoodDTO;
import com.zomato.FoodService.proxy.FavouriteProxy;
import com.zomato.FoodService.proxy.UserProxy;
import com.zomato.FoodService.repository.UserFoodRepository;
import org.json.simple.JSONObject;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Service
public class UserFoodService implements IFoodService {


    @Autowired
    UserFoodRepository userFoodRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange directExchange;

    @Autowired
    FavouriteProxy favouriteProxy;

    @Autowired
    UserProxy userProxy;

    @Override
    public User getUserDetails(String email) {
        return userFoodRepository.findByEmail(email);

    }

    @Override
    public List<Dish> dishesFromOrderList(String email) {
        User userFromDataBase = userFoodRepository.findByEmail(email);

        return userFromDataBase.getOrderList();
    }

    @Override
    public User register(User user) throws UserAlreadyExistsException {
        if ( userFoodRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }


        User userFromDatabase = userFoodRepository.save(user);
        if (!(userFromDatabase.getEmail().isEmpty())) {
            ResponseEntity responseEntity = userProxy.saveUser(userFromDatabase);
            ResponseEntity responseEntity1 = favouriteProxy.saveUserFavourite(userFromDatabase);
            System.out.println(responseEntity.getBody());
            System.out.println("Body of user in mongo" + responseEntity1.getBody());
        }

        return userFromDatabase;
    }

    @Override
    public List<Dish> addToOrderList(String email, Dish dish) throws DishAlreadyExistsException {

        User userFromDataBase = userFoodRepository.findByEmail(email);

        if (userFromDataBase.getOrderList() == null) {
            userFromDataBase.setOrderList(Arrays.asList(dish));
        }else {
            List<Dish> orderList = userFromDataBase.getOrderList();

            for (int i = 0; i < orderList.size(); i++) {
                if ((orderList.get(i).getDishName().equals(dish.getDishName()))) {
                    throw new DishAlreadyExistsException();
                }
            }
            orderList.add(dish);
            userFromDataBase.setOrderList(orderList);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Order",orderList);
            jsonObject.put("email" ,email);

            FoodDTO foodDTO = new FoodDTO();
            foodDTO.setJsonObject(jsonObject);

            rabbitTemplate.convertAndSend("foodExchange", "food-routing",foodDTO);

        }
        return userFoodRepository.save(userFromDataBase).getOrderList();
    }

    @Override
    public List<Dish> deleteFromOrderList(String email,String dishName){
        User userFromDatabase = userFoodRepository.findByEmail(email);
        List<Dish> orderList = userFromDatabase.getOrderList();
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getDishName().equals(dishName)) {
                orderList.remove(orderList.get(i));
                userFromDatabase.setOrderList(orderList);
                break;
            }
        }
        return userFoodRepository.save(userFromDatabase).getOrderList();
    }

    @Override
    public User deleteAllItemsFromOrderList(String email) {

        User userFromDatabase = userFoodRepository.findByEmail(email);
        List<Dish> orderList = userFromDatabase.getOrderList();
        orderList.removeAll(orderList);
        userFromDatabase.setOrderList(orderList);
        return userFoodRepository.save(userFromDatabase);

    }

}
