package com.bej.userauthenticationservice.security;


import com.bej.userauthenticationservice.domain.Merchant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JWTSecurityTokenGeneratorMerchantImpl implements SecurityTokenGeneratorMerchant {

    @Override
    public Map<String,String> createToken(Merchant merchant) {
        Map<String,String> tokenMap = new HashMap<>();

        String jwtTokenString = Jwts.builder()
                .claim("email",merchant.getEmail()).setSubject(merchant.getEmail())
                .signWith(SignatureAlgorithm.HS256,"mysecret")
                .compact();
        tokenMap.put("token",jwtTokenString);

        tokenMap.put("message", "Login Successful");
        tokenMap.put("emailId", merchant.getEmail());

        return tokenMap;
    }
}
