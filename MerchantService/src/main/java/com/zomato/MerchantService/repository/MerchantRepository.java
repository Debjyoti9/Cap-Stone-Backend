package com.zomato.MerchantService.repository;

import com.zomato.MerchantService.domain.Merchant;
import com.zomato.MerchantService.domain.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends MongoRepository<Merchant,String> {

    Merchant findByEmail(String email);
}
