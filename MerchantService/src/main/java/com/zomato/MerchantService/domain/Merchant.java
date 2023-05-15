package com.zomato.MerchantService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Merchant {

    @Id
    private String email;
    private String merchantName;
    private String password;
    private List<Shop> shopList;
    private String img;

    public Merchant() {
    }

    public Merchant(String email, String merchantName, String password, List<Shop> shopList, String img) {
        this.email = email;
        this.merchantName = merchantName;
        this.password = password;
        this.shopList = shopList;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
