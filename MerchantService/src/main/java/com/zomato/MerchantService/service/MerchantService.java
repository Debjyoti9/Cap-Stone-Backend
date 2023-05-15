package com.zomato.MerchantService.service;

import com.zomato.MerchantService.domain.Merchant;
import com.zomato.MerchantService.domain.Shop;
import com.zomato.MerchantService.exception.MerchantAlreadyExistsException;
import com.zomato.MerchantService.exception.ShopAlreadyExistsException;
import com.zomato.MerchantService.exception.ShopNotFoundException;
import com.zomato.MerchantService.proxy.MerchantProxy;
import com.zomato.MerchantService.repository.MerchantRepository;
import com.zomato.MerchantService.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MerchantService implements IMerchantService {

    @Autowired
    MerchantRepository merchantRepository;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    MerchantProxy merchantProxy;

    @Override
    public Merchant register(Merchant merchant) throws MerchantAlreadyExistsException {
        if ( merchantRepository.findById(merchant.getEmail()).isPresent()) {
            throw new MerchantAlreadyExistsException();
        }

        Merchant merchantFromDatabase = merchantRepository.save(merchant);
        if (!(merchantFromDatabase.getEmail().isEmpty())) {
            ResponseEntity responseEntity = merchantProxy.saveMerchant(merchantFromDatabase);
            System.out.println(responseEntity.getBody());
        }

        return merchantFromDatabase;
    }

    @Override
    public List<Shop> getAllShopsOfMerchant(String email) throws ShopNotFoundException {
        Merchant merchant = merchantRepository.findByEmail(email);
        return merchant.getShopList();

    }

    @Override
    public Shop getSingleShopFromAllShops(String shopName) {
        return shopRepository.findByShopName(shopName);
    }

    @Override
    public Merchant getMerchant(String email) {
        return merchantRepository.findByEmail(email);

    }

    @Override
    public List<Shop> addShop(String email, Shop shop) throws ShopAlreadyExistsException {
        Merchant merchantFromDatabase = merchantRepository.findByEmail(email);


        List<Shop> shopListOfMerchant = merchantFromDatabase.getShopList();
        List<Shop> allShop = shopRepository.findAll();

        if (shopListOfMerchant == null) {
            merchantFromDatabase.setShopList(Arrays.asList(shop));
        }else {
            for (int i = 0; i < shopListOfMerchant.size(); i++) {
                if (shopListOfMerchant.get(i).getShopName().equalsIgnoreCase(shop.getShopName())) {
                    throw new ShopAlreadyExistsException();

                }

            }

            for (int i = 0; i < allShop.size(); i++) {
                if(allShop.get(i).getShopName().equalsIgnoreCase(shop.getShopName())) {
                    throw new ShopAlreadyExistsException();
                }
            }
            shopListOfMerchant.add(shop);

            merchantFromDatabase.setShopList(shopListOfMerchant); //saving shop in merchant profile
            shopRepository.save(shop); //saving shop in main shop list
        }



        return merchantRepository.save(merchantFromDatabase).getShopList(); //Last done
    }

    //start controller layer

    @Override
    public List<Shop> allShops() throws ShopNotFoundException {
        return shopRepository.findAll();
    }

    @Override
    public List<Shop> deleteShop(String email, String shopName) {
        Merchant merchant = merchantRepository.findByEmail(email);

        List<Shop> shopListOfMerchant = merchant.getShopList();
        List<Shop> allShopsList = shopRepository.findAll(); // start from here
        System.out.println(allShopsList);

        for (int i = 0; i < shopListOfMerchant.size(); i++) {
            if (shopListOfMerchant.get(i).getShopName().equals(shopName)) {

                shopRepository.deleteById(shopListOfMerchant.get(i).getShopName());

                shopListOfMerchant.remove(shopListOfMerchant.get(i));
                merchant.setShopList(shopListOfMerchant);

                break;
            }
        }

        return merchantRepository.save(merchant).getShopList();
    }

}
