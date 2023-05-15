package com.bej.userauthenticationservice.service;


import com.bej.userauthenticationservice.domain.Merchant;
import com.bej.userauthenticationservice.exception.UserAlreadyExistsException;
import com.bej.userauthenticationservice.repository.MerchantRepository;
import com.bej.userauthenticationservice.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

@Autowired
private MerchantRepository merchantRepository;

    @Override
    public Merchant saveMerchant(Merchant merchant) throws UserAlreadyExistsException {
        if(merchantRepository.findById(merchant.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        System.out.println(merchant);
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant findByEmailAndPassword(String email, String password) throws InvalidCredentialsException {
        System.out.println("email : "+email);
        System.out.println("password : "+password);
        Merchant loggedInMerchant = merchantRepository.findByEmailAndPassword(email,password);
        System.out.println(loggedInMerchant);

        return loggedInMerchant;
    }
}
