package com.zomato.MerchantService.repository;

import com.zomato.MerchantService.domain.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends MongoRepository<Shop,String> {
    Shop findByShopName(String shopName);
}
