package com.zomato.MerchantService.service;

import com.zomato.MerchantService.domain.Merchant;
import com.zomato.MerchantService.domain.Shop;
import com.zomato.MerchantService.exception.MerchantAlreadyExistsException;
import com.zomato.MerchantService.exception.ShopAlreadyExistsException;
import com.zomato.MerchantService.exception.ShopNotFoundException;

import java.util.List;

public interface IMerchantService {

    Merchant register(Merchant merchant) throws MerchantAlreadyExistsException;
    List<Shop> getAllShopsOfMerchant(String email) throws ShopNotFoundException;
    Shop getSingleShopFromAllShops(String shopName);
    Merchant getMerchant(String email);
    List<Shop> addShop(String email,Shop shop) throws ShopAlreadyExistsException;
    List<Shop> allShops() throws ShopNotFoundException;
    List<Shop> deleteShop(String email,String shopName);
}
