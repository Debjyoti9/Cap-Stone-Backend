package com.bej.userauthenticationservice.domain;

import javax.persistence.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.List;
@Entity
public class Merchant {
    @Id
    private String email;
    private String merchantName;
    private String password;


    public Merchant() {
    }

    public Merchant(String email, String merchantName, String password) {
        this.email = email;
        this.merchantName = merchantName;
        this.password = password;

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

}
