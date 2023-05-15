package com.zomato.FoodService.proxy;


import com.zomato.FoodService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "userauthenticationservice",url = "http://localhost:8086")
public interface UserProxy {

    @PostMapping("/v3/user")
    public ResponseEntity<?> saveUser(@RequestBody User user);


}
