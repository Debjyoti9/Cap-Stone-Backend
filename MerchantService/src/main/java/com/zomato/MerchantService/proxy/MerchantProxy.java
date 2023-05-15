package com.zomato.MerchantService.proxy;



import com.zomato.MerchantService.domain.Merchant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "merchantauthenticationservice",url = "http://localhost:8087")
public interface MerchantProxy {

    @PostMapping("/v4/merchant")
    public ResponseEntity<?> saveMerchant(@RequestBody Merchant merchant);
}
