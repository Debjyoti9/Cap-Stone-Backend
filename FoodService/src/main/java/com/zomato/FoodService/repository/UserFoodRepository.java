package com.zomato.FoodService.repository;

import com.zomato.FoodService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserFoodRepository extends MongoRepository<User,String> {

    User findByEmail(String email);
}
