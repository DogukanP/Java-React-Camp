package com.padel.HRMS.api.controllers;

import com.padel.HRMS.business.abstracts.EmailVerificationService;
import com.padel.HRMS.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class EmailVerifyController {
    private EmailVerificationService emailVerificationService;


    @Autowired
    public EmailVerifyController(EmailVerificationService emailVerificationService) {
        super();
        this.emailVerificationService = emailVerificationService;
    }



    @PostMapping("/update/{verificationCode}/{id}")
    public Result setVerify(@RequestParam String verificationCode, @RequestParam Integer id) {
        return emailVerificationService.verify(verificationCode,id);
    }
}
