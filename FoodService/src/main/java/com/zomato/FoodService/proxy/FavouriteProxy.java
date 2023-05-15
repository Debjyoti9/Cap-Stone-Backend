package com.zomato.FoodService.proxy;

import com.zomato.FoodService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "favouriteservice",url = "http://localhost:8090")
public interface FavouriteProxy {
    @PostMapping("/v5/saveUser")
    public ResponseEntity<?> saveUserFavourite(@RequestBody User user);
}
