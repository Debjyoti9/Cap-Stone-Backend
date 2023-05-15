package com.bej.userauthenticationservice.repository;

import com.bej.userauthenticationservice.domain.Merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant,String> {

    Merchant findByEmailAndPassword(String email, String password);
}
