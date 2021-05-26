package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.entities.concretes.EmailVerification;
import com.padel.HRMS.entities.concretes.User;

public interface EmailVerificationService {
    void generateCode(EmailVerification code, Integer id);
    Result verify(String verificationCode, Integer id);
}
