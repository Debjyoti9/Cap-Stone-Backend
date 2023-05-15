package com.bej.userauthenticationservice.security;



import com.bej.userauthenticationservice.domain.Merchant;

import java.util.Map;

public interface SecurityTokenGeneratorMerchant {
    Map<String, String> createToken(Merchant merchant);
}
