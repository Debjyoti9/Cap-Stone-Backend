package com.zometo.SpringEmail.service;

import com.zometo.SpringEmail.domain.EmailDetails;

public interface IEmailService {
    String sendSimpleMail(EmailDetails emailDetails, String email);
//    String sendMailWithAttachment(EmailDetails details);
}
