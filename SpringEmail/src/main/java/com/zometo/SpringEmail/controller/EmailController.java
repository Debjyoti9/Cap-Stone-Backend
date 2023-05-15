package com.zometo.SpringEmail.controller;


import com.zometo.SpringEmail.domain.EmailDetails;
import com.zometo.SpringEmail.service.EmailService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/v7")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Sending a simple Email
    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody EmailDetails details, HttpServletRequest request) {

        System.out.println("header" + request.getHeader("Authorization"));
        Claims claims = (Claims) request.getAttribute("claims");
        System.out.println("email from claims :: " + claims.getSubject());
        String email = claims.getSubject();
        System.out.println("email :: "+email);


        return new ResponseEntity<>(emailService.sendSimpleMail(details,email), HttpStatus.OK);
    }

}