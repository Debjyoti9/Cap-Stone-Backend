package com.zomato.FevoutiteService.repository;

import com.zomato.FevoutiteService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteServiceRepository extends MongoRepository<User,String> {

    User findByEmail(String email);
}
